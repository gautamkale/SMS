package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.sms.entities.Vehicle}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDto implements Serializable {
    Long vehicleId;
    String vehicleNo;
    String vhicleType;
}