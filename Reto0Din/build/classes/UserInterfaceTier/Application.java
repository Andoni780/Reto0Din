package UserInterfaceTier;

import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal para iniciar la aplicación de la interfaz gráfica
 * 
 * @author andoni
 */
public class Application extends javafx.application.Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // Cargar la interfaz desde el archivo FXML
        Parent root = FXMLLoader.load(getClass().getResource("VentanaUser.fxml"));
        
        // Crear la escena con la interfaz cargada
        Scene scene = new Scene(root);
        
        // Configurar la escena en el escenario y mostrar
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal para lanzar la aplicación
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);  // Iniciar la aplicación
    }
    
}