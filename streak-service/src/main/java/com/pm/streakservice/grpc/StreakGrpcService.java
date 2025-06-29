package com.pm.streakservice.grpc;

import streak.StreakRequest;
import streak.StreakResponse;
import streak.StreakServiceGrpc.StreakServiceImplBase;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@GrpcService
public class StreakGrpcService extends StreakServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(StreakGrpcService.class);

    // In-memory DB simulation
    private final Map<String, LocalDate> lastTrackedDateMap = new HashMap<>();
    private final Map<String, Integer> currentStreakMap = new HashMap<>();
    private final Map<String, Integer> maxStreakMap = new HashMap<>();

    @Override
    public void updateStreak(StreakRequest request, StreamObserver<StreakResponse> responseObserver) {
        String habitId = request.getHabitId();
        String habitName = request.getHabitName();
        LocalDate habitDate = LocalDate.parse(request.getHabitDate());

        log.info("updateStreak request received for habit: {} on date: {}", habitName, habitDate);

        // Get the last date the habit was done
        LocalDate lastDate = lastTrackedDateMap.get(habitId);
        int currentStreak = currentStreakMap.getOrDefault(habitId, 0);
        int maxStreak = maxStreakMap.getOrDefault(habitId, 0);

        if (lastDate != null) {
            long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(lastDate, habitDate);
            if (daysBetween == 1) {
                // continued streak
                currentStreak++;
            } else if (daysBetween > 1) {
                // streak broken
                currentStreak = 1;
            } // else if 0, same day, no update needed
        } else {
            // first time tracking
            currentStreak = 1;
        }

        maxStreak = Math.max(maxStreak, currentStreak);

        // update simulated DB
        lastTrackedDateMap.put(habitId, habitDate);
        currentStreakMap.put(habitId, currentStreak);
        maxStreakMap.put(habitId, maxStreak);

        StreakResponse response = StreakResponse.newBuilder()
                .setHabitId(habitId)
                .setCurrentStreak(currentStreak)
                .setMaxStreak(maxStreak)
                .setMessage("Streak updated successfully for habit: " + habitName)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
