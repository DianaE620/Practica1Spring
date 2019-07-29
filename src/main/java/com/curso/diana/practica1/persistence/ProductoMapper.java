package com.curso.diana.practica1.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.curso.diana.practica1.dto.Producto;

@Mapper
public interface ProductoMapper {

	void crearTablaProductos();
	
	void crearSecuenciaProductos();
	
	List<Producto> obtenerProductos(@Param("catalogoId")Integer catalogoId);
	
	List<Producto> buscarProducto(@Param("id") Integer id);
	
	void insertarProducto(@Param("producto") Producto producto);
	
	void eliminarProducto(@Param("id") Integer id);
	
	void editarProducto(@Param("producto") Producto producto);
	
	
}
