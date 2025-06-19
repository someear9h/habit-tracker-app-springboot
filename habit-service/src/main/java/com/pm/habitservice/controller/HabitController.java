package com.pm.habitservice.controller;

import com.pm.habitservice.dto.HabitRequestDTO;
import com.pm.habitservice.dto.HabitResponseDTO;
import com.pm.habitservice.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {
    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public ResponseEntity<List<HabitResponseDTO>> getHabits() {
        List<HabitResponseDTO> habits = habitService.getHabits();
        return ResponseEntity.ok().body(habits);
    }

    @PostMapping
    public ResponseEntity<HabitResponseDTO> createHabit(
            @Valid @RequestBody HabitRequestDTO habitRequestDTO) {

        HabitResponseDTO habitResponseDTO = habitService.createHabit(habitRequestDTO);
        return ResponseEntity.ok().body(habitResponseDTO);
    }
}
