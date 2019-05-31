package conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cuellar
 */
public class Conector {

    private Connection conexion;
    private String error = null;

    public Conector() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            this.conexion = DriverManager.getConnection("jdbc:mysql://" + "localhost" + ":3306/" + "DBpos", "SistemaPos", "pos2019sis");

        } catch (ClassNotFoundException | SQLException ex) {

            this.error = ex.getMessage();

        }

    }

    public String getError() {


        return this.error;


    }

    public Connection getConexion() {

        return this.conexion;

    }

    public void Cerrar() {
        try {

          this.conexion.close();
        } catch (SQLException ex) {

            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
