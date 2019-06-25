
package Resbar;

import Modelo.Ordenes;
import conexion.Conexionn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karenquintanilla
 */
public class ControladorAgregarOrden {
    
    Conexionn cn = new Conexionn();
    
    
    public Ordenes agregaOrden(Ordenes orden){
       try{
           cn.UID("INSERT INTO ordenes(fecha,mesero,mesa,cliente,estado,total,observacion) "
                + "values('"+ orden.getFecha() +"','"+ orden.getMesero() +"','"+ orden.getMesa() +"','"+ orden.getCliente() +"','"+ orden.getEstado() +"','"+ orden.getTotal() +"','"+ orden.getObservacion() +"')");
        return orden;
       }catch(Exception e){
          return null;
       }
       
    }
    
     /**
    *
    *
    *@param 
    * @return Retorna una coleecion de ordenes
    */
    public List<Ordenes> findAll(){
        List<Ordenes> ordenes = new ArrayList();
        try{
            ResultSet rs = cn.getValores("SELECT * FROM Ordenes");
         System.out.println("entra");
         while (rs.next()) {
             Ordenes orden = new Ordenes();
                orden.setIdOrden(Integer.parseInt(rs.getString("idOrden")));
                orden.setFecha(rs.getString("fecha"));
                orden.setMesero(rs.getString("mesero"));
                orden.setMesa(rs.getString("mesa"));
                orden.setCliente(rs.getString("cliente"));
                orden.setObservacion(rs.getString("observacion"));
               
                ordenes.add(orden);
                
            }   
         return ordenes;
        }catch(SQLException e){
            return null;
        }
        
        
        
        
         
    }
    /**
    *
    *
    *@param Id tipo entero
    * @return Retorna una observacion de la base de datos que coincida con el id de orden que se le pasa como paramentro
    */
    
    public ResultSet buscarobervacion(int Id){
        
        return (cn.getValores("select observacion from Ordenes where IdOrden='"+Id+"'"));
       
    }
    
    /**
    *
    *
    *@param mesa recibe un entero 
    * @return Retorna una una orden filtrada dependiendo de el numero de mesa que se ingrese
    */
   public ResultSet filtrarbymesa(int mesa){
   
   return(cn.getValores("select IdOrden,mesero,mesa,cliente from Ordenes where mesa like '%"+mesa+"%'"));
   } 
    
    
}
