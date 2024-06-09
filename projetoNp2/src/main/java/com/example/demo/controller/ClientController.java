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

import com.example.demo.data.dto.ClientDTO;
import com.example.demo.data.dto.ClientLowDTO;
import com.example.demo.data.model.Client;
import com.example.demo.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/client")

public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@Operation(summary = "Cadastrar cliente | role: [ADMIN]", 
			tags = "Client", description = "Possibilita "
					+ "cadastrar um cliente a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Cliente retornado com sucesso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	
	@PostMapping
	public ClientLowDTO save(@RequestBody ClientDTO client) {
		return service.save(client);
	}
	
	@PutMapping
	public ClientLowDTO update(@RequestBody ClientDTO client) {
		return service.save(client);
	}
	
	@GetMapping("/all")
	public List<ClientLowDTO> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public Client findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	
}