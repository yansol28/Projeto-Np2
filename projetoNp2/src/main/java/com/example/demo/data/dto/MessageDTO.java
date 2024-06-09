package com.example.demo.data.dto;

import java.io.Serializable;

import com.example.demo.data.dto.MessageDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String key;
	

}
