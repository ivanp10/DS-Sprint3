package com.pesos.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "DetalleArticuloManufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleArticuloManufacturado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal cantidad;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_ArticuloManufacturado")
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_ArticuloInsumo")
    private ArticuloInsumo articuloInsumo;
}
