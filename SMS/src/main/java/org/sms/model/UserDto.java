package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link org.sms.entities.User}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDto(Long userId, String userName, String password, String emailId, String accountStatus,
                      LocalDateTime lastLogin, ProfileDto profile, Set<NoticeDto> notices, Set<RoleDto> roles,
                      Set<ApartmentDto> apartments, Set<ComplaintDto> complaints, Set<ParticipationDto> participations,
                      Set<DocumentDto> documents, Set<MaintenanceTaskDto> maintenanceTasks, Set<EventDto> events,
                      Set<BillingAccountDto> billingAccounts) implements Serializable {
}