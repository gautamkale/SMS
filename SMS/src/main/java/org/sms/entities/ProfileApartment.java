package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "profile_apartment")
public class ProfileApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_apartment_id", nullable = false)
    private Long profileApartmentId;

    @Column(name = "residency_type", length = 25)
    private String residencyType;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileApartment that)) return false;
        return Objects.equals(profileApartmentId, that.profileApartmentId) && Objects.equals(residencyType, that.residencyType) && Objects.equals(endDate, that.endDate) && Objects.equals(startDate, that.startDate) && Objects.equals(profile, that.profile) && Objects.equals(apartment, that.apartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileApartmentId, residencyType, endDate, startDate, profile, apartment);
    }
}