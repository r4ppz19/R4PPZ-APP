package main.java.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import main.java.model.Insult1;
import main.java.model.Insult2;
import main.java.model.Insult3;

import java.util.Random;

public class WelcomeController {

    private final Random random = new Random();
    private final Insult1 insult1 = new Insult1();
    private final Insult2 insult2 = new Insult2();
    private final Insult3 insult3 = new Insult3();

    public void truthButton(ActionEvent actionEvent) {
        startInsultThread();
        closeWelcomeView(actionEvent);
    }

    private void startInsultThread() {
        new Thread(() -> {
            try {
                for (int i = 0; i < 500; i++) {
                    int randomInsult = random.nextInt(3);
                    displayInsult(randomInsult);
                    Thread.sleep(400);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void displayInsult(int randomInsult) {
        Platform.runLater(() -> {
            try {
                switch (randomInsult) {
                    case 0:
                        insult2.displayInsult2();
                         break;
                    case 1: 
                        insult1.displayInsult1();
                        break;
                    case 2:
                        insult3.displayInsult3();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void closeWelcomeView(ActionEvent actionEvent) {
        Stage welcomeView = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        welcomeView.close();
    }
}
