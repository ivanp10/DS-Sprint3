package com.pesos.demo.entities;

import com.pesos.demo.enumeration.EstadoPedido;
import com.pesos.demo.enumeration.FormaDePago;
import com.pesos.demo.enumeration.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Pedido  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Estado")
    private EstadoPedido estado;
    @Column(name = "Fecha Alta")
    private Date fechaAlta;
    @Column(name = "Fecha Baja")
    private Date fechaBaja;
    @Column(name = "Fecha Modificacion")
    private Date fechaModificacion;
    @Column(name = "Fecha Pedido")
    private Date fechaPedido;
    @Enumerated(EnumType.STRING )
    private FormaDePago formaPago;
    @Column(name = "Hora Estimada")
    private Date horaEstimadaFinalizacion;
    @Column(name = "desc_aplicado")
    private Double descAplicado;

    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;
    @Column(name = "Total")
    private double total;
    @Column(name = "Total Costo")
    private BigDecimal totalCosto;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn( name = "fk_cliente")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn( name = "fk_Domicilio")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Pedido_id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<DetallePedido>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Factura")
    private Factura factura;

    public void agregarDetallePedido (DetallePedido deta){
        detallePedidos.add(deta);
    }





}
