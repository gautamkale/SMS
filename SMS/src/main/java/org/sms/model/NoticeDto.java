package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.sms.entities.Notice}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoticeDto implements Serializable {
    Long noticeId;
    LocalDateTime datePosted;
    String title;
    Boolean visibility;
    Boolean acknowledgementRequired;
    String description;
    String category;
    LocalDate effectiveDate;
    LocalDateTime expiryDate;
    String urgencyLevel;
    String targetAudience;
    String status;
}