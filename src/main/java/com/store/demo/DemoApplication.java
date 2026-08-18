package com.store.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

// java spring boot is using mvc (model view controller) for the architecture

@RestController
class HelloWorld {
	private final OrderRepository orderRepository;
	private final OrderService orderService;

	public HelloWorld(OrderService orderService, OrderRepository orderRepository) {
		this.orderService = orderService;
		this.orderRepository = orderRepository;
	}

	@GetMapping("/")
	public String home() {
		return "Hello Spring Boot";
	}

	// Post new things
	@PostMapping("/orders")
	public Order createOrder(@RequestBody OrderRequest request) {
		return orderService.placeOrder(request);
	}

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	// Get items
	@GetMapping("/orders/{id}")
	public Order getOrder(@PathVariable Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
	}

	@PutMapping("/orders/{id}")
	public Order updateOrder(@PathVariable Long id, @RequestBody OrderRequest request) {
		return orderService.updateOrder(id, request);
	}

	@DeleteMapping("/orders/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.cancelOrder(id);
		return "Order " + id + " cancelled";
	}

}
