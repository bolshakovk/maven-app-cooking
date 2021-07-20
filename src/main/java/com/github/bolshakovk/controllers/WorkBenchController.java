package com.github.bolshakovk.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.github.bolshakovk.App;
import com.github.bolshakovk.dbHandler.DbHandler;
import com.github.bolshakovk.tables.Ingridients;
import com.github.bolshakovk.tables.Recipes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

public class WorkBenchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> listIngridients;

    @FXML
    private ListView<String> listRecipes;

    @FXML
    void initialize() throws SQLException {
        DbHandler dbHandler = new DbHandler();
        Ingridients ingridients = new Ingridients();
        ResultSet resultSet = dbHandler.getIngridient(ingridients);

        Recipes recipes = new Recipes();
        ResultSet resultSetRec = dbHandler.getRecipes(recipes);
        List allRows = new ArrayList();

        while(resultSet.next()){
            String[] currentRow = new String[2];
            for(int i = 1;i<=2;i++){
                currentRow[i-1]=resultSet.getString(i);
            }
            allRows.add(currentRow[1]);
        }

        List allRowsRec = new ArrayList();
        while(resultSetRec.next()){
            String[] currentRow = new String[2];
            for(int i = 1;i<=2;i++){
                currentRow[i-1]=resultSet.getString(i);
            }
            allRowsRec.add(currentRow[1]);
        }

        listIngridients.getItems().addAll(allRows);
        listIngridients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        listRecipes.getItems().addAll(allRowsRec);
        listRecipes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        listIngridients.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ObservableList<String> selectedItems =  listIngridients.getSelectionModel().getSelectedItems();

                for(String s : selectedItems){
                    System.out.println(s);
                }
                ObservableList<String> selectedRecItems =  listRecipes.getSelectionModel().getSelectedItems();

                for(String s1 : selectedRecItems){
                    System.out.println(s1);
                }
            }
        });
    }
}
