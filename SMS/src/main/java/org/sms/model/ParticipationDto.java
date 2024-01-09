package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.sms.entities.Participation}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipationDto implements Serializable {
    Long participationId;
}