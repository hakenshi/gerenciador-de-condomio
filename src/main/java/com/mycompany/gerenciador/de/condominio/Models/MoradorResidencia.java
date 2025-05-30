/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Models;

/**
 * @author fkdia
 */
public class MoradorResidencia {
    Pessoa proprietario;
    Residencia residencia;
    Pessoa morador;

    public MoradorResidencia() {}

    public MoradorResidencia(Pessoa proprietario, Residencia residencia, Pessoa morador) {
        this.proprietario = proprietario;
        this.residencia = residencia;
        this.morador = morador;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public Pessoa getMorador() {
        return morador;
    }
}
