package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Driver;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.BookingRepository;
import org.example.uberreviewservice.repositories.DriverRepository;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final DriverRepository driverRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, DriverRepository driverRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.driverRepository = driverRepository;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public void run(String... args) throws Exception {
//        Review review = Review.builder().
//                rating(5.0).
//                reviewContent("Great Ride Quality").
//                build();
//        reviewRepository.save(review); // this code executes sql query

        //Custom Implementation for N+1 Problem
        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L,2L));
        List<Driver> drivers = driverRepository.findAllById(driverIds);
        List<Booking> bookings = bookingRepository.findAllByDriverIn(drivers);
    }
}
