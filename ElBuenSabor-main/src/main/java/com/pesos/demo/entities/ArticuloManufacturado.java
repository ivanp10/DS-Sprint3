package com.pesos.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ArticuloManufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloManufacturado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal costo;
    private String denominacion;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaBaja;
    private Date fechaModificacion;
    private BigDecimal precioVenta;
    private int tiempoEstimadoCocina;
    private String urlImagen;
}
