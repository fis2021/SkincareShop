package SKC.Controller;


import SKC.Exception.NoUpperCaseException;
import SKC.Exception.UncompletedFieldsException;
import SKC.Exception.UsernameAlreadyExistException;
import SKC.Services.UserService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private Label registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private Button logButton;

    public void handleRegisterAction() {

        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), nameField.getText(), emailField.getText(), addressField.getText(), phoneField.getText());
            registrationMessage.setText("Account created successfully!");
            handleLogAction();
        } catch (UncompletedFieldsException e) {
            registrationMessage.setText(e.getMessage());
        } catch (UsernameAlreadyExistException ee) {
            registrationMessage.setText(ee.getMessage());
        } catch (NoUpperCaseException eee) {
            registrationMessage.setText(eee.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleLogAction() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Stage scene = (Stage) logButton.getScene().getWindow();
        scene.setScene(new Scene(root, 720, 490));
        scene.setFullScreen(false);
    }

}


