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
 * @author RoluX
 */
public class controladorventas {
    
    Conexionn cn = new Conexionn();
      public ResultSet obtenerproductos(String fecha1, String fecha2) {
   return(cn.getValores("SELECT nombre, cantidad FROM dbpos.productos, dbpos.detalleorden JOIN ordenes WHERE productos.IdProductos in (detalleorden.IdProductos) AND fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"'"));
        
    }

    
    /**
     *  @return devuelve las ventas del dia
     */     
    public ResultSet obtenerventas(String fecha1, String fecha2) {
      return(cn.getValores("SELECT fecha, total FROM dbpos.ordenes WHERE fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"';"));
    }
}
