package com.scheduler;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {

    @Test
    void testIsDeparted_falseForFutureFlight() {
        //Future flight
        Flight flight = new Flight(
                "TEST1",
                LocalDateTime.now().plusDays(1),
                ZoneId.of("Europe/London")
        );

        assertFalse(flight.isDeparted());
    }

    @Test
    void testIsDeparted_trueForPastFlight() {
        // Past flight
        Flight flight = new Flight(
                "TEST2",
                LocalDateTime.now().minusDays(1),
                ZoneId.of("Europe/London")
        );

        assertTrue(flight.isDeparted());
    }

    @Test
    void testUpdateStatus_changesToDeparted() {
        Flight flight = new Flight(
                "TEST3",
                LocalDateTime.now().minusHours(2),
                ZoneId.of("Europe/London")
        );

        assertEquals(FlightStatus.SCHEDULED, flight.getStatus());
        flight.updateStatus();
        assertEquals(FlightStatus.DEPARTED, flight.getStatus());
    }

    @Test
    void testUpdateStatus_doesNotChangeIfNotDeparted() {
        Flight flight = new Flight(
                "TEST4",
                LocalDateTime.now().plusHours(2),
                ZoneId.of("Europe/London")
        );

        assertEquals(FlightStatus.SCHEDULED, flight.getStatus());

        flight.updateStatus();

        assertEquals(FlightStatus.SCHEDULED, flight.getStatus());
    }

    @Test
    void testPrintFlightDetails_outputsCorrectly() {
        Flight flight = new Flight(
                "TEST5",
                LocalDateTime.of(2025, 6, 9, 17, 0),
                ZoneId.of("Europe/London")
        );
    }

}
