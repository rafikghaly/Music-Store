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
import javafx.scene.control.TextField;
//import javax.print.attribute.SetOfIntegerSyntax;
import static projectphase1.Store.songs;

public class AdminWelcomeController implements Initializable {

    @FXML
    private ListView<String> myListView;

    @FXML
    private Label myLabel;
    String[] song = new String[Store.songs.size()];
    String currentSong;
   @FXML
      public TextField descriptionField;
      public static String Name;

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

    @FXML
    public void removeMusic(ActionEvent event) throws IOException {
        currentSong = myListView.getSelectionModel().getSelectedItem().split(" ")[0];
        SystemManager.removeMusic(currentSong);
        SystemManager.listmusic();
        myListView.getItems().remove(myListView.getSelectionModel().getSelectedIndex());

    }
    public void categoryToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("Admin_Welcome2.fxml");

    }
    public void editDescription(ActionEvent event) throws IOException {
        Name = myListView.getSelectionModel().getSelectedItem().split(" ")[0];
        SceneController m = new SceneController();
        m.changeScene("editDescription.fxml");
    }
     public void editCategory(ActionEvent event) throws IOException {
        Name = myListView.getSelectionModel().getSelectedItem().split(" ")[0];
        SceneController m = new SceneController();
        m.changeScene("editCategory.fxml");
    }
}
