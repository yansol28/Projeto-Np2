package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Client;
import com.example.demo.data.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{
	public Optional<Client> findByLogin(String login);
}