package DAO;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import ddbb.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;


public class DAOCrud extends Conexion{
    
    public void registrar (Cliente cliente) throws Exception{
        try {
            this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("INSERT INTO cliente (nombre, edad, ocupacion) VALUES (?,?,?)");
        st.setString(1, cliente.getNombre());
        st.setInt(2, cliente.getEdad());
        st.setString(3, cliente.getOcupacion());
        st.executeUpdate();
        st.close();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }

    }
    
    public  List<Cliente> mostrar() throws Exception{
        List<Cliente> lista = null;
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM cliente;");
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEdad(rs.getInt("edad"));
                cliente.setOcupacion(rs.getString("ocupacion"));
                
                lista.add(cliente);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
        return lista;
    }
    
    public void eliminar(int id) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM cliente where id = ?;");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
        
    public void actualizar (Cliente cliente) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE cliente SET nombre = ?, edad = ?, ocupacion = ? WHERE id = ?;") ;
            st.setString(1, cliente.getNombre());
            st.setInt(2, cliente.getEdad());
            st.setString(3, cliente.getOcupacion());
            st.setInt(4, cliente.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
}
