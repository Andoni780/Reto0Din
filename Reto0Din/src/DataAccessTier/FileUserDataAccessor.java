package DataAccessTier;

import static DataAccessTier.UserManagerFactory.fichConf;
import java.util.Properties;
import java.util.ResourceBundle;
import model.User;

/**
 * Implementación de DataAccesible para acceder a datos de usuario desde archivo de configuración
 * 
 * @author andoni
 */
public class FileUserDataAccessor implements DataAccesible {
    @Override
    public User getUser() {
        Properties properties = new Properties();
        try {
            // Cargar archivo de configuración
            fichConf = ResourceBundle.getBundle("DataAccessTier.FileUserDataAccessor");
            
            // Obtener datos del usuario
            String dni = fichConf.getString("dni");
            String nombre = fichConf.getString("nombre");
            String apellido = fichConf.getString("apellido");
            String gmail = fichConf.getString("gmail");
            
            // Crear objeto User con los datos
            User usuario = new User(nombre, apellido, gmail, dni);
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();  // Manejar excepción
        }
    
        throw new UnsupportedOperationException("Not supported yet.");  // Método no implementado completamente
    }
}
