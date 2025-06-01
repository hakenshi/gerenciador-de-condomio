/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Models;

/**
 * @author fkdia
 */
public class Residencia {
    int id;
    int idPessoa;
    String rua;
    String cep;
    int numero;

    public Residencia() {
    }

    @Override
    public String toString() {
        return "Residencia{" + "id=" + id + ", idPessoa=" + idPessoa + ", rua=" + rua + ", cep=" + cep + ", numero=" + numero + '}';
    }

    public Residencia(int id, int idPessoa, String rua, String cep, int numero) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
    }

    public Residencia(int idPessoa, String rua, String cep, int numero) {
        this.idPessoa = idPessoa;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public String getRua() {
        return rua;
    }

    public String getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }
}
