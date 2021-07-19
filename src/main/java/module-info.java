module maven.app.cooking {

    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;

    opens com.github.bolshakovk;
    opens com.github.bolshakovk.controllers;
    opens com.github.bolshakovk.dbHandler;
}