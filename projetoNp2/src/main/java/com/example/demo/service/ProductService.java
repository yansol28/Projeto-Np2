package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.ProductDTO;
import com.example.demo.data.dto.ProductLowDTO;
import com.example.demo.data.model.Product;
import com.example.demo.dozer.DozerConverter;
import com.example.demo.exception.CommonsException;
import com.example.demo.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

		public ProductLowDTO save(ProductDTO productDTO) {
			var productModel = DozerConverter.parseObject(productDTO, Product.class);
			if(productModel.getNome().length() > 100) {
				throw new CommonsException(
						HttpStatus.BAD_REQUEST,
						"unichristus.backend.service.client.badrequest.exception",
						"Limite de caracteres excedido!"
						);
			}

			
			
			var productSaved = repository.save(productModel);
			
			var productLowDTO = DozerConverter.parseObject(productSaved, ProductLowDTO.class);
			
			return productLowDTO;

	}

	public List<ProductLowDTO> listAll() {
		var listProductLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listProductLow, ProductLowDTO.class);
		
		return listConverted;
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
		
	}

	public Product findById(Long id) {
		var product = repository.findById(id);
		if(product.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.client.notfound.exception",
					"O produto com o ID informado, não foi encontrado."
					);
		}
		return product.get();

	}
}
