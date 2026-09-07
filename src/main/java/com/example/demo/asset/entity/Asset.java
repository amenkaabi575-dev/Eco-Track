package com.example.demo.asset.entity;


import com.example.demo.common.BaseEntity;
import com.example.demo.organization.entity.Organization;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
@Entity
@Table(name = "assets")
@EntityListeners(AuditingEntityListener.class)
public class Asset extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type",nullable = false)
    private AssetType type;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;



}
