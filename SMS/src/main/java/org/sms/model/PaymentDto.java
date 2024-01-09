package org.sms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.sms.entities.Payment}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDto implements Serializable {
    Long paymentId;
    String receiptNumber;
    String paymentMethod;
    LocalDateTime paymentDate;
    BigDecimal amount;
    String note;
}