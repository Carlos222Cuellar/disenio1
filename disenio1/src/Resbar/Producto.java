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



public class Producto {
      Conexionn cn = new Conexionn();

    public ResultSet llenarProductos( String categoria) {
        return (cn.getValores("SELECT IdProductos,nombre FROM Productos where IdCategoria= '"+categoria+"'"));
    }
    
}
