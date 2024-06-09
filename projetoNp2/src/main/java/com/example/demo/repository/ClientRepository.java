package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	public Optional<Client> findByLogin(String login);
}