package main.java.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Welcome {
    public void displayWelcome() throws Exception {
        Image icon = loadImage("/resource/image/mainIcon.png");

        Stage stage = new Stage();
        Parent layout = loadFXML("/resource/views/WelcomeView.fxml");
        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setTitle("R4PPZ");
        stage.setResizable(false);
        stage.show();
    }

    private Parent loadFXML(String path) throws Exception {
        return FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
    }

    private Image loadImage(String path) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }
}
