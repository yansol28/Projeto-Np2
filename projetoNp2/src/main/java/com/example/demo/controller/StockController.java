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

import com.example.demo.data.dto.StockDTO;
import com.example.demo.data.dto.StockLowDTO;
import com.example.demo.data.model.Stock;
import com.example.demo.service.StockService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/stock")

public class StockController{
	
	@Autowired
	private StockService service;
	
	@Operation(summary = "Cadastrar estoque | role: [ADMIN]", 
			tags = "Stock", description = "Possibilita "
					+ "cadastrar um estoque a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Estoque retornado com sucesso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Estoque informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	
@PostMapping
public StockLowDTO save(@RequestBody StockDTO stock) {
	return service.save(stock);
}

@PutMapping
public StockLowDTO update(@RequestBody StockDTO stock) {
	return service.save(stock);
}

@GetMapping("/all")
public List<StockLowDTO> listAll(){
	return service.listAll();
}

@DeleteMapping("/{id}")
public void delete(@PathVariable("id") Long id) {
	service.delete(id);
}

@GetMapping
public Stock findById(@RequestParam(required = true) Long id) {
	return service.findById(id);
}


}