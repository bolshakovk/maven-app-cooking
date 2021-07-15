package com.github.bolshakovk;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginSignInbutton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginSignUpbutton;

    @FXML
    void initialize() {
        loginSignInbutton.setOnAction(event -> {
            String loginPassword = passwordField.getText().trim();
            String loginText = loginField.getText().trim();
            if(!loginText.equals("") && !loginPassword.equals("")){
                LoginUser(loginText, loginPassword);
            }
            else {
                System.out.println("empty values");
            }
        });

        loginSignUpbutton.setOnAction(event -> {
            loginSignUpbutton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/github/bolshakovk/SignUpView.fxml"));
            try {
                loader.getLocation();
                loader.load();
                System.out.println("clicked login button");

            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void LoginUser(String loginText, String loginPassword) {
    }
}
