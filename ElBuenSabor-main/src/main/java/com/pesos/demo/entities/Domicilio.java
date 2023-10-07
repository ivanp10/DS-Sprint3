package com.pesos.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Calle")
    private String calle;
    @Column(name = "Codigo Postal")
    private Integer codigoPostal;
    @Column(name = "Fecha Alta")
    private Date fechaAlta;
    @Column(name = "Fecha Baja")
    private Date fechaBaja;
    @Column(name = "Fecha Modificacion")
    private Date fechaModificacion;
    @Column(name = "Localidad")
    private String localidad;
    @Column(name = "Numero")
    private Integer numero;
    @Column(name = "Numero Depto")
    private Integer numeroDpto;
    @Column(name = "Piso Depto")
    private Integer pisoDpto;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_Cliente")
    private Cliente cliente;

}
