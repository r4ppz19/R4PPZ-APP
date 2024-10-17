package application.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Insult2 {
    private static final int RES_WIDTH = 1366; // Use private static final for constants
    private static final int RES_HEIGHT = 768; // Use private static final for constants

    public void displayInsult2() throws IOException {
        Stage stage = createStage();

        int posX = getRandomPosition(RES_WIDTH);
        int posY = getRandomPosition(RES_HEIGHT);

        setupStage(stage, posX, posY);
        stage.show();
    }

    private Stage createStage() throws IOException {
        Stage stage = new Stage();
        Image icon = loadImage("/resource/image/mainIcon.png");
        Parent layout = loadFXML("/resource/views/Insult2View.fxml");
        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.setTitle("FUCK YOU!");
        stage.getIcons().add(icon);
        stage.setResizable(false);

        return stage;
    }

    private int getRandomPosition(int maxWidth) {
        Random random = new Random();
        return random.nextInt(maxWidth - 200);
    }

    private void setupStage(Stage stage, int posX, int posY) {
        stage.setX(posX);
        stage.setY(posY);
        stage.setOnCloseRequest(event -> event.consume());

        // NOT ABLE TO MINIMIZE
        stage.iconifiedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                stage.setIconified(false); // Reset to not minimized
            }
        });
    }

    private Parent loadFXML(String path) throws IOException {
        return FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
    }

    private Image loadImage(String path) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }
}
