package com.musicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.model.repository.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
