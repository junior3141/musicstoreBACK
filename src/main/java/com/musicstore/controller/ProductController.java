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
import com.musicstore.model.repository.Product;
import com.musicstore.model.repository.User;
import com.musicstore.repository.CategoryRepository;
import com.musicstore.repository.ProductRepository;
import com.musicstore.repository.UserRepository;

@RestController
@RequestMapping("/product")
//@CrossOrigin(origins = "https://musicstoreoficial.000webhostapp.com/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository usuRepository;
	
	@GetMapping("/login")
	public List<User> listUser(){
		return usuRepository.findAll();
	}
	@GetMapping("/productos")
	public List<Product> listProducts(){
		return repository.findAll();
	}
	
	@PostMapping("/productos/{idCategory}")
	public Product saveProduct(@PathVariable Integer idCategory,@RequestBody Product product) {
		Category categoria = categoryRepository.findById(idCategory).orElse(null);
		product.setCategory(categoria);
		return repository.save(product);
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Product> listProductById(@PathVariable Integer id){
		Product product = repository.findById(id).orElse(null);
		return ResponseEntity.ok(product);
	}
	@GetMapping("/mostrar-categoria/product/{id}")
	public List<Product> listProductByCategory(@PathVariable Integer id){
		List<Product>product = repository.findProductByCategory(id);
		return product;
	}
	
	@PutMapping("/productos/{id}/{idCategory}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer id,@PathVariable Integer idCategory,@RequestBody Product productModify){
		Product product = repository.findById(id).orElse(null);
		Category categoria = categoryRepository.findById(idCategory).orElse(null);
		product.setName(productModify.getName());
		product.setDescription(productModify.getDescription());
		product.setPrice(productModify.getPrice());
		product.setImages(productModify.getImages());
		product.setCategory(categoria);
		repository.save(product);
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/productos/{id}")
	public Integer deleteProduct(@PathVariable Integer id){
		Integer number = 0;
		Product product = repository.findById(id).orElse(null);
		if (product != null) {
			repository.delete(product);
			number = 1;
		}
		
		return number;
	}
	
}
