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

import com.example.demo.data.dto.SellerLowDTO;
import com.example.demo.data.model.Seller;
import com.example.demo.service.SellerService;

import br.edu.unichristus.backend.data.dto.SellerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/seller")

public class SellerController {
	@Autowired
	private SellerService service;
	
	@Operation(summary = "Cadastrar vendedor | role: [ADMIN]", 
			tags = "Seller", description = "Possibilita "
					+ "cadastrar um vendedor a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Vendedor retornado com sucesso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	
	
	@PostMapping
	public SellerLowDTO save(@RequestBody SellerDTO seller) {
		return service.save(seller);
	}
	
	@PutMapping
	public SellerLowDTO update(@RequestBody SellerDTO seller) {
		return service.save(seller);
	}
	
	@GetMapping("/all")
	public List<SellerLowDTO> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public Seller findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	
}
