/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Controllers;

import com.mycompany.gerenciador.de.condominio.DAO.PessoaDAO;
import com.mycompany.gerenciador.de.condominio.Models.Pessoa;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fkdia
 */
public class PessoaController {
    private final PessoaDAO pessoaDAO;

    public PessoaController() throws SQLException {
        pessoaDAO = new PessoaDAO();
    }

    public List<Pessoa> findAll() throws SQLException {
        return pessoaDAO.findAll();
    }

    public Pessoa findOne(int id) throws SQLException {
        return pessoaDAO.findOne(id);
    }
    
    public Pessoa findOne(String nome) throws SQLException {
        return pessoaDAO.findOne(nome, "nome");
    }

    public boolean create(String nome, int idade, String cpf, String rg) throws SQLException {
        return this.pessoaDAO.create(new Pessoa(nome, idade, cpf, rg));
    }

    public void update(int id, String nome, int idade, String cpf, String rg) throws SQLException {
        this.pessoaDAO.update(new Pessoa(nome, idade, cpf, rg), id);
    }
}
