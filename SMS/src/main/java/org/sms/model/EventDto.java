package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;
import org.sms.entities.Participation;
import org.sms.entities.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link org.sms.entities.Event}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDto implements Serializable {
    Long eventId;
    String venue;
    LocalDateTime eventDate;
    String eventDescription;
    String evenName;
    String evenType;
    Set<Participation> participations;
    User organiser;
    ContactInformationDto contactPerson;
    String note;
    BigDecimal budget;
}