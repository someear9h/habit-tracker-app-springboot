package com.pm.habitservice.mapper;

import com.pm.habitservice.dto.HabitRequestDTO;
import com.pm.habitservice.dto.HabitResponseDTO;
import com.pm.habitservice.model.Habit;

import java.time.LocalDate;

public class HabitMapper {
    public static HabitResponseDTO toDTO(Habit habit) {
        HabitResponseDTO habitDTO = new HabitResponseDTO();
        habitDTO.setId(habit.getId().toString());
        habitDTO.setName(habit.getName());
        habitDTO.setDescription(habit.getDescription());
        habitDTO.setEmail(habit.getEmail());
        habitDTO.setHabitDate(habit.getHabitDate().toString());

        return habitDTO;
    }

    public static Habit toModel(HabitRequestDTO habitRequestDTO) {
        Habit habit = new Habit();
        habit.setName(habitRequestDTO.getName());
        habit.setDescription(habitRequestDTO.getDescription());
        habit.setEmail(habitRequestDTO.getEmail());
        habit.setHabitDate(LocalDate.parse(habitRequestDTO.getHabitDate().toString()));
        return habit;
    }
}
