/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciador.de.condominio;

import com.mycompany.gerenciador.de.condominio.Controllers.PessoaController;

import java.sql.SQLException;

/**
 * @author fkdia
 */
public class GerenciadorDeCondominio {
    public static void main(String[] args) {
        try{
            var controller = new PessoaController();
            controller.findAll().forEach(System.out::println);
        } catch (SQLException e){
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
