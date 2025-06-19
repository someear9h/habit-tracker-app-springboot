package com.pm.habitservice.service;

import com.pm.habitservice.dto.HabitRequestDTO;
import com.pm.habitservice.dto.HabitResponseDTO;
import com.pm.habitservice.mapper.HabitMapper;
import com.pm.habitservice.model.Habit;
import com.pm.habitservice.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    private HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
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

        return HabitMapper.toDTO(newHabit);
    }
}
