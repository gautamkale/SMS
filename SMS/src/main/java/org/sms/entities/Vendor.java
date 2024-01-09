package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id", nullable = false)
    private Long vendorId;

    @Column(name = "vender_name", length = 16)
    private String venderName;

    @Column(name = "service_type", length = 16)
    private String serviceType; //(e.g., cleaning, security, maintenance

    @Embedded
    private ContactInformation contactInformation;

    @Column(name = "address")
    private String address;

    @Column(name = "emergency_contact", length = 13)
    private String emergencyContact;

    @Column(name = "performance_rating")
    private Integer performanceRating;

    @Column(name = "status", length = 10)
    private String status; //., ACTIVE, INACTIVE, UNDER_REVIEW)

    @Column(name = "notes")
    private String notes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private Document document;

    @OneToMany(mappedBy = "assignedTo", orphanRemoval = true)
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

}