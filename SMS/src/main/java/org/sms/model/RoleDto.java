package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link org.sms.entities.Role}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDto implements Serializable {
    Long roleId;
    String roleName;
    Set<PermissionDto> permissions;
}