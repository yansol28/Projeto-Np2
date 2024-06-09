package com.example.demo.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientLowDTO {
	
	private Long id;
	
	@JsonProperty("nome")
	private String name;
	private String email;
	
}