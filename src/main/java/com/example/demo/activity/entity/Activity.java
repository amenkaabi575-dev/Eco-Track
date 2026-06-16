package com.example.demo.activity.entity;

import com.example.demo.asset.entity.Asset;
import com.example.demo.emissionFactor.entity.EmissionFactor;
import com.example.demo.emissionFactor.entity.EmissionFactorUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "activities")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "quantity", nullable = false, precision = 12, scale = 4)
    private BigDecimal quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "consumption_unit")
    private EmissionFactorUnit unit;

    @Column(name = "activity_date", nullable = false)
    private LocalDateTime activityDate;

    @Column(name = "recorded_at")
    @CreationTimestamp
    private LocalDateTime recordedAt;

    @Column(precision = 12, scale = 4)
    private BigDecimal calculatedCo2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emission_factor_id", nullable = false)
    private EmissionFactor emissionFactor;



}
