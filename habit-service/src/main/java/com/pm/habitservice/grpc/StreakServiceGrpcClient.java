package com.pm.habitservice.grpc;

import streak.StreakRequest;
import streak.StreakResponse;
import streak.StreakServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StreakServiceGrpcClient {

    private static final Logger log = LoggerFactory.getLogger(StreakServiceGrpcClient.class);

    private final StreakServiceGrpc.StreakServiceBlockingStub blockingStub;

    public StreakServiceGrpcClient(
            @Value("${streak.service.address:localhost}") String serverAddress,
            @Value("${streak.service.grpc.port:9010}") int serverPort) {

        log.info("Connecting to Streak Service gRPC at {}:{}", serverAddress, serverPort);

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();

        this.blockingStub = StreakServiceGrpc.newBlockingStub(channel);
    }

    public StreakResponse updateStreak(String habitId, String habitName, String habitDate) {
        StreakRequest request = StreakRequest.newBuilder()
                .setHabitId(habitId)
                .setHabitName(habitName)
                .setHabitDate(habitDate)  // format must be yyyy-MM-dd
                .build();

        log.info("Sending gRPC request to StreakService: {}", request);

        StreakResponse response = blockingStub.updateStreak(request);

        log.info("Received gRPC response: {}", response);
        return response;
    }
}