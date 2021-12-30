package com.landeros.databaseinteraction;

import com.landeros.entities.Shark;
import com.landeros.utility.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SharkDAOImplemented implements SharkDAO{

    @Override
    public Shark createSharkProfile(Shark shark) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "insert into shark values(default, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, shark.getFirstName());
            preparedStatement.setString(2, shark.getLastName());
            preparedStatement.setString(3, shark.getBusinessName());
            preparedStatement.setString(4, shark.getUsername());
            preparedStatement.setString(5, shark.getPassword());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            shark.setSharkId(resultSet.getInt("sharkId"));
            return shark;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Shark> getAllSharks() {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from shark";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Shark> sharks = new ArrayList<>();
            while(resultSet.next()) {
                Shark shark = new Shark(
                        resultSet.getInt("sharkId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("businessName"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
                sharks.add(shark);
            }

            return sharks;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}