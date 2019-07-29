package com.curso.diana.practica1.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.curso.diana.practica1.dto.Catalogo;

@Mapper
public interface CatalogoMapper {
	void crearTablaCatalogos();
	
	List<Catalogo> mostrarCatalogos();
	
	List<Catalogo> buscarCatalogo(@Param("id")Integer id);
	
	void insertarCatalogo(@Param("catalog") Catalogo catalog);
	
	void crearSecuenciaCatalogo();
	
	void eliminarCatalogo(@Param("id")Integer id);
	
	Catalogo crearCatalogo(String nameCatalog);
	
	void editarCatalogo(@Param("id") Integer id, @Param("nombre") String nombre);
}
