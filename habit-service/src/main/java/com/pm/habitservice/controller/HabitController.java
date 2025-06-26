package com.pm.habitservice.controller;

import com.pm.habitservice.dto.HabitRequestDTO;
import com.pm.habitservice.dto.HabitResponseDTO;
import com.pm.habitservice.service.HabitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/habits")
@Tag(name = "Habit", description = "API for managing habits")
public class HabitController {
    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    @Operation(summary = "get habits")
    public ResponseEntity<List<HabitResponseDTO>> getHabits() {
        List<HabitResponseDTO> habits = habitService.getHabits();
        return ResponseEntity.ok().body(habits);
    }

    @PostMapping
    @Operation(summary = "create a habit")
    public ResponseEntity<HabitResponseDTO> createHabit(
            @Valid @RequestBody HabitRequestDTO habitRequestDTO) {

        HabitResponseDTO habitResponseDTO = habitService.createHabit(habitRequestDTO);
        return ResponseEntity.ok().body(habitResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update a habit")
    public ResponseEntity<HabitResponseDTO> updatePatient(
            @PathVariable UUID id, @RequestBody HabitRequestDTO habitRequestDTO) {
        HabitResponseDTO habitResponseDTO = habitService.updateHabit(id, habitRequestDTO);

        return ResponseEntity.ok().body(habitResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a habit")
    public ResponseEntity<Void> deleteHabit(@PathVariable UUID id) {
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
