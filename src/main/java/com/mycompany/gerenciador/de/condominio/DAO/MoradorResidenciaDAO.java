/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.DAO;

import com.mycompany.gerenciador.de.condominio.Controllers.PessoaController;
import com.mycompany.gerenciador.de.condominio.Controllers.ResidenciaController;
import com.mycompany.gerenciador.de.condominio.Models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fkdia
 */
public class MoradorResidenciaDAO extends DataAccesObject<MoradorResidencia> {

    public MoradorResidenciaDAO() throws SQLException {
        super("moradores_residencias", new String[]{"id_residencia", "id_morador"});
    }

    @Override
    protected MoradorResidencia mapSelection(ResultSet resultSet) throws SQLException {
        PessoaController pessoaController = new PessoaController();

        ResidenciaController residenciaController = new ResidenciaController();
        int morador = resultSet.getInt("id_morador");
        int residencia = resultSet.getInt("id_residencia");

        return new MoradorResidencia(
                residencia,
                morador
        );
    }

    @Override
    protected void mapUpdate(PreparedStatement statement, MoradorResidencia entity) throws SQLException {
        statement.setInt(1, entity.getResidenciaId());
        statement.setInt(2, entity.getMoradorId());
    }
}
