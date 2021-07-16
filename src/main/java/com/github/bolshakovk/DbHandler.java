package com.github.bolshakovk;

import com.github.bolshakovk.config.Config;
import com.github.bolshakovk.config.Const;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//tired

public class DbHandler {
    Connection connection = null;
    public Connection getDbConnection() throws Exception {
        String connectionString = "jdbc:postgresql://" + Config.dbhost + ":" + Config.dbport + "/" + Config.dbname;
        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(connectionString, Config.dbuser, Config.dbpass);

        return connection;
    }

    public void SignUpUser(String name, String password, String login){
        String request = "INSERT INTO " + Const.USER_TABLE + " (" + Const.USER_NAME + ", " + Const.USER_PASSWORD + ", " + Const.USER_LOGIN + ")" +
                "VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(request);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, login);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
