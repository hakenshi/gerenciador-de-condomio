/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Controllers;

import com.mycompany.gerenciador.de.condominio.DAO.ResidenciaDAO;
import com.mycompany.gerenciador.de.condominio.Models.Residencia;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fkdia
 */
public class ResidenciaController {
    private final ResidenciaDAO residenciaDAO;

    public ResidenciaController() throws SQLException {
        residenciaDAO = new ResidenciaDAO();
    }

    public List<Residencia> findAll() throws SQLException {
        return residenciaDAO.findAll();
    }

    public Residencia findOne(int id) throws SQLException {
        return residenciaDAO.findOne(id);
    }

    public void create(int idPessoa, String rua, String cep, int numero) throws SQLException {
        residenciaDAO.create(new Residencia(idPessoa, rua, cep, numero));
    }

    public void update(int id, int idPessoa, String rua, String cep, int numero) throws SQLException {
        residenciaDAO.update(new Residencia(idPessoa, rua, cep, numero), id);
    }

    public void delete(int id) throws SQLException {
        residenciaDAO.delete(id);
    }
}
