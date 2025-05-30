/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciador.de.condominio;

import com.mycompany.gerenciador.de.condominio.Controllers.PessoaController;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author fkdia
 */
public class GerenciadorDeCondominio {

    public static void main(String[] args) {
        try {
            PessoaController pessoaController = new PessoaController();
//            pessoaController.create("jorge", 20, "teste", "123456");
            pessoaController.findAll().forEach(item -> System.out.println(item.toString()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
