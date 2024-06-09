package com.example.demo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
	
	private Long id;

    private String cliente;
    private String endereco;
    private String produto;
    private int quantidade;
	
}