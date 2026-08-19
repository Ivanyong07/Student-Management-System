package com.store.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.demo.order.Order;
import com.store.demo.order.OrderRepository;
import com.store.demo.order.OrderService;
import com.store.demo.order.dto.OrderRequest;
import com.store.demo.order.dto.OrderResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

// Student Registration – Add and maintain student details such as name, ID, contact information, and admission records.
// Attendance Management – Record and monitor daily attendance of students.
// Course and Class Management – Assign students to classes, subjects, and teachers.
// Examination Management – Schedule exams, record marks, and generate report cards.
// Fee Management – Track fee payments, pending dues, and generate receipts.
// Timetable Management – Create and manage class schedules.
// Library Management – Manage book issuance, returns, and fines (if integrated).
// Communication – Send announcements, notices, SMS, or emails to students and parents.
// Student Performance Tracking – Monitor academic progress and generate performance reports.
// User Management – Provide different access levels for administrators, teachers, students, and parents.
// Report Generation – Generate reports on attendance, fees, academic performance, and admissions.
// Document Management – Store student documents such as certificates, ID proofs, and transcripts securely.

// Full CRUD REST API (Create, Read, Update, Delete)
// Database persistence with H2 + JPA
// Input validation with @Valid + Bean Validation annotations
// Global exception handling (clean 400s for bad input, 404s for not-found)
// Unit tests + controller tests
// Working HTML admin page
// Connect spring boot with mysql

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

	@Value("${spring.application.name}")
	private String appName;

	@RequestMapping("/index")
	public String index() {
		System.out.println("App Name: " + appName);
		return "index.html";
	}

	@GetMapping("/")
	public String home() {
		return "Hello Spring Boot";
	}

	// Post new things
	@PostMapping("/orders")
	public OrderResponse createOrder(@Valid @RequestBody OrderRequest request) {
		return orderService.placeOrder(request);
	}

	@GetMapping("/orders")
	public List<OrderResponse> getAllOrders() {
		return orderService.getAllOrders();
	}

	// Get items
	@GetMapping("/orders/{id}")
	public OrderResponse getOrder(@PathVariable Long id) {
		return orderService.getOrder(id);
	}

	@PutMapping("/orders/{id}")
	public OrderResponse updateOrder(@PathVariable Long id, @Valid @RequestBody OrderRequest request) {
		return orderService.updateOrder(id, request);
	}

	@DeleteMapping("/orders/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.cancelOrder(id);
		return "Order " + id + " cancelled";
	}

}
