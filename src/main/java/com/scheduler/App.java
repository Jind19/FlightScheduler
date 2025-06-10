package com.scheduler;


import java.time.LocalDateTime;
import java.time.ZoneId;

public class App {
    public static void main( String[] args ) {

        Flight flight1 = new Flight(
                "BA123",
                LocalDateTime.of(2025, 7, 9, 17, 0),
                ZoneId.of("Europe/London")
        );

        Flight flight2 = new Flight(
                "AA456",
                LocalDateTime.of(2025, 6, 5, 10, 0),
                ZoneId.of("America/New_York")
        );

        Flight flight3 = new Flight(
                "JL789",
                LocalDateTime.of(2025, 6, 10, 23, 9),
                ZoneId.of("Asia/Tokyo")
        );

        System.out.println(flight1.isDeparted());
        System.out.println(flight2.isDeparted());
        System.out.println(flight3.isDeparted());

        // Update status based on current time
        flight1.updateStatus();
        flight2.updateStatus();
        flight3.updateStatus();

        // Print flight details
        System.out.println("Flight Details:\n");
        flight1.printFlightDetails();
        flight2.printFlightDetails();
        flight3.printFlightDetails();

    }
}
