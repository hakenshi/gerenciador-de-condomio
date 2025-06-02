/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.DAO;

import com.mycompany.gerenciador.de.condominio.Enums.StatusPagamento;
import com.mycompany.gerenciador.de.condominio.Models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author fkdia
 */
public class PagamentoResidenciaDAO extends DataAccesObject<PagamentoResidencia> {

    public PagamentoResidenciaDAO() throws SQLException {
        super("pagamentos_residencia", new String[]{"id_residencia", "valor_pagamento", "status_pagamento"});
    }

    @Override
    protected PagamentoResidencia mapSelection(ResultSet resultSet) throws SQLException {
        Timestamp ts = resultSet.getTimestamp("created_at");
        LocalDateTime dataCriacao = (ts != null) ? ts.toLocalDateTime() : null;
        return new PagamentoResidencia(
                resultSet.getInt("id"),
                resultSet.getInt("id_residencia"),
                resultSet.getDouble("valor_pagamento"),
                StatusPagamento.valueOf(resultSet.getString("status_pagamento").toUpperCase()),
                dataCriacao
        );
    }

    @Override
    protected void mapUpdate(PreparedStatement statement, PagamentoResidencia entity) throws SQLException {
        statement.setInt(1, entity.getIdResidencia());
        statement.setDouble(2, entity.getValorPagamento());
        statement.setString(3, entity.getStatusPagamento().name().toLowerCase());
    }
}
