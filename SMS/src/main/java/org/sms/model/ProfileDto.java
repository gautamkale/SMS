package org.sms.model;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link org.sms.entities.Profile}
 */

public record ProfileDto(Long id, String lastName, String firstName, Long contactNo, LocalDate dob, String occupation,
                         Set<ProfileDto> families, Set<VehicleDto> vehicles, Blob photoId) implements Serializable {
}