package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.sms.entities.Complaint}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComplaintDto implements Serializable {
    Long complaintId;
    String resolution;
    LocalDateTime dateResolved;
    LocalDateTime dateFiled;
    LocalDateTime resolutionDate;
    String status;
    String description;
    String subject;
    String category;
    String feedback;
    String priorityLevel;
    String location;
}