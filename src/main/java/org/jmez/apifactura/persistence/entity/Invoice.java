package org.jmez.apifactura.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Customer client;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceDetails> details;

    @PrePersist
    private void created(){
        createdAt= LocalDateTime.now();
    }



}
