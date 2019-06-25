/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resbar;

import conexion.Conexionn;
import java.sql.ResultSet;

/**
 *
 * @author cuellar
 */



public class controladorproducto {
      Conexionn cn = new Conexionn();
      
      
       
     //me devuelve una coleccion de productos desde la base de datos

    /**
     *
     * @return una coleccion de productos
     */
    public ResultSet llenarProductos() {
        return (cn.getValores("SELECT * FROM Productos"));
    }

      
    //me devuelve productos segun id categoria  

    /**
     *
     * @param categoria
     * @return un producto segun el id de categoria que se le pase como parametro
     */
    public ResultSet llenarProductos( String categoria) {
        return (cn.getValores("SELECT IdProductos,nombre,precio,esPreparado FROM Productos where IdCategoria= '"+categoria+"'"));
    }
    public ResultSet findByName( String nombre) {
        return (cn.getValores("SELECT IdProductos,nombre,precio FROM Productos where nombre= '"+nombre+"'"));
    }
    
    /**
     * @param producto
     *  @return devuelve producto segun su id ingressado
     */     
    public ResultSet productobyid( String producto) {
        return (cn.getValores("SELECT nombre,precio FROM Productos where IdCategoria= '"+producto+"'"));
    }
     /**
    *
    *
    *@param IdProducto Id del producto a realizar UPDATE 
    * @param  nombre  nombre del producto 
    * @param precio   precio del producto
    * @param  esPreparado 
    *
    */
    
   public void modificarproducto (String IdProducto,String nombre,String precio,String esPreparado)
   {
  cn.UID("UPDATE productos SET nombre='" + nombre + "', precio='" + precio + "', esPreparado='" + esPreparado + "' WHERE IdProductos='" + IdProducto + "'");
   
   }
    /**
    *
    *
    *@param IdProducto Id del producto a eliminar
    * 
    */
    public void eliminar (String IdProducto)
   {
  cn.UID("DELETE FROM productos WHERE IdProductos='" + IdProducto + "'");
   
   }
     public void insertarproducto (String IdProductos,String nombre,double precio,String esPreparado,String IdCategoria)
   {
  cn.UID("INSERT INTO productos(IdProductos,nombre,precio,esPreparado,IdCategoria) VALUES('" +IdProductos+ "', '" + nombre + "','" + precio + "','" + esPreparado + "','" + IdCategoria + "')");
   
   }
      public ResultSet contarRegistros(){
        return (cn.getValores("SELECT MAX(IdProductos) FROM productos "));
      }
      
       public ResultSet traerprecio(String producto){
        return (cn.getValores("select IdProductos,precio from Productos where nombre like '"+producto+"';"));
      }
       
       
    public ResultSet findByIdOrden(String IdOrden){
        
        return (cn.getValores("select  nombre,cantidad,Productos.precio from DetalleOrden inner join Productos on DetalleOrden.IdProductos=Productos.IdProductos where IdOrden= '"+IdOrden+"'"));
   
        
    }
    
    
    public void ModificarOrden (Double total,int cantidad,String observacion, String nombre,int IdOrden){
        
        cn.UID("update ordenes, detalleorden join dbpos.productos set ordenes.total='"+total+"',detalleorden.cantidad='"+cantidad+"', "
                + "Ordenes.observacion ='"+observacion+"' where detalleorden.IdProductos=( select IdProductos from dbpos.productos where nombre like '%"+nombre+ "%') "
                + "AND ordenes.IdOrden='"+IdOrden+"' and detalleorden.IdOrden='"+IdOrden+"'");
}
    
    
}
