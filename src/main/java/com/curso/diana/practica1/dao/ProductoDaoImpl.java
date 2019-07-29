package com.curso.diana.practica1.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.curso.diana.practica1.dto.Producto;
import com.curso.diana.practica1.persistence.ProductoMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductoDaoImpl implements ProductoMapper {
	@NonNull
	protected final SqlSession sqlSession;
	
	@Override
	public void crearTablaProductos() {
		this.sqlSession.getMapper(ProductoMapper.class).crearTablaProductos();
	}
	
	@Override
	public void crearSecuenciaProductos() {
		this.sqlSession.getMapper(ProductoMapper.class).crearSecuenciaProductos();
	}
	
	@Override
	public List<Producto> obtenerProductos(Integer catalogoId) {
		return this.sqlSession.getMapper(ProductoMapper.class).obtenerProductos(catalogoId);
	}
	
	public List<Producto> buscarProducto(Integer id) {
		return this.sqlSession.getMapper(ProductoMapper.class).buscarProducto(id);
	}
	
	@Override
	public void insertarProducto(Producto producto) {
		this.sqlSession.getMapper(ProductoMapper.class).insertarProducto(producto);
	}
	
	@Override
	public void eliminarProducto(Integer id) {
		this.sqlSession.getMapper(ProductoMapper.class).eliminarProducto(id);
	}
	
	@Override
	public void editarProducto(Producto producto) {
		this.sqlSession.getMapper(ProductoMapper.class).editarProducto(producto);
	}
	
	public Producto crearProducto(String nombre, String descripcion, Double precio, Integer catalogoId) {
		return new Producto(null, nombre, descripcion, precio, catalogoId);
	}
	
	public Producto crearProducto(Integer id, String nombre, String descripcion, Double precio, Integer catalogoId) {
		return new Producto(id, nombre, descripcion, precio, catalogoId);
	}
	
	@PostConstruct
	protected void init() {
		crearSecuenciaProductos();
		crearTablaProductos();
		
		//Agregar productos de prueba
		Producto p1 = new Producto(null, "Kit-Kat", "Chocolate kit-kat con mucha azucar pal niño pa la niña", 16.50, 2);
		Producto p2 = new Producto(null, "El hombre en busca de sentido", "Libro de psicología humanista enfocado a logoterapia de Viktor Frankl", 250.00, 1);

		insertarProducto(p1);
		insertarProducto(p2);
	}
}
