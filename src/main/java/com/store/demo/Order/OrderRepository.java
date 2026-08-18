package com.store.demo.Order;

//This alone gives you .save(), .findAll(), .findById(), .deleteById() — no code needed inside it.

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
