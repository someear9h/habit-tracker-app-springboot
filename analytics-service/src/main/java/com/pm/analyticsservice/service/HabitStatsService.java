package com.pm.analyticsservice.service;

import habit.events.HabitEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class HabitStatsService {
    private static final Logger log = LoggerFactory.getLogger(HabitStatsService.class);

    // email -> habit count
    private final Map<String, Integer> habitCounts = new ConcurrentHashMap<>();

    public void updateStats(HabitEvent event) {
        String email = event.getEmail();

        // increment habit count for this user
        habitCounts.merge(email, 1, Integer::sum);

        log.info("Updated stats: {} has now created {} habits",
                email, habitCounts.get(email));
    }
}
