package projectphase1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class AddMusicController {

    @FXML
    public void backToAdmin(ActionEvent event) throws IOException {
        SceneController m = new SceneController();
        m.changeScene("Admin_Welcome.fxml");
    }

    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField categoryTextfield;
    @FXML
    private TextField mainCategory;
    @FXML
    private TextField durationTextfield;
    @FXML
    private TextField releaseDateTextfield;
    @FXML
    private TextField artistTextfield;
    @FXML
    private TextField quantityTextfield;
    @FXML
    private TextField priceTextfield;
    @FXML
    private TextField descriptionTextfield;

    @FXML
    public void addMuic(ActionEvent event) throws Exception {
        try {

            String name = nameTextfield.getText();
            String category = categoryTextfield.getText();
            String duration = durationTextfield.getText();
            String description = descriptionTextfield.getText();
            String releaseDate = releaseDateTextfield.getText();
            String artist = artistTextfield.getText();
            String quantity = quantityTextfield.getText();
            String price = priceTextfield.getText();

            if (name.equals("") || category.equals("") || duration.equals("") || description.equals("") || releaseDate.equals("")
                    || artist.equals("") || quantity.equals("") || price.equals("")) {
                throw new EmptyFieldException("One or more fields are Empty - Empty Field Error");
            }
            if (!SystemManager.addMusic(name, category, duration, description, releaseDate, artist, Integer.parseInt(quantity), Float.parseFloat(price))) {
                throw new InvalidCategoryException("Category not found - Category Not Found Error");

            } else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Music has been added to: " + category);
                alert.setTitle("Music added");
                Optional<ButtonType> result = alert.showAndWait();

            }

        } catch (EmptyFieldException e) {
            ButtonType foo = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    e.getMessage().split(" - ")[0],
                    foo);

            alert.setTitle(e.getMessage().split(" - ")[1]);
            Optional<ButtonType> result = alert.showAndWait();
        } catch (InvalidCategoryException e) {
            ButtonType foo = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    e.getMessage().split(" - ")[0],
                    foo);

            alert.setTitle(e.getMessage().split(" - ")[1]);
            Optional<ButtonType> result = alert.showAndWait();
        } catch (NumberFormatException e) {
            ButtonType foo = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Price must be float and quantity must be Integer",
                    foo);

            alert.setTitle("Parse Error");
            Optional<ButtonType> result = alert.showAndWait();
        } finally {
            nameTextfield.clear();
            categoryTextfield.clear();
            durationTextfield.clear();
            descriptionTextfield.clear();
            releaseDateTextfield.clear();
            artistTextfield.clear();
            quantityTextfield.clear();
            priceTextfield.clear();

        }
    }

    public void addCategory(ActionEvent event) throws IOException {

        String category = mainCategory.getText();
        try {

            if (category.equals("")) {
                throw new EmptyFieldException("Please enter a category - Empty Field Error");
            }

            if (!Category.checkCategory(category)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Category [" + category + "] has been added!");
                alert.setTitle("Category added");
                Optional<ButtonType> result = alert.showAndWait();
                SystemManager.addCat(category);

            }
            else
            {
             Alert alert = new Alert(Alert.AlertType.WARNING, "Category [" + category + "] already exists!");
                alert.setTitle("Category Warning");
                Optional<ButtonType> result = alert.showAndWait();
            
            }
            mainCategory.clear();
        } catch (EmptyFieldException e) {
            ButtonType foo = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    e.getMessage().split(" - ")[0],
                    foo);

            alert.setTitle(e.getMessage().split(" - ")[1]);
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
}
