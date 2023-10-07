package com.pesos.demo.entities;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Cliente")
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Fecha Alta")
    private Date fechaAlta;
    @Column(name = "Fecha Baja")
    private Date fechaBaja;
    @Column(name = "Fecha Modificacion")
    private Date fechaModificacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Usuario")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<Domicilio>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Cliente(){
    }

    public Cliente(Long id, String nombre, String apellido, String telefono, String email, List<Domicilio> domicilios, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.domicilios = domicilios;
        this.pedidos = pedidos;
    }

    public void addDomicilio(Domicilio domicilio) {
        domicilios.add(domicilio);
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}
