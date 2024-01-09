package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id", nullable = false)
    private Long documentId;

    @Column(name = "upload_date")
    private LocalDateTime uploadDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User uploadedBy;

    @Column(name = "file_type", length = 5)
    private String fileType;

    @Column(name = "document_type", length = 16)
    private String documentType; //(e.g., Legal, Financial, Meeting Minutes, Notice, Maintenance Record

    @Column(name = "title", length = 16)
    private String title;

    @Column(name = "path")
    private String path;

    @Column(name = "version")
    private Integer version;

    @Column(name = "note", length = 50)
    private String note;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}