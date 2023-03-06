
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
//import javax.print.attribute.SetOfIntegerSyntax;
import static projectphase1.Store.songs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import static projectphase1.AdminWelcomeController.Name;
import static projectphase1.Category.categories;
import static projectphase1.Store.songs;

public class AdminController2 implements Initializable {

    @FXML
    private ListView<String> myListView;

    @FXML
    private Label myLabel;
    String[] song = new String[Category.categories.size()];
    String currentSong;
   

    @FXML
    public void userLogOut(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("Login.fxml");
    }

    @FXML
    public void addMusic(ActionEvent event) throws IOException {

        SceneController m = new SceneController();
        m.changeScene("addMusic.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        for (int i = 0; i < Category.categories.size(); i++) {
            
            song[i] = categories.get(i);
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

    @FXML
    public void removecat(ActionEvent event) throws IOException {
        currentSong = myListView.getSelectionModel().getSelectedItem();
        System.out.println(currentSong);
        SystemManager.removeCat(currentSong);
        myListView.getItems().remove(myListView.getSelectionModel().getSelectedIndex());

    }
    public void musicToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("Admin_Welcome.fxml");

    }
   
}
