package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.sms.entities.Document}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentDto implements Serializable {
    Long documentId;
    LocalDateTime uploadDate;
    String fileType;
    String documentType;
    String title;
    String path;
    Integer version;
    String note;
}