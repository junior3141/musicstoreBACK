package com.musicstore.model.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	@Column(name = "description", length = 60, nullable = false)
	private String description;
	
	@Column(name = "images", length = 10000, nullable = false)
	private String images;
	
	public Category() {
		
	}

	public Category(Integer id, String name, String description, String images) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.images = images;
	}
	
	public Category(String id, String name, String description) {
		super();
		this.id = Integer.parseInt(id);
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
}
