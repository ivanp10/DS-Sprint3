package com.pesos.demo;

import com.pesos.demo.entities.*;
import com.pesos.demo.enumeration.EstadoPedido;
import com.pesos.demo.enumeration.FormaDePago;
import com.pesos.demo.enumeration.TipoEnvio;
import com.pesos.demo.repositories.ClienteRepository;
import com.pesos.demo.repositories.FacturaRepository;
import com.pesos.demo.repositories.PedidoRepository;
import com.pesos.demo.repositories.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ProyectoElBuenSabor {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	FacturaRepository pedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	RubroArticuloRepository rubroArticuloRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoElBuenSabor.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, PedidoRepository pedidoRepository, FacturaRepository facturaRepository, RubroArticuloRepository rubroArticuloRepository) {

		return args -> {
			System.out.println("FUNCIONANDO");

			Usuario usuario = Usuario.builder()
					.username("Cristian")
					.fechaAlta(new Date())
					.build();

			Cliente cliente = Cliente.builder()
					.nombre("Cristian")
					.apellido("Magallanes")
					.telefono("261306161")
					.email("magall@gmail.com")
					.fechaAlta(new Date())
					.build();

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Ayacucho")
					.localidad("San Martin")
					.numero(233)
					.build();

			 Pedido pedido1 = Pedido.builder()
					.fechaPedido(new Date())
					.estado(EstadoPedido.INICIADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.build();

			Pedido pedido2 = Pedido.builder()
					.fechaPedido(new Date())
					.estado(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.RETIRAR)
					.build();

			double descuento1 = 200.00;
			double precioSinDescuento1 = 3500;

			double totalConDescuento1 = precioSinDescuento1 - descuento1;

			double descuento2 = 3000.0;
			double precioSinDescuento2 = 18000;

			double totalConDescuento2 = precioSinDescuento2 - descuento2;

			cliente.addDomicilio(domicilio1);
			cliente.addPedido(pedido1);
			cliente.addPedido(pedido2);

			clienteRepository.save(cliente);

			RubroArticulo rubro = RubroArticulo.builder()
					.denominacion("Local")
					.build();

			DetallePedido detalle1Pedido1 = DetallePedido.builder()
					.cantidad(1)
					.subTotal(3000)
					.build();
			pedido1.agregarDetallePedido(detalle1Pedido1);

			pedidoRepository.save(pedido1);


			DetallePedido detalle2Pedido2 = DetallePedido.builder()
					.cantidad(2)
					.subTotal(6000)
					.build();
			pedido2.agregarDetallePedido(detalle2Pedido2);

			pedidoRepository.save(pedido2);

			Factura factura1 = Factura.builder()
					.numero(001)
					.fecha_facturacion(new Date())
					.formadePago(FormaDePago.EFECTIVO)
					.total(3500)
					.pedido(pedido1)   // Asociar la factura con el pedido
					.build();

			Factura factura2 = Factura.builder()
					.numero(002)
					.fecha_facturacion(new Date())
					.formadePago(FormaDePago.TARJETA)
					.total(18000)
					.pedido(pedido2)   // Asociar la factura con el pedido
					.build();

			pedido1.setDescAplicado(200.0);
			pedido1.setTotal(totalConDescuento1);
			pedido1.setFactura(factura1);
			facturaRepository.save(factura1);
			pedidoRepository.save(pedido1);


			pedido2.setDescAplicado(3000.0);
			pedido2.setTotal(totalConDescuento2);
			pedido2.setFactura(factura2);
			facturaRepository.save(factura2);
			pedidoRepository.save(pedido2);

		};
	}
}