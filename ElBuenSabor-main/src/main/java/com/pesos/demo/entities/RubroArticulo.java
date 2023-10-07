package com.pesos.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RubroArticulo ")
@Getter
@Setter
@Builder
public class RubroArticulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;
    private Date fecha_Alta;
    private Date fecha_Baja;
    private Date fecha_modificacion;

    public RubroArticulo(){
    }

    public RubroArticulo(Long id, String denominacion, Date fecha_Alta, Date fecha_Baja, Date fecha_modificacion) {
        this.id = id;
        this.denominacion = denominacion;
        this.fecha_Alta = fecha_Alta;
        this.fecha_Baja = fecha_Baja;
        this.fecha_modificacion = fecha_modificacion;
    }

    }
