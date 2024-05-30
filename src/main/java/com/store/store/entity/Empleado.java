package com.store.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "EMPLEADO")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String telefono;
    private String email;
    @Column(name = "ID_ROL")
    private int idRol;
    @Column(name = "FECHA_CONTRATO")
    private Date fechaContrato;
}