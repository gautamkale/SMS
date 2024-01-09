package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.sms.entities.MaintenanceTask}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaintenanceTaskDto implements Serializable {
    Long maintenanceTaskId;
    LocalDateTime dateCompleted;
    LocalDateTime dateAssigned;
    String status;
    String description;
    String location;
    String priorityLevel;
    LocalDateTime scheduledDate;
    String feedback;
    LocalDate createdDate;
}