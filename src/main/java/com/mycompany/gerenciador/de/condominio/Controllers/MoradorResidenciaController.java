/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Controllers;

import com.mycompany.gerenciador.de.condominio.DAO.MoradorResidenciaDAO;
import com.mycompany.gerenciador.de.condominio.Models.MoradorResidencia;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fkdia
 */
public class MoradorResidenciaController {

    private final MoradorResidenciaDAO moradorResidenciaDAO;
    private final PessoaController pc;

    private final ResidenciaController rc;

    public MoradorResidenciaController() throws SQLException {
        this.moradorResidenciaDAO = new MoradorResidenciaDAO();
        pc = new PessoaController();
        rc = new ResidenciaController();
    }

    public List<MoradorResidencia> listar() throws SQLException {
        return moradorResidenciaDAO.findAll();
    }

    public MoradorResidencia findOne(int id) throws SQLException {
        return moradorResidenciaDAO.findOne(id);
    }

    public void create(String residencia, String morador) throws SQLException {

        var novoMorardor = new MoradorResidencia();

        int pessoaId = Integer.parseInt(morador.split(",")[0]);
        int residenciaId = Integer.parseInt(residencia.split(",")[0]);

        moradorResidenciaDAO.create(new MoradorResidencia(rc.findOne(residenciaId).getId(), pc.findOne(pessoaId).getId()));
    }

    public void update(MoradorResidencia moradorResidencia, int id) throws SQLException {
        moradorResidenciaDAO.update(moradorResidencia, id);
    }

    public void delete(int id) throws SQLException {
        moradorResidenciaDAO.delete(id);
    }
}
