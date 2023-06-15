package com.musicstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.model.repository.Category;
import com.musicstore.model.repository.Order;
import com.musicstore.model.repository.OrderProducts;
import com.musicstore.model.repository.OrderResponse;
import com.musicstore.model.repository.Product;
import com.musicstore.model.repository.User;
import com.musicstore.repository.OrderProductsRepository;
import com.musicstore.repository.OrderRepository;
import com.musicstore.repository.UserRepository;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderProductsRepository orderProductsrepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/order")
	public List<OrderResponse> listOrder(){
		List<Order> pedidosTotales = repository.findAll();
		List<OrderProducts> pedidosProductosTotales = orderProductsrepository.findAll();
		List<OrderResponse> pedidos = new ArrayList<OrderResponse>();
		for (int i=0; i<pedidosTotales.size(); i++) {
			List<Product> productos = new ArrayList<Product>();
			OrderResponse ped = new OrderResponse();
			ped.setReferencia(pedidosTotales.get(i).getId());
			ped.setUser(pedidosTotales.get(i).getUser());
			for (int j=0; j<pedidosProductosTotales.size(); j++) {
				if (pedidosTotales.get(i).getId() == pedidosProductosTotales.get(j).getOrder().getId()) {
					productos.add(pedidosProductosTotales.get(j).getProducts());
					ped.setProductos(productos);
				}
			}

			pedidos.add(ped);
		}
		return pedidos;
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<OrderResponse> listOrderById(@PathVariable Integer id){
		List<OrderResponse> pedidos = listOrder();
		OrderResponse ped = new OrderResponse();
		for (int i=0; i<pedidos.size(); i++) {
			if (pedidos.get(i).getReferencia() == id) {
				ped = pedidos.get(i);
			}
		}
		return ResponseEntity.ok(ped);
	}
	
	@PostMapping("/order/{id}")
	public List<Order> saveOrder(@PathVariable Integer id,@RequestBody List<Product> product) {
		Order pedido = new Order();
		User usuario = userRepository.findById(id).orElse(null);
		pedido.setUser(usuario);
		repository.save(pedido);
		for(int i=0; i<product.size(); i++) {
		OrderProducts pedidoPro = new OrderProducts();
		pedidoPro.setOrder(pedido);
		pedidoPro.setProducts(product.get(i));
		orderProductsrepository.save(pedidoPro);
		}

		return repository.findAll();
	}

}
