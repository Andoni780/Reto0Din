package DataAccessTier;

import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Implementación de DataAccesible para acceder a datos de usuarios desde MySQL
 * 
 * @author asier
 */
public class DBUserDataAccessor implements DataAccesible {
    private Connection con;

    public DBUserDataAccessor() throws SQLException, ClassNotFoundException {
        openConnection();  // Abrir conexión
    }

    private void openConnection() {
        try {
            // Conectar a la base de datos
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reto0din?serverTimezone=Europe/Madrid&useSSL=false", "root", "abcd*1234");
        } catch (SQLException e) {
            e.printStackTrace();  // Manejar excepción
        }
    }

    @Override
    public User getUser() throws SQLException {
        // Consulta SQL para obtener un usuario
        String query = "SELECT nombre, apellido, email, dni FROM usuario LIMIT 1"; 
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            // Crear objeto User con los datos
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String dni = rs.getString("dni");
            return new User(nombre, apellido, email, dni);
        }
        return null;  // Si no hay resultados
    }
}
