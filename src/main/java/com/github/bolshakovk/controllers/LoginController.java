package com.github.bolshakovk.controllers;

import com.github.bolshakovk.dbHandler.DbHandler;
import com.github.bolshakovk.tables.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private ListView<String> testList;

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
            loader.setLocation(getClass().getResource("/com/github/bolshakovk/views/SignUpView.fxml"));
            try {
                loader.getLocation();
                loader.load();
                System.out.println("clicked login button");
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void LoginUser(String loginText, String loginPassword) {
        DbHandler dbHandler = new DbHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        ResultSet resultSet = dbHandler.getUser(user);
        int counter = 0;
        try {
            while (resultSet.next()){
                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(counter>=1){
            System.out.println("Пользователь найден: " + user.getLogin() + user.getPassword());
            OpenNewScene("/com/github/bolshakovk/views/WorkbenchView.fxml");
        }
        else {
            System.out.println(user.getName() + user.getPassword() + user.getLogin());
            System.out.println("Неверный логин или пароль");
        }
    }
    public void OpenNewScene(String window){
        loginSignInbutton.setOnAction(event -> {
            loginSignInbutton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
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
}
