package com.pm.habitservice.repository;

import com.pm.habitservice.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HabitRepository extends JpaRepository<Habit, UUID> {
}
