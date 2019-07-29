package com.curso.diana.practica1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
	protected Integer id;
	protected String nombre;
	protected String descripcion;
	protected Double precio;
	protected Integer catalogo_id;
}
