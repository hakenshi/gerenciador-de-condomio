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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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
        return mapSelection(resultSet);
    }

    public T findOne(String value, String columnName) throws SQLException {

        if (Arrays.stream(fillable).noneMatch(f -> f.equals(columnName))) {
            throw new IllegalArgumentException("No fillable columns defined for this DAO.");
        }
        {

        }

        String query = "SELECT * FROM " + tableName + " WHERE " + columnName + " = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, value);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            return null;
        }
        return mapSelection(resultSet);
    }

    public boolean create(T entity) throws SQLException {
        String query = buildQueryString(false);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        mapUpdate(preparedStatement, entity);
        var affectedRows = preparedStatement.executeUpdate();
        return affectedRows > 0;
    }

    public T createAndReturn(T entity) throws SQLException {
        String query = buildQueryString(false);
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        mapUpdate(preparedStatement, entity);
        var affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating new resource failed, no rows affcted");
        }

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int id = generatedKeys.getInt(1); // supondo que o ID seja um long
            return findOne(id); // método que você precisa ter para buscar o T pelo ID
        } else {
            throw new SQLException("Creating entity failed, no ID obtained.");
        }
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
