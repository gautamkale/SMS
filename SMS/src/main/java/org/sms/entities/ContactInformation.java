package org.sms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ContactInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_info_id", nullable = false)
    private Long contactInfoId;

    @Column(name = "email_id", length = 16)
    private String emailId;

    @Column(name = "phone_number",length = 13)
    private String phoneNumber;

    @Column(name = "contact_person")
    private String contactPerson;

}