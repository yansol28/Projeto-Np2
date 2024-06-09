package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	public Optional<Stock> findByNome(String nome);
}
