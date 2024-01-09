package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_Id", nullable = false)
    private Long facilityId;

    @Column(length = 16)
    private String name;
    private String type; // e.g., 'Gym', 'Pool', 'Community Hall'
    private String location; // Description or identifier of the facility's location
    private boolean isAvailable; // Indicates if the facility is currently available for use

    // If booking/reservations are required for facilities
    @OneToMany(mappedBy = "facility", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FacilityBooking> bookings = new HashSet<>();

    @Column(name = "rules_and_regualtions")
    private String rulesAndRegualtions;

}