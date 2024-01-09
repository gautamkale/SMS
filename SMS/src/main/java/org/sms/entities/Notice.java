package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id", nullable = false)
    private Long noticeId;

    @Column(name = "date_posted")
    private LocalDateTime datePosted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User postedBy ;

    @Column(name = "title")
    private String title;

    @Column(name = "visibility")
    private Boolean visibility; // public (visible to all residents) or private (visible to specific individuals or groups).

    @Column(name = "acknowledgement_required")
    private Boolean acknowledgementRequired;

    @Column(name = "description")
    private String description;

    @Column(name = "category", length = 50)
    private String category; //., General Information, Maintenance, Event, Emergency

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column(name = "urgency_level")
    private String urgencyLevel; // .g., Normal, Urgent

    @Column(name = "target_audience", length = 50)
    private String targetAudience;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    @Column(name = "status", length = 28)
    private String status; //e.g., Active, Expired, Archived

}