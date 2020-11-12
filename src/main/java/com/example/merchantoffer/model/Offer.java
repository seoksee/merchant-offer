package com.example.merchantoffer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "offers")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name="offer_types_id", nullable = false)
    private OfferType offerType;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(name="merchants_offers",
        joinColumns = @JoinColumn(name="offer_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "merchant_id", referencedColumnName = "id"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"offer_id", "merchant_id"})})
    @JsonIgnoreProperties("offers")
    private List<Merchant> merchants;

//    @Column(nullable = false)
//    @OneToMany(mappedBy = "Offer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<MerchantOffer> merchantOfferSet;

    private Long points;

    private float cashRebate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Offer(){
        super();
    }

    public Offer(String name, String description, Long points, float cashRebate, Date startDate, Date endDate) {
        this.name = name;
        this.description = description;
        this.points = points;
        this.cashRebate = cashRebate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<Merchant> merchants) {
        this.merchants = merchants;
    }

//    public Long getOfferTypeId() {
//        return offerTypeId;
//    }
//
//    public void setOfferTypeId(Long offerTypeId) {
//        this.offerTypeId = offerTypeId;
//    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public float getCashRebate() {
        return cashRebate;
    }

    public void setCashRebate(float cashRebate) {
        this.cashRebate = cashRebate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
