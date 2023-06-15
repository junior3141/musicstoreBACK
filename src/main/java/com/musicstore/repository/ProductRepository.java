package com.musicstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.musicstore.model.repository.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(value = "Select * from Product where category.id = ?id", nativeQuery = true)
	List<Product> findProductByCategory(Integer id);
}
