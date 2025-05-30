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
public class PessoaDAO extends DataAccesObject<Pessoa> {

    public PessoaDAO() throws SQLException {
        super("pessoas", new String[]{"nome", "idade", "rg", "cpf"});
    }

    @Override
    protected Pessoa mapSelection(ResultSet resultSet) throws SQLException {
        return new Pessoa(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getInt("idade"),
                resultSet.getString("rg"),
                resultSet.getString("cpf")
        );
    }

    @Override
    protected void mapUpdate(PreparedStatement statement, Pessoa entity) throws SQLException {
        statement.setString(1, entity.getNome());
        statement.setInt(2, entity.getIdade());
        statement.setString(3, entity.getRg());
        statement.setString(4, entity.getCpf());
    }
}
