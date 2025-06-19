package com.pm.habitservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Purpose = receive request data (from POST/PUT API calls), e.g. when user sends "create new habit".
public class HabitRequestDTO {
    @NotBlank(message = "Name is Required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    private String description;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "habit date is required")
    private String habitDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHabitDate() {
        return habitDate;
    }

    public void setHabitDate(String habitDate) {
        this.habitDate = habitDate;
    }
}
