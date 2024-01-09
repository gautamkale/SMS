package org.sms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegisterDto(@NotNull  @Length(min=4,max = 50) String userId, @NotNull @Length(min=6,max = 16) String password, @NotNull String confirmPassword,
                          @NotNull String emailId, @NotNull @Length(min=1,max = 50) String firstName, @NotNull @Length(min=1,max = 50) String lastName, Address address,
                          @NotNull long contactNo, @NotNull LocalDate dob, @NotNull boolean isOwner,
                          @NotNull @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime startDate, @NotNull String residencyType, @Length(min=0,max = 28)String occupation){
}
