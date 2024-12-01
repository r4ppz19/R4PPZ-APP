package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Get CSS
        //String css = Objects.requireNonNull(this.getClass().getResource("/resource/css/Main.css")).toExternalForm();

        // Load the application icon and the main view layout
        Image icon = loadImage();
        Parent layout = loadFXML();

        Scene scene = new Scene(layout);
        //scene.getStylesheets().add(css); // Load CSS to scene

        primaryStage.setScene(scene);
        primaryStage.setTitle("r4ppz");
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    private Image loadImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/image/mainIcon.png")));
    }

    private Parent loadFXML() throws Exception {
        return FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/MainView.fxml")));
    }

}
