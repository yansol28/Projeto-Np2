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

import com.example.demo.data.dto.OrderDTO;
import com.example.demo.data.dto.OrderLowDTO;
import com.example.demo.data.model.Order;
import com.example.demo.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/order")

public class OrderController {

	@Autowired
	private OrderService service;
	
	@Operation(summary = "Cadastrar pedido | role: [ADMIN]", 
			tags = "Order", description = "Possibilita "
					+ "cadastrar um pedido a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Pedido retornado com sucesso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Pedido informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	
	@PostMapping
	public OrderLowDTO save(@RequestBody OrderDTO order) {
		return service.save(order);
	}
	
	@PutMapping
	public OrderLowDTO update(@RequestBody OrderDTO order) {
		return service.save(order);
	}
	
	@GetMapping("/all")
	public List<OrderLowDTO> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public Order findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	
}

