/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author ivanr
 */
public class Producto{
    public Producto(String claveProducto, String nombreProducto, String descripcion, String HechoEn, double precioCompra, double precioVenta, String compañiaFabricacion) {
        this.claveProducto = claveProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.HechoEn = HechoEn;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.compañiaFabricacion = compañiaFabricacion;
    }

    private String claveProducto;
    private String nombreProducto;
    private String descripcion;
    private String HechoEn;
    double precioCompra;
    double precioVenta;
    private String compañiaFabricacion;

    public Producto() {
    }

    public String getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(String claveProducto) {
        this.claveProducto = claveProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHechoEn() {
        return HechoEn;
    }

    public void setHechoEn(String HechoEn) {
        this.HechoEn = HechoEn;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCompañiaFabricacion() {
        return compañiaFabricacion;
    }

    public void setCompañiaFabricacion(String compañiaFabricacion) {
        this.compañiaFabricacion = compañiaFabricacion;
    }
}
