package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "resedence_status", length = 16)
    private String resedenceStatus;

    @Column(name = "contact_no")
    private Long contactNo;

    @Column(name = "relation_type", length = 16)
    private String relationType;

    @Column(name = "last_name", length = 16)
    private String lastName;

    @Column(name = "name", length = 16)
    private String firstName;

    @ManyToOne
    @JoinColumn(name = "profile_profile_id")
    private Profile profile;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vehicle> vehicles = new LinkedHashSet<>();

}