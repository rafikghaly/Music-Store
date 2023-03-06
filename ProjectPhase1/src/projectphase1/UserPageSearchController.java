package projectphase1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static projectphase1.Store.songs;


public class UserPageSearchController implements Initializable {

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

        currentSong = myListView.getSelectionModel().getSelectedItem().split(" - ")[0].split(":")[1].trim();
        SystemManager.addToCart(currentSong);
        myListView.getItems().remove(myListView.getSelectionModel().getSelectedIndex());
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String name = UserPageSearch.token;
        int c = 0;
        boolean isFound = false;
        try {
            for (int i = 0; i < Store.songs.size(); i++) {


                if (Store.songs.get(i).getName().toLowerCase().contains(name.toLowerCase()) || Store.songs.get(i).getArtist().toLowerCase().contains(name.toLowerCase()) || Store.songs.get(i).getCategory().toLowerCase().contains(name.toLowerCase())) {
                  song[c] = String.format("Name: %s - Category: %s - Duration: %s - Description: %s - Release Date: %s - Artist: %s - " +
                                    "Quantity: %d - Price: %.2f",
                            Store.songs.get(i).getName(), Store.songs.get(i).getCategory(), Store.songs.get(i).getDuration(), Store.songs.get(i).getDescription(), Store.songs.get(i).getReleaseDate(), Store.songs.get(i).getArtist(),
                            Store.songs.get(i).getQuantity(), Store.songs.get(i).getPrice());
                    c++;

                    isFound = true;
                } else {
                    song[i] = " ";
                }

            }
            if (!isFound) {
                throw new NoMusicFoundException("No Music Found - Music Not Found Error");
            }
        } catch (NoMusicFoundException e) {
            ButtonType foo = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    e.getMessage().split(" - ")[0],
                    foo);

            alert.setTitle(e.getMessage().split(" - ")[1]);
            Optional<ButtonType> result = alert.showAndWait();


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
    @FXML
    public void mainToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("UserPage.fxml");
    }
}
