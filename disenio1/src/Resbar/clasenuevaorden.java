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
    
         
          public void insertar(String IdOrden ,String mesa, String mesero, String cliente, String observacion,String fecha,String estado,String total) {
          cn.UID("INSERT INTO Ordenes(IdOrden,mesa,mesero,cliente,observacion,fecha,estado,total) VALUES('" + IdOrden + "','" + mesa + "','" + mesero + "','" + cliente + "','" + observacion + "','" + fecha + "','" + estado + "','" + total + "')");
    }
          
          
            public void insertardetalleorden(String IdOrden ,String IdProducto, String cantidad, String precio) {
            cn.UID("INSERT INTO DetalleOrden(IdOrden,IdProductos,cantidad,precio) VALUES('" + IdOrden + "','" + IdProducto + "','" + cantidad + "','" + precio + "')");
            
            
            
    }
            
            public void actualizardetalleorden(String idorden,String idproductos,String cantidad,String precio){
            cn.UID("UPDATE DetalleOrden SET IdProductos='" + idproductos + "', cantidad='" + cantidad + "', precio='" + precio + "' WHERE IdOrden='" + idorden + "'");
  
            
            }
            
            public void actualizarorden(String idorden,String observacion){
            cn.UID("UPDATE Ordenes SET  observacion='" + observacion + "' WHERE IdOrden='" + idorden + "'");
   
            
            }
            
                
    } 
