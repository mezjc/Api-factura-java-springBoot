package org.jmez.apifactura.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInvoiceDTO {

    @NotBlank
    private String product;

    @NotNull
    private Integer quantity;
}
