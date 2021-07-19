package com.github.bolshakovk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.github.bolshakovk.config.*;
import java.io.ObjectInputFilter;
import java.sql.*;



public class App extends Application {
    String url = "jdbc:postgresql://" + Config.dbhost + ":" + Config.dbport + "/" +Config.dbname;
    String user = "postgres";
    String password  = "1488";
    Connection connection = null;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/LoginFormView.fxml"));
        primaryStage.setTitle("123");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            System.out.println("Connected");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection !=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
