package projectphase1;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import static projectphase1.Store.songs;
import static projectphase1.SystemManager.currentUser;


public class UserPageCart implements Initializable {

    @FXML
    private ListView<String> myListView;

    @FXML
    private Label myLabel;

    @FXML
    private Label pricelabel;

    String[] song = new String[Cart.musicCarts.size()];
    String currentSong, pricestring;

    @FXML
    public void userLogOut(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("Login.fxml");

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        for (int i = 0; i < Cart.musicCarts.size(); i++) {
            String tmpname = Cart.musicCarts.get(i).getName();
            song[i] = Cart.musicCarts.get(i).getName().concat(" ").concat(Float.toString(Cart.musicCarts.get(i).music.getPrice()))
                    .concat(" EGP x ").concat(Integer.toString(((Customer) currentUser).cart.getInside(tmpname).getQuantity()));

        }

        //song[Cart.musicCarts.size()] = "Total price is: ".concat(Float.toString(currentUser.cart.getTotalPrice()));
        pricelabel.setText(Float.toString(currentUser.cart.getTotalPrice()));
        myListView.getItems().addAll(song);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                currentSong = myListView.getSelectionModel().getSelectedItem();
                myLabel.setText(currentSong);
            }

        });

    }

    public void removeFromCart(ActionEvent event) throws IOException {
        currentSong = myListView.getSelectionModel().getSelectedItem().split(" ")[0];
        SystemManager.removeFromCart(currentSong);
        myListView.getItems().remove(myListView.getSelectionModel().getSelectedIndex());

    }

    public void mainToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("UserPage.fxml");

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

    public void searchToggle(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("searchPage.fxml");

    }

    public void checkout(ActionEvent event) throws IOException {
        try {
            if (currentUser.cart.getTotalPrice() > 0) {
                SceneController m = new SceneController();
                m.changeScene("checkoutPage.fxml");
            } else {
                throw new EmptyCartException("Cart is empty - Empty Cart Error");
            }
        } catch (EmptyCartException e) {
            ButtonType foo = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    e.getMessage().split(" - ")[0],
                    foo);

            alert.setTitle(e.getMessage().split(" - ")[1]);
            Optional<ButtonType> result = alert.showAndWait();
        }


    }
}
