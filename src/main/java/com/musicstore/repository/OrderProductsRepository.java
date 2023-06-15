package com.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.model.repository.OrderProducts;


@Repository
public interface OrderProductsRepository extends JpaRepository<OrderProducts, Integer>{

}
