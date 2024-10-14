package org.example.uberreviewservice.models;

//Two ways to store a enum in a DB. As a string or a number.
public enum BookingStatus {

    SCHEDULED,
    CANCELLED,
    CAB_ARRIVED,
    ASSIGNING_DRIVER,
    IN_RIDE,
    COMPLETED
}
