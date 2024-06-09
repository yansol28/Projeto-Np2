package com.example.demo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockLowDTO {
	
	private Long id;
	
    private String nomeProduto;
    private int quantidadeDisponivel;
	
}
