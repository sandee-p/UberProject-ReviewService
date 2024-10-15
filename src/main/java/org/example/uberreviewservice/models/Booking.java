package org.example.uberreviewservice.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

// One booking has a review and a review belongs to a booking
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel {

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Review review; // defining a 1:1 relationship between booking and review.

    //To specify this property is an Enum.Below annotation is used. String to signify it is stored as string in DB.
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    //The @Temporal annotation in Spring Boot is used to specify how a
    // java.util.Date or java.util.Calendar object should be persisted in the database.
    // This annotation is necessary because the Date type in Java includes both date and time,
    // but in many cases, you might only want to persist either the date or the time portion.
    // @Temporal(TemporalType.TIMESTAMP): Stores both date and time
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne // The many side has the foreign key
    private Driver driver;

    @ManyToOne // many bookings will have the same passenger
    private Passenger passenger;


}
