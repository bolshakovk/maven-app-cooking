package com.github.bolshakovk.controllers;

import com.github.bolshakovk.dbHandler.DbHandler;
import com.github.bolshakovk.tables.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
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

        registrationSignUPbutton.setOnAction(event -> {

            SignUpNewUser();


            System.out.println("Clicked registration");

            if (signUpNameField.getText().equals("") || signUpLoginField.getText().equals("") || signUpLoginField.getText().equals("")){
                System.out.println("no text in fields");
            }
            System.out.println("login: "+ signUpLoginField.getText() + "\tname: " + signUpNameField.getText() + "\tpassword: "+ signUpPasswordField.getText());
        });
    }

    private void SignUpNewUser() {
        DbHandler dbHandler = new DbHandler();
        String name = signUpNameField.getText();
        String password = signUpPasswordField.getText();
        String login = signUpLoginField.getText();

        User user = new User(name, login, password);

        dbHandler.SignUpUser(user);
    }

}
