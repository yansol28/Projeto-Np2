package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.SellerLowDTO;
import com.example.demo.data.model.Seller;
import com.example.demo.dozer.DozerConverter;
import com.example.demo.exception.CommonsException;
import com.example.demo.repository.SellerRepository;

import br.edu.unichristus.backend.data.dto.SellerDTO;
@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public SellerLowDTO save(SellerDTO sellerDTO) {
		var sellerModel = DozerConverter.parseObject(sellerDTO, Seller.class);
		if(sellerModel.getNome().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.client.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		var sellerFind = repository.findByLogin(sellerModel.getLogin());
		if(!sellerFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.client.conflict.exception",
					"O Login informado já existe!"
					);
		}
		
		
		var sellerSaved = repository.save(sellerModel);
		
		var sellerLowDTO = DozerConverter.parseObject(sellerSaved, SellerLowDTO.class);
		
		return sellerLowDTO;
	}


	public List<SellerLowDTO> listAll() {
		
		var listSellerLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listSellerLow, SellerLowDTO.class);
		
		return listConverted;
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
		
	}

	public Seller findById(Long id) {
		var seller = repository.findById(id);
		if(seller.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.client.notfound.exception",
					"O cliente com a ID informada, não foi encontrado."
					);
		}
		return seller.get();
	}

}
