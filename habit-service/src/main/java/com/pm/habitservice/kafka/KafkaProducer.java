package com.pm.habitservice.kafka;

import com.pm.habitservice.model.Habit;
import habit.events.HabitEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Habit habit) {
        HabitEvent event = HabitEvent.newBuilder()
                .setHabitId(habit.getId().toString())
                .setName(habit.getName())
                .setDescription(habit.getDescription())
                .setHabitDate(habit.getHabitDate().toString())
                .setEventType("HABIT_CREATED")
                .build();

        try {
            kafkaTemplate.send("habit", event.toByteArray());
        } catch (Exception ex) {
            log.error("Error sending HabitCreated event: {}", event);
        }
    }
}