package com.store.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    // using mock means create fake versions of these two dependencies
    // no real payment, no real data
    @Mock
    private PaymentService paymentService;

    @Mock
    private OrderRepository orderRepository;

    // inject mode means create a real order service, but plugs the two fake mocks
    // above into its constructor.
    @InjectMocks
    private OrderService orderService;

    // individual test plan
    @Test
    void placeOrder_savesOrderAndProcessesPayment() {
        OrderRequest request = new OrderRequest();

        request.setItem(List.of("Pizza", "Coke"));
        request.setPaymentMethod("card");
        request.setAmount(25.5);
        request.setQuantity(2);

        Order savedOrder = new Order(25.5, "card", 2, List.of("Pizza", "Coke"));
        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        Order result = orderService.placeOrder(request);

        assertEquals("card", result.getPaymentMethod());
        assertEquals(2, result.getQuantity());
        verify(paymentService, times(1)).processPayment(25.5);
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void cancelOrder_throwsWhenOrderNotFound() {
        when(orderRepository.existsById(99L)).thenReturn(false);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> orderService.cancelOrder(99L));

        assertTrue(ex.getMessage().contains("not found"));
        verify(orderRepository, never()).deleteById(any());
    }
}
