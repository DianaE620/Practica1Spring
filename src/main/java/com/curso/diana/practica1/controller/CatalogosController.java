package com.curso.diana.practica1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.diana.practica1.dao.CatalogoDaoImpl;
import com.curso.diana.practica1.dto.Catalogo;
import com.curso.diana.practica1.dto.RequestResponse;

@RestController
@RequestMapping("/catalogos")
public class CatalogosController {
	@Autowired
	protected CatalogoDaoImpl catalogoDao;
	
	@GetMapping(path="/test",produces = "text/plain")
	public String pruebaRest() {
		return "Hola Mundo";
	}
	
	//Agregar nuevo cat�logo
	@PostMapping(path="/nuevo",produces = "application/json")
	public RequestResponse addNewCatalog(@RequestBody Catalogo catalog) {
		if(catalog.getNombre() == null || catalog.getNombre() == "") {
			return new RequestResponse("failed", "03", "Error: El nombre del cat�logo no puede estar vacio.");
		}
		
		Catalogo nuevo = catalogoDao.crearCatalogo(catalog.getNombre());
		catalogoDao.insertarCatalogo(nuevo);
		return new RequestResponse("success", "00", "Nuevo cat�logo agregado: " + catalog.getNombre());
	}
	
	//Consulta de todos lo cat�logos
	@GetMapping(path="",produces = "application/json")
	public List<Catalogo> searchCatalogsAndShow() {
		return catalogoDao.mostrarCatalogos();
	}
	
	//Eliminar cat�logo
	@DeleteMapping(path = "/eliminar",produces = "application/json")
	public RequestResponse deleteCatalog(@RequestBody Catalogo catalog) {
		if(catalog.getId() == null || catalog.getId() == 0) {
			return new RequestResponse("failed", "03", "Error: El id del cat�logo no puede estar vacio o ser 0.");
		}
		
		List<Catalogo> busqueda = catalogoDao.buscarCatalogo(catalog.getId());
		
		if(busqueda.size() == 0) {
			return new RequestResponse("failed", "05", "Error: No se encontro ning�n cat�logo con el id enviado.");
		}
		
		catalogoDao.eliminarCatalogo(catalog.getId());
		return new RequestResponse("success", "00", "El cat�logo se elimino correctamente");
	}
	
	//Editar cat�logo
	@PatchMapping(path = "/editar",produces = "application/json")
	public RequestResponse editCatalog(@RequestBody Catalogo catalog) {
		if(catalog.getId() == null || catalog.getId() == 0) {
			return new RequestResponse("failed", "03", "Error: El id del cat�logo no puede estar vacio o ser 0.");
		}
		
		List<Catalogo> busqueda = catalogoDao.buscarCatalogo(catalog.getId());
		
		if(busqueda.size() == 0) {
			return new RequestResponse("failed", "05", "Error: No se encontro ning�n cat�logo con el id enviado.");
		}
		
		catalogoDao.editarCatalogo(catalog.getId(), catalog.getNombre());
		return new RequestResponse("success", "00", "El cat�logo se edito correctamente");
	}
	
	
}
