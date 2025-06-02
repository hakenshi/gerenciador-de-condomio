/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Controllers;

import com.mycompany.gerenciador.de.condominio.DAO.PagamentoResidenciaDAO;
import com.mycompany.gerenciador.de.condominio.Enums.StatusPagamento;
import com.mycompany.gerenciador.de.condominio.Models.PagamentoResidencia;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fkdia
 */
public class PagamentoResidenciaController {
    private final PagamentoResidenciaDAO pagamentoResidenciaDAO;

    public PagamentoResidenciaController() throws SQLException {
        this.pagamentoResidenciaDAO = new PagamentoResidenciaDAO();
    }

    public List<PagamentoResidencia> fidnAll() throws SQLException {
        return pagamentoResidenciaDAO.findAll();
    }
    
    public List<PagamentoResidencia> fidnAll(int id) throws SQLException {
        return pagamentoResidenciaDAO.findAll(id);
    }

    public PagamentoResidencia findOne(int id) throws SQLException {
        return pagamentoResidenciaDAO.findOne(id);
    }

    public void create(int idResidencia, double valorPagamento, StatusPagamento statusPagamento) throws SQLException {
        PagamentoResidencia pagamentoResidencia = new PagamentoResidencia(idResidencia, valorPagamento, statusPagamento);
        pagamentoResidenciaDAO.create(pagamentoResidencia);
    }

    public void update(int id, int idResidencia, double valorPagamento, StatusPagamento statusPagamento) throws SQLException {
        PagamentoResidencia pagamentoResidencia = new PagamentoResidencia(idResidencia, valorPagamento, statusPagamento);
        pagamentoResidenciaDAO.update(pagamentoResidencia, id);
    }

    public void delete(int id) throws SQLException {
        pagamentoResidenciaDAO.delete(id);
    }
}
