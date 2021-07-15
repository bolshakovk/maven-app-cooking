package com.github.bolshakovk;

import com.github.bolshakovk.config.Config;
import com.github.bolshakovk.config.Const;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DbHandler {
    Connection connection;
    public  Connection getConnection() throws Exception {
        String connectionString = "jdbc:postgresql//:" + Config.dbhost + ":" + Config.dbport + "/" + Config.dbname;
        Class.forName("com.postgresql.Driver");
        connection = DriverManager.getConnection(connectionString, Config.dbuser, Config.dbpass);

        return connection;
    }
    public void SignUpUser(String name,String login, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + " (" + Const.USER_NAME + "," + Const.USER_LOGIN + "," + Const.USER_PASSWORD + ")"
                + "VALUES(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(insert);
            System.out.println("connected");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("not connected");
        }

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, login);
        preparedStatement.setString(3, password);

        preparedStatement.executeUpdate();

    }
}
