package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PROFILE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id", nullable = false)
    private Long id;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "CONTACT_NO", nullable = false, unique = true)
    private Long contactNo;

    @OneToOne(mappedBy = "profile", orphanRemoval = true)
    private User user;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "occupation", length = 28)
    private String occupation;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProfileApartment> profileApartments = new LinkedHashSet<>();


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profile")
    private Set<Family> families = new LinkedHashSet<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vehicle> vehicles = new LinkedHashSet<>();

    @Lob
    @Column(name = "photo_id")
    private Blob photoId;

}