package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "maintenance_task")
public class MaintenanceTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenance_task_id", nullable = false)
    private Long maintenanceTaskId;

/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_to")
    private User assignedTo; //Staff or Vendors */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_to_id")
    private Vendor assignedTo; //Staff or Vendors

    @Column(name = "date_completed")
    private LocalDateTime dateCompleted;

    @Column(name = "date_assigned")
    private LocalDateTime dateAssigned;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "location", length = 16)
    private String location;

    @Column(name = "priority_level", length = 6)
    private String priorityLevel;// (e.g., High, Medium, Low).

    @Column(name = "scheduled_date")
    private LocalDateTime scheduledDate;

    @Column(name = "feedback")
    private String feedback;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private Document document;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requested_by_id")
    private User requestedBy;

    @Column(name = "created_date")
    private LocalDate createdDate;

}