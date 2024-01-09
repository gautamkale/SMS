package org.sms.model;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record Address(@NotNull  @Length(max=10) String blockName, @NotNull  @Length(max=20) String flatNo, @NotNull @Length(max=100) String societyName, @NotNull long floor, @NotNull int pin){}

