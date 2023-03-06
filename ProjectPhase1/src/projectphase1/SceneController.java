package projectphase1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

    public class SceneController extends Application {

    private static Stage stg;
    private ListView mListView = new ListView();
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        stg = primaryStage;
       Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Group root1 = new Group();
        Scene scene= new Scene(root);
        Scene scene1 = new Scene(root1, Color.BLACK);
       //Image icon = new Image("C:\\Users\\HP\\Desktop\\mina\\advanced programming\\ProjectPhase1\\src\\projectphase1\\Popular-Music-icon-in-round-black-color-on-transparent-background-PNG.png");
     //  primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Music Store");
        primaryStage.setScene(scene1);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
        
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        launch(args);
    }
   
}