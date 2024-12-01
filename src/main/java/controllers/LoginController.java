package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.model.Login;
import main.java.model.Welcome;

public class LoginController {

    @FXML
    private Label incorrectLabel;  // Added private access modifier
    @FXML
    private PasswordField passwordTxtField; // Added private access modifier
    @FXML
    private TextField usernameTxtField; // Added private access modifier

    public void loginBtn(ActionEvent actionEvent) throws Exception {
        Login login = new Login();

        String correctUsername = login.getUsername(); // Corrected method call to getUSERNAME()
        String correctPassword = login.getPassword(); // Corrected method call to getPASSWORD()

        String enteredUsername = usernameTxtField.getText();
        String enteredPassword = passwordTxtField.getText();

        if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
            Welcome welcome = new Welcome();
            welcome.displayWelcome();
            closeCurrentWindow(actionEvent); // Close the current window after successful login
        } else {
            incorrectLabel.setText("Who are you?"); // Display error message
        }
    }

    private void closeCurrentWindow(ActionEvent actionEvent) {
        Stage currentWindow = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentWindow.close(); // Close the current window
    }
}
