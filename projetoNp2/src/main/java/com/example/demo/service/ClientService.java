package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.ClientDTO;
import com.example.demo.data.dto.ClientLowDTO;
import com.example.demo.data.model.Client;
import com.example.demo.dozer.DozerConverter;
import com.example.demo.exception.CommonsException;
import com.example.demo.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	public ClientLowDTO save(ClientDTO clientDTO) {
		var clientModel = DozerConverter.parseObject(clientDTO, Client.class);
		if(clientModel.getNome().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.client.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		var clientFind = repository.findByLogin(clientModel.getLogin());
		if(!clientFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.client.conflict.exception",
					"O Login informado já existe!"
					);
		}
		
		
		var clientSaved = repository.save(clientModel);
		
		var clientLowDTO = DozerConverter.parseObject(clientSaved, ClientLowDTO.class);
		
		return clientLowDTO;
	}

	public List<ClientLowDTO> listAll() {
		var listClientLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listClientLow, ClientLowDTO.class);
		
		return listConverted;
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
		
	}

	public Client findById(Long id) {
		var client = repository.findById(id);
		if(client.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.client.notfound.exception",
					"O cliente com a ID informada, não foi encontrado."
					);
		}
		return client.get();
	}
}
