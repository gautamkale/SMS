package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "venue", length = 28)
    private String venue;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "even_name", length = 50)
    private String evenName;

    @Column(name = "even_type", length = 50)
    private String evenType; //(e.g., Meeting, Cultural Festival, Sports Event, Workshop).

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Participation> participations = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "organiser_id")
    private User organiser;

    @Embedded
    private ContactInformation contactPerson;

    @Column(name = "note", length = 28)
    private String note;

    @Column(name = "budget", precision = 19, scale = 2)
    private BigDecimal budget;

}