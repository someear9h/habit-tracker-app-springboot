package com.pm.habitservice.dto;

//outgoing data → when server returns data to client
public class HabitResponseDTO {
    private String id;
    private String name;
    private String description;
    private String email;
    private String habitDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
