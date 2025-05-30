/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.DAO;

import com.mycompany.gerenciador.de.condominio.Models.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fkdia
 */
public abstract class DataAccesObject<T> {

    private static Connection connection;

    protected String tableName;

    protected String[] fillable;

    protected abstract T mapSelection(ResultSet resultSet) throws SQLException;

    protected abstract void mapUpdate(PreparedStatement statement, T entity) throws SQLException;

    protected DataAccesObject(String tableName, String[] fillable) throws SQLException {
        connection = Database.getInstance().getConnection();
        this.tableName = tableName;
        this.fillable = fillable;
    }

    private String buildQueryString(boolean isUpdating) {
        if (isUpdating) {
            var columns = Stream.of(fillable).map(f -> f + " = ?").collect(Collectors.joining(", "));
            return String.format("UPDATE %s SET %s", tableName, columns);
        } else {
            var columnNames = String.join(", ", fillable);
            var placeholders = Stream.of(fillable).map((f) -> "?").collect(Collectors.joining(", "));
            return String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columnNames, placeholders);
        }
    }

    public List<T> findAll() throws SQLException {
        String query = "SELECT * FROM " + tableName;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        List<T> data = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        while (resultSet.next()) {
            data.add(mapSelection(resultSet));
        }
        return data;
    }

    public T findOne(int id) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            return null;
        }
        mapSelection(resultSet);
        return mapSelection(resultSet);
    }

    public void create(T entity) throws SQLException {
        String query = buildQueryString(false);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        mapUpdate(preparedStatement, entity);
        preparedStatement.executeUpdate();
    }

    public void update(T entity, int id) throws SQLException {
        String query = buildQueryString(true) + " WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        mapUpdate(preparedStatement, entity);
        preparedStatement.setInt(fillable.length + 1, id);
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
