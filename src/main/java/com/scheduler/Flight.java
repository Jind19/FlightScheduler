package com.scheduler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Flight {

    private final String flightNumber;
    private final LocalDateTime departureTime;
    private final ZoneId departureZone;
    private FlightStatus status;

    //Constructor


    public Flight(String flightNumber, LocalDateTime departureTime, ZoneId departureZone) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.departureZone = departureZone;
        this.status = FlightStatus.SCHEDULED;
    }

    public boolean isDeparted(){
        ZonedDateTime nowInZone = ZonedDateTime.now(departureZone);
        ZonedDateTime departureDateTimeInZone = departureTime.atZone(departureZone);

        return nowInZone.isAfter(departureDateTimeInZone);
    }

    public void printFlightDetails(){
        System.out.println("Flight: " + flightNumber);
        System.out.println("Departs at: " + departureTime + " " + departureZone);
        System.out.println("Status: " + status);
    }

    public void updateStatus() {
        if (isDeparted() && status == FlightStatus.SCHEDULED)
            status = FlightStatus.DEPARTED;
    }

    //getter for status
    public FlightStatus getStatus() {
        return status;
    }

}
