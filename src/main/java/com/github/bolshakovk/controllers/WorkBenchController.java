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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

public class WorkBenchController {
    @FXML
    private Button clearButton;

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

        while(resultSet.next()){
            String[] currentRow = new String[2];
            for(int i = 1;i<=2;i++){
                currentRow[i-1]=resultSet.getString(i);
            }
            allRows.add(currentRow[1]);
        } //

        listIngridients.getItems().addAll(allRows);
        listIngridients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        while(resultSetRec.next()){
            String[] currentRow = new String[2];
            for(int i = 1;i<=2;i++){
                currentRow[i-1]=resultSetRec.getString(i);
            }
            allRowsRec.add(currentRow[1]);
        }


        ObservableList<String> selectedItems =  listIngridients.getSelectionModel().getSelectedItems();
        listIngridients.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int counter = 0;
            @Override
            public void handle(MouseEvent event) {
                System.out.println("selected items: " + selectedItems);
                if (selectedItems.contains("Potato") || selectedItems.contains("Carrot") || selectedItems.contains("Onion")|| selectedItems.contains("Pork")){
                    if (listRecipes.getItems().contains("Soup")){
                        System.out.println("List recipes already contains soup");
                    }
                    else {
                        listRecipes.getItems().add("Soup");
                    }

                }

                if (selectedItems.contains("Fish") || selectedItems.contains("Garlic") || selectedItems.contains("Onion")){
                    if (listRecipes.getItems().contains("Boiled fish")){
                        System.out.println("List recipes already contains Boiled fish");
                    }
                    else {
                        listRecipes.getItems().add("Boiled fish");
                    }
                }
                if (selectedItems.contains("Potato") || selectedItems.contains("Cheese") || selectedItems.contains("Pork")|| selectedItems.contains("Mushrooms")){
                    if (listRecipes.getItems().contains("Pasta")){
                        System.out.println("List recipes already contains Pasta");
                    }
                    else {
                        listRecipes.getItems().add("Pasta");
                    }
                }

                if (selectedItems.contains("Onion") || selectedItems.contains("Garlic") || selectedItems.contains("Potato")){
                    if (listRecipes.getItems().contains("Salat")){
                        System.out.println("List recipes already contains Salat");
                    }
                    else {
                        listRecipes.getItems().add("Salat");
                    }
                }

                if (selectedItems.contains("Pork") || selectedItems.contains("Beef") || selectedItems.contains("Beet")){
                    if (listRecipes.getItems().contains("Roast meal")){
                        System.out.println("List recipes already contains Roast meal");
                    }
                    else {
                        listRecipes.getItems().add("Roast meal");
                    }
                }
            }
        });

        clearButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                listRecipes.getItems().clear();
            }
        });
    }
}
