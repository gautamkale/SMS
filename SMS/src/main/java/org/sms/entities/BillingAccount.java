package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "billing_account")
public class BillingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "monthly_charges", precision = 19, scale = 2)
    private BigDecimal monthlyCharges;

    @Column(name = "current_balance", precision = 19, scale = 2)
    private BigDecimal currentBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartmentId")
    private Apartment apartment;

    @OneToMany(mappedBy = "billingAccount", orphanRemoval = true)
    private Set<Payment> payments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "status", length = 10)
    private String status; // (e.g., Active, Delinquent, Closed).

    @Column(name = "note", length = 50)
    private String note;

    @Column(name = "last_payment_date")
    private LocalDateTime lastPaymentDate;

}