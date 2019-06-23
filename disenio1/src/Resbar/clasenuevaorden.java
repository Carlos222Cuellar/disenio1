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
 * @author willi
 */
public class clasenuevaorden {
    
   Conexionn cn = new Conexionn();
    

     
     
         public ResultSet contarRegistros(){
        return (cn.getValores("SELECT MAX(IdOrden) FROM Ordenes"));
        
        
    }
    
         
          public void insertar(String IdOrden ,String mesa, String mesero, String cliente, String observacion) {
        cn.UID("INSERT INTO Ordenes(IdOrden,mesa,mesero,cliente,observacion) VALUES('" + IdOrden + "','" + mesa + "','" + mesero + "','" + cliente + "','" + observacion + "')");
    }
}
