/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Controllers;

import com.mycompany.gerenciador.de.condominio.DAO.PessoaDAO;
import com.mycompany.gerenciador.de.condominio.Models.Pessoa;

import java.sql.SQLException;

/**
 * @author fkdia
 */
public class PessoaController {
    private final PessoaDAO pessoaDAO;

    public PessoaController() throws SQLException {
        this.pessoaDAO = new PessoaDAO();
    }

    public Pessoa create(String nome, int idade, String cpf, String rg ) {
        return pessoaDAO.create(new Pessoa(nome, idade, cpf, rg));
    }

}
