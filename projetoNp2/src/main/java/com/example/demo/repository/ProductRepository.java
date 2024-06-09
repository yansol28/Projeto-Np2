package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Client;
import com.example.demo.data.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public Optional<Client> findByNome(String nome);
}
