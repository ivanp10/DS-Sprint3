package com.pesos.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Fecha Alta")
    private Date fechaAlta;
    @Column(name = "Fecha Baja")
    private Date fechaBaja;
    @Column(name = "Fecha Modificacion")
    private Date fechaModificacion;

    private String auth0_id;
}
