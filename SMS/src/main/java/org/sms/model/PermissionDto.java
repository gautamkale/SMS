package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.sms.entities.Permission}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionDto implements Serializable {
    Long permissionId;
    RoleDto role;
}