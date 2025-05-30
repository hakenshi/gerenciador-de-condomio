/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Models;

/**
 * @author fkdia
 */

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private String rg;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, String cpf, String rg) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Pessoa(int id, String nome, int idade, String cpf, String rg) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                '}';
    }
}
