/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.DAO;

import com.mycompany.gerenciador.de.condominio.Models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fkdia
 */
public class ResidenciaDAO extends DataAccesObject<Residencia> {

    public ResidenciaDAO() throws SQLException {
        super("residencias", new String[]{"id_pessoa", "rua", "numero", "cep"});
    }

    @Override
    protected Residencia mapSelection(ResultSet resultSet) throws SQLException {
        return new Residencia(
                resultSet.getInt("id"),
                resultSet.getInt("id_pessoa"),
                resultSet.getString("rua"),
                resultSet.getString("cep"),
                resultSet.getInt("numero")
        );
    }

    @Override
    protected void mapUpdate(PreparedStatement statement, Residencia entity) throws SQLException {
        statement.setInt(1, entity.getIdPessoa());
        statement.setString(2, entity.getRua());
        statement.setInt(3, entity.getNumero());
        statement.setString(4, entity.getCep());
    }
}
