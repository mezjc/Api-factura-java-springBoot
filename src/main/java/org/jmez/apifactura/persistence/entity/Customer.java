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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastname;

    private String dni;

    @Column(name = "direccion")
    private String address;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @PrePersist
    private void created(){
        createdAt= LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        updateAt = LocalDateTime.now();
    }


}
