package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.StockDTO;
import com.example.demo.data.dto.StockLowDTO;
import com.example.demo.data.model.Stock;
import com.example.demo.dozer.DozerConverter;
import com.example.demo.exception.CommonsException;
import com.example.demo.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository repository;

	public StockLowDTO save(StockDTO stockDTO) {
		var stockModel = DozerConverter.parseObject(stockDTO, Stock.class);
		if(stockModel.getNome().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.client.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}

		
		var stockSaved = repository.save(stockModel);
		
		var stockLowDTO = DozerConverter.parseObject(stockSaved, StockLowDTO.class);
		
		return stockLowDTO;
	}

	public List<StockLowDTO> listAll() {
		var listStockLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listStockLow, StockLowDTO.class);
		
		return listConverted;
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
		
	}

	public Stock findById(Long id) {
		var stock = repository.findById(id);
		if(stock.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.client.notfound.exception",
					"O estoque com a ID informada, não foi encontrado."
					);
		}
		return stock.get();
	}
}
