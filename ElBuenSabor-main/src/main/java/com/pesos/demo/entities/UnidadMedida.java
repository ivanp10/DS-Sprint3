package com.pesos.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "UnidadMedida")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UnidadMedida implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String abreviatura;
    private String denominacion;
    private Date fechAlta;
    private Date fechaBaja;
    private Date fechaModificacion;

}
