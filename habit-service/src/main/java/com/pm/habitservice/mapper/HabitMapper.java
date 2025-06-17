package com.pm.habitservice.mapper;

import com.pm.habitservice.dto.HabitResponseDTO;
import com.pm.habitservice.model.Habit;

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
}
