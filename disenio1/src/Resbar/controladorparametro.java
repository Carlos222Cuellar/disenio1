
package Resbar;

import conexion.Conexionn;
import java.sql.ResultSet;


public class controladorparametro {
    
    
    Conexionn cn = new Conexionn();

     
     
     //me devuelve una coleccion de parametros desde la base de datos
    public ResultSet llenarParametros() {
        
        return (cn.getValores("SELECT * FROM parametros"));
    }
    
    //modifica un valor de parametros a partir de si id
    
     public void modificarParametro(String id, String valor) {
        
        cn.UID("UPDATE parametros SET valor='" + valor + "' WHERE IdParametros='" + id + "'");
    }
    
    //Este metodo me trae una parametros de la base de datos por medio de su IdParametros
    public ResultSet llenarParametros( String parametros) {
        return (cn.getValores("SELECT IdParametros,nombre FROM parametros where IdParametros= '"+parametros+"'"));
    }
    
    
}

    
    
    
    

