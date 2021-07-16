package com.github.bolshakovk;

import com.github.bolshakovk.config.Const;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.PreparedStatement;
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
            dbHandler.SignUpUser(signUpNameField.getText(), signUpPasswordField.getText(), signUpLoginField.getText());
            System.out.println("Clicked registration");

            if (signUpNameField.getText().equals("") || signUpLoginField.getText().equals("") || signUpLoginField.getText().equals("")){
                System.out.println("no text in fields");
            }
            System.out.println("login: "+ signUpLoginField.getText() + "\tname: " + signUpNameField.getText() + "\tpassword: "+ signUpPasswordField.getText());
        });
    }

}
