package projectphase1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import static projectphase1.Store.songs;

public class UserPageController implements Initializable {

    @FXML
    private ListView<String> myListView;

    @FXML
    private Label myLabel;

    String[] song = new String[Store.songs.size()];
    String currentSong;

    @FXML
    public void userLogOut(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("Login.fxml");

    }
    @FXML
    public void addtoCart(ActionEvent event) throws IOException {
        
        currentSong = myListView.getSelectionModel().getSelectedItem().split(" - ")[0];
        SystemManager.addToCart(currentSong);
        myListView.getItems().remove(myListView.getSelectionModel().getSelectedIndex());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        for (int i = 0; i < Store.songs.size(); i++) {
            song[i] = songs.get(i).print();
        }
        myListView.getItems().addAll(song);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    
            
    @Override
    public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
        currentSong = myListView.getSelectionModel().getSelectedItem();
        myLabel.setText(currentSong);
            }

        });

    }
     public void soldToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("UserPageSold.fxml");

    }
     public void inStockToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("UserPageInstock.fxml");

    }
     public void filterToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("UserPageFilter.fxml");

    }
     public void cartToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("UserPageCart.fxml");

    }
      public void searchToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("searchPage.fxml");

    }
}
