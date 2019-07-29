package com.curso.diana.practica1.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.curso.diana.practica1.dao.ProductoDaoImpl;
import com.curso.diana.practica1.dto.*;

@Endpoint
public class WebServiceEndpoint {
	@Autowired
	protected ProductoDaoImpl productosDao;

	public static final String NAMESPACE_URI = "http://www.openuri.org/";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "mostrarProductos")
	@ResponsePayload
	public MostrarProductosResponse MostrarProductos(@RequestPayload MostrarProductos request) {
		
		ObjectFactory factory = new ObjectFactory();
		MostrarProductosResponse response = factory.createMostrarProductosResponse();
		SalidaProductos salida = factory.createSalidaProductos();
		response.setMostrarProductosResult(salida);
		
		List<Producto> productos = null;
		String productosSt = "";
		
		if(request.getCatalogoId() == null || request.getCatalogoId() == 0) {
			productos = productosDao.obtenerProductos(0);
		}else {
			productos = productosDao.obtenerProductos(request.getCatalogoId());
		}
		
		if(productos.size() == 0) {
			salida.setCode("07");
			salida.setStatus("success");
			salida.setMensaje("No se encontró ningún producto en el catálogo");
		}else {
			salida.setCode("00");
			salida.setStatus("success");
			salida.setMensaje("Petición exitosa");
			
			for(int x = 0; x < productos.size() ; x++ ) {
				productosSt += "<col"+ (x+1) +">\n";
				productosSt += "<id>"+ productos.get(x).getId() +"</id>\n";
				productosSt += "<nombre>"+ productos.get(x).getNombre() +"</nombre>\n";
				productosSt += "<descripcion>"+ productos.get(x).getDescripcion() +"</descripcion>\n";
				productosSt += "<precio>"+ productos.get(x).getPrecio() +"</precio>\n";
				productosSt += "<catalogoId>"+ productos.get(x).getCatalogo_id() +"</catalogoId>\n";
				productosSt += "</col"+ (x+1) +">\n";
			}
			
		}
		
		salida.setProductos(productosSt);

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "insertarProducto")
	@ResponsePayload
	public InsertarProductoResponse InsertarProducto(@RequestPayload InsertarProducto request) {
		ObjectFactory factory = new ObjectFactory();
		InsertarProductoResponse response = factory.createInsertarProductoResponse();
		SalidaGeneral salida = factory.createSalidaGeneral();
		response.setInsertarProductoResult(salida);
		
		Producto nuevo = productosDao.crearProducto(request.getNombre(), request.getDescripcion(), request.getPrecio(), request.getCatalogoId());
		productosDao.insertarProducto(nuevo);
		
		salida.setCode("00");
		salida.setStatus("success");
		salida.setMensaje("Nuevo producto agregado: " + request.getNombre());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "eliminarProducto")
	@ResponsePayload
	public EliminarProductoResponse EliminarProducto(@RequestPayload EliminarProducto request) {
		ObjectFactory factory = new ObjectFactory();
		EliminarProductoResponse response = factory.createEliminarProductoResponse();
		SalidaGeneral salida = factory.createSalidaGeneral();
		response.setEliminarProductoResult(salida);
		
		if(request.getProductoId() == 0) {
			salida.setCode("03");
			salida.setStatus("failed");
			salida.setMensaje("Error: El id del producto no puede estar vacio o ser 0.");
			return response;
		}
		
		List<Producto> busqueda = productosDao.buscarProducto(request.getProductoId());
		
		if(busqueda.size() == 0) {
			salida.setCode("05");
			salida.setStatus("failed");
			salida.setMensaje("Error: No se encontro ningún producto con el id enviado.");
		}else {
			productosDao.eliminarProducto(request.getProductoId());
			
			salida.setCode("00");
			salida.setStatus("success");
			salida.setMensaje("Producto eliminado");
		}
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "editarProducto")
	@ResponsePayload
	public EditarProductoResponse EditarProducto(@RequestPayload EditarProducto request) {
		ObjectFactory factory = new ObjectFactory();
		EditarProductoResponse response = factory.createEditarProductoResponse();
		SalidaGeneral salida = factory.createSalidaGeneral();
		response.setEditarProductoResult(salida);
		
		List<Producto> busqueda = productosDao.buscarProducto(request.getId());
		
		if(busqueda.size() == 0) {
			salida.setCode("05");
			salida.setStatus("failed");
			salida.setMensaje("Error: No se encontro ningún producto con el id enviado.");
			return response;
		}
		
		Producto editado = productosDao.crearProducto(request.getId(), request.getNombre(), request.getDescripcion(), request.getPrecio(), request.getCatalogoId());
		
		productosDao.editarProducto(editado);
		salida.setCode("00");
		salida.setStatus("success");
		salida.setMensaje("Producto editado");
		
		return response;
	}
}
