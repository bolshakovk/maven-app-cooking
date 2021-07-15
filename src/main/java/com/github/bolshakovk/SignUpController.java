package com.github.bolshakovk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registrationSignUPbutton;

    @FXML
    private TextField signUpLoginField;

    @FXML
    private PasswordField signUpPasswordField;

    @FXML
    private TextField signUpNameField;

    @FXML
    private PasswordField signUpPasswordField_REPEAT;

    @FXML
    void initialize() {
        DbHandler dbHandler = new DbHandler();
        registrationSignUPbutton.setOnAction(event -> {
            try {
                dbHandler.SignUpUser(signUpNameField.getText(), signUpLoginField.getText(), signUpPasswordField.getText());
                System.out.println("connecting");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("some catch 1");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("some catch 2");
            }
        });
    }
}
