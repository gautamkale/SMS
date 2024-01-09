package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "USER")
public class  User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "USER_NAME", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "PASSWORD", nullable = false, unique = true, length = 50)
    private String password;

    @Column(name = "EMAIL_ID", nullable = false, unique = true)
    private String emailId;

    @Column(name = "account_status", length = 16)
    private String accountStatus; //e.g., Active, Inactive, Suspended

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @OneToOne( cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "PROFILE_ID")
    private Profile profile;

    @OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Notice> notices = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Apartment> apartments = new HashSet<>();

    @OneToMany(mappedBy = "raisedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Complaint> complaints = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Participation> participations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "uploadedBy", orphanRemoval = true)
    private Set<Document> documents = new LinkedHashSet<>();

/*    @OneToMany(mappedBy = "assignedTo", orphanRemoval = true)
    private Set<MaintenanceTask> maintenanceTaskse = new LinkedHashSet<>();*/

    @OneToMany(mappedBy = "requestedBy", orphanRemoval = true)
    private Set<MaintenanceTask> maintenanceTasks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "organiser", orphanRemoval = true)
    private Set<Event> events = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<BillingAccount> billingAccounts = new LinkedHashSet<>();

}