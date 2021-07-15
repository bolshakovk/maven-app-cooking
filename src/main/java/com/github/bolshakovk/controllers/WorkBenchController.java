package com.github.bolshakovk.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class WorkBenchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox ingridientVBox;

    @FXML
    private VBox reciptesVBox;

    @FXML
    private Button addButton;

    @FXML
    private Button delButton;

    @FXML
    private Label callorieLabel;

    @FXML
    void initialize() {
    }
}
