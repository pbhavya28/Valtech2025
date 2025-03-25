package com.valtech.assignment.ordermanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.assignment.ordermanagement.entities.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long> {

}
