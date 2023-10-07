package com.pesos.demo.entities;

import com.pesos.demo.enumeration.FormaDePago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table (name = "Factura")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura implements Serializable {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Numero")
    private int numero;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Fecha Facturacion")
    private Date fecha_facturacion;
    @Column(name = "Fecha Alta")
    private Date fechaAlta;
    @Column(name = "Fecha Baja")
    private Date fechaBaja;
    @Column(name = "Fecha Modificacion")
    private Date fechaModificacion;
    @Column(name = "Total")
    private int total;

    private Long mp_merchant_order_id;
    private Long mp_payment_id;
    private Long mp_payment_type;
    private String mp_preference_id;
    private BigDecimal totalVenta;

    @Enumerated(EnumType.STRING)
    private FormaDePago formadePago;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Cliente")
    private Cliente cliente;

    @OneToOne(mappedBy = "factura")
    @JoinColumn(name = "pedido_id")

    private Pedido pedido;


}


