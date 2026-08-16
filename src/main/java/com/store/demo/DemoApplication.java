package com.store.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

// java spring boot is using mvc (model view controller) for the architecture

@RestController
class HelloWorld {
	private final OrderService orderService;

	public HelloWorld(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/")
	public String home() {
		return "Hello Spring Boot";
	}

	@PostMapping("/orders")
	public String createOrder(@RequestBody OrderRequest request) {
		return orderService.placeOrder(request);
	}
}
