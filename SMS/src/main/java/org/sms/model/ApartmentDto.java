package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link org.sms.entities.Apartment}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartmentDto implements Serializable {
    Long apartmentId;
    String apartmentNo;
    Double size;
    Long floor;
    String buildingName;
    String blockNo;
    String type;
    Set<ProfileApartmentDto> profileApartments;
    String occupancyStatus;
    LocalDate registeredDate;
    Set<BillingAccountDto> billingAccounts;
    String parkingSpace;
}