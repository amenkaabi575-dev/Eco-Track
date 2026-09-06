package com.example.demo.organization.entity;


import com.example.demo.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Organization extends BaseEntity {


    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "tax_id", unique = true,nullable = false)
    private String taxId;

    private String sector;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Organization(String name, String taxId, String sector) {
        this.name = name;
        this.taxId = taxId;
        this.sector = sector;
    }

}
