/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resbar;

import java.sql.ResultSet;
import conexion.Conexion;

/**
 *
 * @author cuellar
 */
public class Categorias {
    
     Conexion cn = new Conexion();

    public ResultSet llenarCategorias() {
        return (cn.getValores("SELECT * FROM Categorias"));
    }
    
    
}
