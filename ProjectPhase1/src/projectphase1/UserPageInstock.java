package projectphase1;

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
import static projectphase1.Store.songs;

public class UserPageInstock implements Initializable {

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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int c =0;
        for (int i = 0; i < Store.songs.size(); i++) {
            
            
                if (!(songs.get(i).getQuantity() == 0)){
            song[c] = songs.get(i).print();
            c++;
                }
                else{ song[i] = " ";}
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
     public void mainToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("UserPage.fxml");

    }
     public void soldToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("UserPageSold.fxml");

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
