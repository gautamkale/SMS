package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.sms.entities.ContactInformation}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactInformationDto implements Serializable {
    Long contactInfoId;
    String emailId;
    String phoneNumber;
    String contactPerson;
}