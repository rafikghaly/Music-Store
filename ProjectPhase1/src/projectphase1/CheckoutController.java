
package projectphase1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static projectphase1.Store.songs;

public class CheckoutController {


    public void yes(ActionEvent event) throws IOException {
        SystemManager.currentUser.cart.clear();
        SceneController m = new SceneController();
        m.changeScene("UserPageCart.fxml");
    }

    @FXML
    public void no(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("UserPageCart.fxml");
    }


}


