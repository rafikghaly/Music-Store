package projectphase1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;

import javafx.scene.text.Text;

public class LoginController {

    public LoginController() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();


    }

    private void checkLogin() throws IOException {
        try {
            SceneController m = new SceneController();
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("1234")) {

                m.changeScene("Admin_Welcome.fxml");
            } else if (username.getText().toString().equals("user") && password.getText().toString().equals("12345")) {
                m.changeScene("UserPage.fxml");
            } else {
               throw new InvalidLoginError("Invalid Login Credentials - Login failed");

            }
        } catch (InvalidLoginError e){
            ButtonType foo = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    e.getMessage().split(" - ")[0],
                    foo);

            alert.setTitle(e.getMessage().split(" - ")[1]);
            Optional<ButtonType> result = alert.showAndWait();
        }
    }


}