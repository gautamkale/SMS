package org.sms.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "apartment")
public class Apartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id", nullable = false)
    private Long apartmentId;

    @Column(name = "apartment_no", unique = true, length = 20)
    private String apartmentNo;

    @Column(name = "size")
    private Double size;

    @Column(name = "floor")
    private Long floor;

    @Column(name = "building_name", length = 100)
    private String buildingName;

    @Column(name = "block_no", length =10)
    private String blockNo;

    @Column(name = "type", length = 5)
    private String type;

    @OneToMany(mappedBy = "apartment",  cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<ProfileApartment> profileApartments = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")
    private User resident;

    @Column(name = "occupancy_status", length = 16)
    private String occupancyStatus; //ccupied, vacant, or under maintenance.

    @Column(name = "registered_date")
    private LocalDate registeredDate;

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BillingAccount> billingAccounts = new HashSet<>();

    @Column(name = "parking_space", length = 10)
    private String parkingSpace;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Apartment apartment = (Apartment) o;
        return getApartmentId() != null && Objects.equals(getApartmentId(), apartment.getApartmentId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}