package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class FacilityBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_Id", nullable = false)
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_Id")
    private Facility facility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id") // Assuming you have a User entity for residents
    private User user;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // e.g., 'Confirmed', 'Cancelled'

    // Constructors, getters, setters
}
