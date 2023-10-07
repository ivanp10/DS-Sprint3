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
@Table(name = "ArticuloInsumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloInsumo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;
    private Date fecha_baja;
    private Date fecha_modificacion;
    private Date fechaAlta;
    private BigDecimal precioCompra;
    private BigDecimal stock_actual;
    private BigDecimal stock_minimo;
    private String url_imagen;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_RubroArticulo")
    private RubroArticulo rubroArticulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_UnidadMedida")
    private UnidadMedida unidadMedida;


}
