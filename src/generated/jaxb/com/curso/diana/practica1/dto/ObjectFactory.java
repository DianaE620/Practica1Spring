//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.28 at 10:49:36 PM CDT 
//


package com.curso.diana.practica1.dto;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.curso.diana.practica1.dto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.curso.diana.practica1.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MostrarProductos }
     * 
     */
    public MostrarProductos createMostrarProductos() {
        return new MostrarProductos();
    }

    /**
     * Create an instance of {@link MostrarProductosResponse }
     * 
     */
    public MostrarProductosResponse createMostrarProductosResponse() {
        return new MostrarProductosResponse();
    }

    /**
     * Create an instance of {@link SalidaProductos }
     * 
     */
    public SalidaProductos createSalidaProductos() {
        return new SalidaProductos();
    }

    /**
     * Create an instance of {@link InsertarProducto }
     * 
     */
    public InsertarProducto createInsertarProducto() {
        return new InsertarProducto();
    }

    /**
     * Create an instance of {@link InsertarProductoResponse }
     * 
     */
    public InsertarProductoResponse createInsertarProductoResponse() {
        return new InsertarProductoResponse();
    }

    /**
     * Create an instance of {@link SalidaGeneral }
     * 
     */
    public SalidaGeneral createSalidaGeneral() {
        return new SalidaGeneral();
    }

    /**
     * Create an instance of {@link EliminarProducto }
     * 
     */
    public EliminarProducto createEliminarProducto() {
        return new EliminarProducto();
    }

    /**
     * Create an instance of {@link EliminarProductoResponse }
     * 
     */
    public EliminarProductoResponse createEliminarProductoResponse() {
        return new EliminarProductoResponse();
    }

    /**
     * Create an instance of {@link EditarProducto }
     * 
     */
    public EditarProducto createEditarProducto() {
        return new EditarProducto();
    }

    /**
     * Create an instance of {@link EditarProductoResponse }
     * 
     */
    public EditarProductoResponse createEditarProductoResponse() {
        return new EditarProductoResponse();
    }

}