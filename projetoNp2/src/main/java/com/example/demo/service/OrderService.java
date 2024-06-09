package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.OrderDTO;
import com.example.demo.data.dto.OrderLowDTO;
import com.example.demo.data.model.Order;
import com.example.demo.dozer.DozerConverter;
import com.example.demo.exception.CommonsException;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;

	public OrderLowDTO save(OrderDTO orderDTO) {
		var orderModel = DozerConverter.parseObject(orderDTO, Order.class);
		if(orderModel.getCliente().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.client.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}

		
		var orderSaved = repository.save(orderModel);
		
		var orderLowDTO = DozerConverter.parseObject(orderSaved, OrderLowDTO.class);
		
		return orderLowDTO;
	}

	public List<OrderLowDTO> listAll() {
		var listOrderLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listOrderLow, OrderLowDTO.class);
		
		return listConverted;
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
		
	}

	public Order findById(Long id) {
		var order = repository.findById(id);
		if(order.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.client.notfound.exception",
					"O pedido com a ID informada, não foi encontrado."
					);
		}
		return order.get();
	}
}
