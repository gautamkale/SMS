package org.sms.model;

import jakarta.validation.constraints.NotNull;

public record LoginDto(@NotNull String email,@NotNull String password) {
}
