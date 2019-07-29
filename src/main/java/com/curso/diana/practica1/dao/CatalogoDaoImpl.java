package com.curso.diana.practica1.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.curso.diana.practica1.dto.Catalogo;
import com.curso.diana.practica1.persistence.CatalogoMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CatalogoDaoImpl implements CatalogoMapper {
	
	@NonNull
	protected final SqlSession sqlSession;
	
	@Override
	public List<Catalogo> mostrarCatalogos() {
		return this.sqlSession.getMapper(CatalogoMapper.class).mostrarCatalogos();
	}
	
	@Override
	public void crearTablaCatalogos() {
		this.sqlSession.getMapper(CatalogoMapper.class).crearTablaCatalogos();
	}
	
	@Override
	public void insertarCatalogo(Catalogo catalog) {
		this.sqlSession.getMapper(CatalogoMapper.class).insertarCatalogo(catalog);
	}
	
	@Override
	public Catalogo crearCatalogo(String nameCatalog) {
		return new Catalogo(null, nameCatalog);
	}
	
	@Override
	public void crearSecuenciaCatalogo() {
		this.sqlSession.getMapper(CatalogoMapper.class).crearSecuenciaCatalogo();
	}
	
	@Override
	public List<Catalogo> buscarCatalogo(Integer id) {
		return this.sqlSession.getMapper(CatalogoMapper.class).buscarCatalogo(id);
	}
	
	@Override
	public void eliminarCatalogo(Integer id) {
		this.sqlSession.getMapper(CatalogoMapper.class).eliminarCatalogo(id);
	}
	
	@Override
	public void editarCatalogo(Integer id, String nombre) {
		this.sqlSession.getMapper(CatalogoMapper.class).editarCatalogo(id, nombre);
	}
	
	@PostConstruct
	protected void init() {
		crearSecuenciaCatalogo();
		crearTablaCatalogos();
		
		//Agregar catalogos de prueba
		Catalogo c1 = crearCatalogo("Libros");
		Catalogo c2 = crearCatalogo("Dulceria");
		Catalogo c3 = crearCatalogo("Regalos");
		insertarCatalogo(c1);
		insertarCatalogo(c2);
		insertarCatalogo(c3);
		
	}

}
