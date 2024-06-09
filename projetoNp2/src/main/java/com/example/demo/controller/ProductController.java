package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.ProductDTO;
import com.example.demo.data.dto.ProductLowDTO;
import com.example.demo.data.model.Product;
import com.example.demo.service.ProductService;




@RestController
@RequestMapping("/api/product")

public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ProductLowDTO save(@RequestBody ProductDTO product) {
		return service.save(product);
	}
	
	@PutMapping
	public ProductLowDTO update(@RequestBody ProductDTO product) {
		return service.save(product);
	}
	
	@GetMapping("/all")
	public List<ProductLowDTO> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public Product findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
}
