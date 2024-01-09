package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id", nullable = false)
    private Long complaintId;

    @Column(name = "resolution")
    private String resolution;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User raisedBy;

    @Column(name = "date_resolved")
    private LocalDateTime dateResolved;

    @Column(name = "date_filed")
    private LocalDateTime dateFiled;

    @Column(name = "resolution_date")
    private LocalDateTime resolutionDate;

    @Column(name = "status", length = 16)
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "subject", length = 100)
    private String subject;

    @Column(name = "category", length = 50)
    private String category; //.g., Maintenance, Noise, Security

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "priority_level", length = 28)
    private String priorityLevel; //e.g., High, Medium, Low).

    @Column(name = "location", length = 50)
    private String location;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

}