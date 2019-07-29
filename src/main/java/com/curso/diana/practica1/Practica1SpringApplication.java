package com.curso.diana.practica1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.diana.practica1.dao.CatalogoDaoImpl;

@SpringBootApplication
public class Practica1SpringApplication {
	
	@Autowired
	protected CatalogoDaoImpl catalogoDao;

	public static void main(String[] args) {
		SpringApplication.run(Practica1SpringApplication.class, args);
		
//		CommandLineRunner runner() {
//			
//		}
		
	}

}
