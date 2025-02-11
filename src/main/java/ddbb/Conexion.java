package ddbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    protected Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/personax";
    
    private final String USER = "root";
    private final String PASS = "Leito357.";
    
    public void Conectar() throws ClassNotFoundException{
        try {
            System.out.println("conectando");
           conexion = DriverManager.getConnection(DB_URL, USER, PASS);
           Class.forName(JDBC_DRIVER);
            System.out.println("conexión con éxito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexión");
        } 
    }
   
    public void Cerrar() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        } 
    }
}
