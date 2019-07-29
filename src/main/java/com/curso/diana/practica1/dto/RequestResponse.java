package com.curso.diana.practica1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestResponse {
	protected String status;
	protected String code;
	protected String mensaje;
}
