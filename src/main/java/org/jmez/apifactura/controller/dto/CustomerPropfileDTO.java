package org.jmez.apifactura.controller.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPropfileDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotBlank
    @Size(min = 3, max = 20)
    private String lastname;
    @NotBlank
    @Size(min = 6, max = 20)
    private String dni;
    @NotBlank
    @Size(min = 3, max = 30)
    private String address;

}
