package com.example.demo.organization.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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
