package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import com.pm.analyticsservice.service.HabitStatsService;
import habit.events.HabitEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    private final HabitStatsService habitStatsService;

    public KafkaConsumer(HabitStatsService habitStatsService) {
        this.habitStatsService = habitStatsService;
    }

    @KafkaListener(topics = "habit", groupId = "analytics-service")
    public void consumeEvent(byte[] event) {
        try {
            HabitEvent habitEvent = HabitEvent.parseFrom(event);

            // Log and process event
            log.info("Received Habit Event: [HabitId={}, HabitName={}, Email={}, Type={}]",
                    habitEvent.getHabitId(),
                    habitEvent.getName(),
                    habitEvent.getEmail(),
                    habitEvent.getEventType());

            habitStatsService.updateStats(habitEvent);

        } catch(InvalidProtocolBufferException e) {
            log.error("Error deserializing HabitEvent: {}", e.getMessage());
        }
    }
}
