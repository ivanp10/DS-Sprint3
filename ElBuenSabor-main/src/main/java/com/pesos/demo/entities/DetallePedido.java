package com.pesos.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "DetallePedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetallePedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "subTotal")
    private int subTotal;
    @Column(name = "subTotalCosto")
    private int subTotalCosto;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_Pedido")
    private Pedido pedido;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_ArticuloManufacturado")
    private ArticuloManufacturado articuloManufacturado ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_ArticuloInsumo")
    private ArticuloInsumo articuloInsumo;

    public DetallePedido(Long id, int cantidad, double subtotal) {
        this.id = id;
        this.cantidad = cantidad;
    }

}
