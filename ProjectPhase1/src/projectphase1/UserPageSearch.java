package projectphase1;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class UserPageSearch {
    @FXML
    public TextField search;

    public static String token;

    @FXML
    public void mainToggle(ActionEvent event) throws IOException {
        token = search.getText();
        SceneController m = new SceneController();
        m.changeScene("UserSearchPage.fxml");
    }
}
