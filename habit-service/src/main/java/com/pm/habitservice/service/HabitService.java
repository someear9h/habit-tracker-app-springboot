package com.pm.habitservice.service;

import com.pm.habitservice.dto.HabitRequestDTO;
import com.pm.habitservice.dto.HabitResponseDTO;
import com.pm.habitservice.exception.HabitNotFoundException;
import com.pm.habitservice.grpc.StreakServiceGrpcClient;
import com.pm.habitservice.kafka.KafkaProducer;
import com.pm.habitservice.mapper.HabitMapper;
import com.pm.habitservice.model.Habit;
import com.pm.habitservice.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final StreakServiceGrpcClient streakServiceGrpcClient;
    private final KafkaProducer kafkaProducer;

    public HabitService(HabitRepository habitRepository, StreakServiceGrpcClient streakServiceGrpcClient, KafkaProducer kafkaProducer) {
        this.habitRepository = habitRepository;
        this.streakServiceGrpcClient = streakServiceGrpcClient;
        this.kafkaProducer = kafkaProducer;
    }

    public List<HabitResponseDTO> getHabits() {
        List<Habit> habits = habitRepository.findAll();

        List<HabitResponseDTO> habitResponseDTOs = habits.stream()
                .map(HabitMapper::toDTO).toList();

        return habitResponseDTOs;
    }

    public HabitResponseDTO createHabit(HabitRequestDTO habitRequestDTO) {
        Habit newHabit = habitRepository.save(
                HabitMapper.toModel(habitRequestDTO));

        // kafka event
        kafkaProducer.sendEvent(newHabit);

        return HabitMapper.toDTO(newHabit);
    }

    public HabitResponseDTO updateHabit(UUID id, HabitRequestDTO habitRequestDTO) {
        Habit habit = habitRepository.findById(id).orElseThrow(
                () -> new HabitNotFoundException("Habit not found with id: " + id));

        // Update habit fields
        habit.setName(habitRequestDTO.getName());
        habit.setDescription(habitRequestDTO.getDescription());
        habit.setEmail(habitRequestDTO.getEmail());
        habit.setHabitDate(LocalDate.parse(habitRequestDTO.getHabitDate()));

        Habit updatedHabit = habitRepository.save(habit);

        // Call gRPC to update streak
        try {
            streakServiceGrpcClient.updateStreak(
                    updatedHabit.getId().toString(),
                    updatedHabit.getName(),
                    updatedHabit.getHabitDate().toString()
            );
        } catch (Exception e) {
            // Optional: Log or handle gRPC failure gracefully
            System.err.println("Failed to update streak via gRPC: " + e.getMessage());
        }

        return HabitMapper.toDTO(updatedHabit);
    }


    public void deleteHabit(UUID id) {
        Habit habit = habitRepository.findById(id).orElseThrow(
                () -> new HabitNotFoundException("Habit not found with id: " + id));

        habitRepository.delete(habit);
    }
}
