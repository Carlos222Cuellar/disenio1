/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resbar;

import conexion.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author cuellar
 */



public class Productos {
      Conexion cn = new Conexion();

    public ResultSet llenarProductos( String categoria) {
        return (cn.getValores("SELECT IdProductos,nombre FROM Productos where IdCategoria= '"+categoria+"'"));
    }
    
}
