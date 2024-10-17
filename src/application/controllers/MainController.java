package application.controllers;

import application.main.Insult1;
import application.main.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    private final Login login = new Login();
    private final Insult1 insult1 = new Insult1();

    @FXML
    public void displayWindow3Button(ActionEvent actionEvent) throws Exception {
        login.displayLogin(); // Display the login window
        closeCurrentWindow(actionEvent); // Close the current window
    }

    private void closeCurrentWindow(ActionEvent actionEvent) {
        Stage currentWindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentWindow.close(); // Close the current window
    }

    public void secondSceneButton(ActionEvent actionEvent) throws IOException {
        Parent secondScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/resource/views/Insult1View.fxml")));
        Stage stage = new Stage();
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(secondScene);
        stage.setScene(scene);
        stage.show();
    }
}
