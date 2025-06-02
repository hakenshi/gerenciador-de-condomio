/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Models;

/**
 * @author fkdia
 */
public class MoradorResidencia {

    int residenciaId;
    int moradorId;

    public MoradorResidencia() {
    }

    public MoradorResidencia(int residenciaId, int moradorId) {
        this.residenciaId = residenciaId;
        this.moradorId = moradorId;
    }

    @Override
    public String toString() {
        return "MoradorResidencia{" + "residenciaId=" + residenciaId + ", moradorId=" + moradorId + '}';
    }

    public int getResidenciaId() {
        return residenciaId;
    }

    public int getMoradorId() {
        return moradorId;
    }

}
