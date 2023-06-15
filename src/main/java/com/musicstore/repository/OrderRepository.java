package com.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.model.repository.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
