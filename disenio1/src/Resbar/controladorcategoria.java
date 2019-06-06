/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resbar;

import java.sql.ResultSet;
import conexion.Conexionn;

/**
 *
 * @author cuellar
 */
public class controladorcategoria {
    
     Conexionn cn = new Conexionn();

     
     
     //me devuelve una coleccion de categorias desde la base de datos
    public ResultSet llenarCategorias() {
        return (cn.getValores("SELECT * FROM Categorias"));
    }
    
    //modifica un valor de categorias a partir de si id
     public void modificar(String id, String nombre) {
        cn.UID("UPDATE Categorias SET nombre='" + nombre + "' WHERE IdCategoria='" + id + "'");
    }
    
    //Este metodo me trae una Categoria de la base de datos por medio de su IdCategoria
    public ResultSet llenarProductos( String categoria) {
        return (cn.getValores("SELECT IdProductos,nombre FROM Productos where IdCategoria= '"+categoria+"'"));
    }
    
    
}
