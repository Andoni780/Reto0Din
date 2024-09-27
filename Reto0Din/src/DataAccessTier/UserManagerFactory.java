package DataAccessTier;

import java.util.ResourceBundle;
import model.User;

/**
 * Factoría para gestionar el acceso a datos desde archivo o base de datos
 * 
 * @author asier
 */
public class UserManagerFactory {
    public static DataAccesible data;
    public static ResourceBundle fichConf;
    public static String FichDB;
    
    public static User comprobarDB() throws Exception {
        try {
            // Cargar archivo de configuración
            fichConf = ResourceBundle.getBundle("DataAccessTier.FileODb");
            FichDB = fichConf.getString("data");
            
            // Comprobar si acceder a archivo o base de datos
            if (FichDB.equals("File")) {
                data = new FileUserDataAccessor();  // Acceso desde archivo
                return data.getUser();
            } else {
                data = new DBUserDataAccessor();  // Acceso desde base de datos
                return data.getUser();
            }
        } catch (Exception e) {
            throw e;  // Manejar excepción
        }
    }
}
