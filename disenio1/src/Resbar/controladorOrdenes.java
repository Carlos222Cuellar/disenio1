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
public class controladorOrdenes {
    
       Conexionn cn = new Conexionn();//instancia de la clase conexion
    
    //me devuelve una coleccion de ordenes desde la base de datos
    public ResultSet llenarOrdenes() {
        return (cn.getValores("SELECT * FROM Ordenes"));
    }
    
}
