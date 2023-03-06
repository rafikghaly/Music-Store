package projectphase1;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Description {
    @FXML
      public TextField descriptionField;

    public void editMusic(ActionEvent event) throws IOException {
        String description = descriptionField.getText() ;
        SystemManager.editDesc(AdminWelcomeController.Name,description);
        SystemManager.listmusic();
        SceneController m = new SceneController();
        m.changeScene("Admin_Welcome.fxml");
    }
    @FXML
    public void mainToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("Admin_Welcome.fxml");
    }
}
