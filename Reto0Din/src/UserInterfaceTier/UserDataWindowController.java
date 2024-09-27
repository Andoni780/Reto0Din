package UserInterfaceTier;

import DataAccessTier.DBUserDataAccessor;
import DataAccessTier.DataAccesible;
import DataAccessTier.UserManagerFactory;
import model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Controlador para la ventana de datos del usuario
 * 
 * @author asier
 */
public class UserDataWindowController implements Initializable {

    private DataAccesible dataAccessor;

    @FXML
    private Label txtnombre;

    @FXML
    private Label txtapellido;

    @FXML
    private Label txtemail;

    @FXML
    private Label txtdni;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            // Comprobar si el dataAccessor no es nulo
            if (dataAccessor != null) {
                // Obtener el usuario desde la base de datos o archivo
                User usuario = UserManagerFactory.comprobarDB();

                // Mostrar los datos del usuario en las etiquetas
                txtnombre.setText(usuario.getNombre());
                txtapellido.setText(usuario.getApellido());
                txtdni.setText(usuario.getDni());
                txtemail.setText(usuario.getEmail());
            }
        } catch (Exception e) {
            // Registrar error y mostrar alerta
            Logger.getLogger("UserInterfaceTier.ui").severe(e.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage(), ButtonType.OK).showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Inicializar dataAccessor con acceso a la base de datos
            dataAccessor = new DBUserDataAccessor();

            // Limpiar etiquetas al iniciar
            txtnombre.setText("");
            txtapellido.setText("");
            txtdni.setText("");
            txtemail.setText("");
            
        } catch (Exception e) {
            // Registrar error y mostrar alerta
            Logger.getLogger("UserInterfaceTier.ui").severe(e.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage(), ButtonType.OK).showAndWait();
        }
    }
}