package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Login {

    private static final String USERNAME = "r4ppz"; // Use static final for constants
    private static final String PASSWORD = "12312005"; // Use static final for constants

    public String getPassword() { // Use camelCase for method names
        return PASSWORD;
    }

    public String getUsername() { // Use camelCase for method names
        return USERNAME;
    }

    public void displayLogin() throws Exception {
        Stage stage = new Stage();
        Parent layout = loadFXML();
        Image icon = loadImage();

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }

    private Parent loadFXML() throws Exception {
        return FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/resource/views/LoginView.fxml")));
    }

    private Image loadImage() {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resource/image/mainIcon.png")));
    }
}
