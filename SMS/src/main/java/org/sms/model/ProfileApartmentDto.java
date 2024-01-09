package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.sms.entities.ProfileApartment}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileApartmentDto implements Serializable {
    Long profileApartmentId;
    String residencyType;
    LocalDateTime endDate;
    LocalDateTime startDate;
}