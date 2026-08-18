package com.store.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.store.demo.Order.Order;
import com.store.demo.Order.OrderRepository;
import com.store.demo.Order.OrderService;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloWorld.class)
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc; // allow you to send fake http request to your controller

    @MockitoBean
    private OrderService orderService;

    @MockitoBean
    private OrderRepository orderRepository;

    @Test
    void getOrderById_returns200WhenFound() throws Exception {
        Order order = new Order(25.5, "card", 2, List.of("Pizza"));
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        mockMvc.perform(get("/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.paymentMethod").value("card"));
    }

    @Test
    void getOrderById_returns500WhenNotFound() throws Exception {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/orders/99"))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void createOrder_returnsCreatedOrder() throws Exception {
        Order saved = new Order(25.5, "card", 2, List.of("Pizza"));
        when(orderService.placeOrder(any())).thenReturn(saved);

        String json = """
                {"item":["Pizza"],"paymentMethod":"card","amount":25.5,"quantity":2}
                """;

        mockMvc.perform(post("/orders")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(2));
    }
}