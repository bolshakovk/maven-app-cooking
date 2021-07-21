package com.github.bolshakovk.dbHandler;

import com.github.bolshakovk.config.*;
import com.github.bolshakovk.tables.Ingridients;
import com.github.bolshakovk.tables.Recipes;
import com.github.bolshakovk.tables.User;

import java.sql.*;
//tired

public class DbHandler {
    Connection connection = null;
    public Connection getDbConnection() throws Exception {
        String connectionString = "jdbc:postgresql://" + Config.dbhost + ":" + Config.dbport + "/" + Config.dbname;
        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(connectionString, Config.dbuser, Config.dbpass);

        return connection;
    }

    public void SignUpUser(User user){
        String request = "INSERT INTO " + Const.USER_TABLE + " (" + Const.USER_NAME + ", " + Const.USER_PASSWORD + ", " + Const.USER_LOGIN + ")" +
                "VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(request);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.executeUpdate(); //UPDATE = ДОБАВИТЬ
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){
        ResultSet resultSet = null;
        String request = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(request);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery(); // QUERY = ВЗЯТЬ
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getIngridient(Ingridients ingridients){
        ResultSet resultSet = null;
        String request = "SELECT * FROM " + Const.INGRIDIENT_TABLE ;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(request);
            //preparedStatement.setString(1,ingridients.getName());
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getRecipes(Recipes recipes){
        ResultSet resultSet = null;
        //String request = "SELECT * FROM " + Const.RECIPES_TABLE;
        String request = "SELECT\n" +
                "recipes.id,\n" +
                "recipes.name\n" +
                "FROM recipes \n" +
                "LEFT JOIN ing_rec  ON recipes.id = ing_rec.rec_id\n" +
                "Where ing_rec.ing_id IN (?,?,?) ";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(request);
            preparedStatement.setInt(1, recipes.getId());
            preparedStatement.setInt(2, recipes.getId());
            preparedStatement.setInt(3, recipes.getId());
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
