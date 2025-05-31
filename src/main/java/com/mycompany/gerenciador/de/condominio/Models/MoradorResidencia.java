/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Models;

/**
 * @author fkdia
 */
public class MoradorResidencia {
    Residencia residencia;
    Pessoa morador;

    public MoradorResidencia() {}

    public MoradorResidencia(Residencia residencia, Pessoa morador) {
        this.residencia = residencia;
        this.morador = morador;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public Pessoa getMorador() {
        return morador;
    }
}
