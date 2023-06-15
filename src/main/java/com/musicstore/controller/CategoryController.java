package com.musicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.musicstore.model.repository.Category;
import com.musicstore.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "https://musicstoreoficial.000webhostapp.com/")
//@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	@Autowired
	private CategoryRepository repository;
	
	@GetMapping("/categorias")
	public List<Category> listCategory(){
		return repository.findAll();
	}
	
	@PostMapping("/categorias")
	public Category saveCategory(@RequestBody Category category) {
		return repository.save(category);
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<Category> listProductById(@PathVariable Integer id){
		Category category = repository.findById(id).orElse(null);
		return ResponseEntity.ok(category);
	}
	
	@PutMapping("/categorias/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Integer id,@RequestBody Category productModify){
		Category category = repository.findById(id).orElse(null);
		category.setName(productModify.getName());
		category.setDescription(productModify.getDescription());
		category.setImages(productModify.getImages());
		repository.save(category);
		return ResponseEntity.ok(category);
	}
	
	@DeleteMapping("/categorias/{id}")
	public Integer deleteCategory(@PathVariable Integer id){
		Integer number = 0;
		Category category = repository.findById(id).orElse(null);
		if (category != null) {
			repository.delete(category);
			number = 1;
		}
		
		return number;
	}
	
	
}
