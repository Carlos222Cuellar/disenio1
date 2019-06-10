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
        return (cn.getValores("SELECT IdProductos,nombre FROM Productos where IdCategoria= '"+categoria+"'"));
    }
    
    
    /**
     * @param producto
     *  @return devuelve producto segun su id ingressado
     */     
    public ResultSet productobyid( String producto) {
        return (cn.getValores("SELECT nombre FROM Productos where IdCategoria= '"+producto+"'"));
    }
    
   public void modificarproducto (String IdProducto,String nombre)
   {
  cn.UID("UPDATE productos SET nombre='" + nombre + "' WHERE IdProductos='" + IdProducto + "'");
   
   }
    public void eliminar (String IdProducto)
   {
  cn.UID("DELETE FROM productos WHERE IdProductos='" + IdProducto + "'");
   
   }
    
    
}
