package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link org.sms.entities.BillingAccount}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccountDto implements Serializable {
    Long accountId;
    BigDecimal monthlyCharges;
    BigDecimal currentBalance;
    Set<PaymentDto> payments;
    LocalDate dueDate;
    String status;
    String note;
    LocalDateTime lastPaymentDate;
}