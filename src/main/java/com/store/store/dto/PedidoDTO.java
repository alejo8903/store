package com.store.store.dto;

import java.util.Date;
import java.util.List;

import com.store.store.model.Cliente;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDTO {

    private Cliente cliente;

    private String ocasion;

    private Date fechaEntrega;

    private Double precio;
    private String estado;

    private List<ProductoDTO> productos;
}
