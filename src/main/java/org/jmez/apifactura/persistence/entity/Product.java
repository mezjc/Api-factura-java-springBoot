package org.jmez.apifactura.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "precio", columnDefinition = "DECIMAL(6,2)")
    private Double price;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @PrePersist
    private void prePersist(){
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
