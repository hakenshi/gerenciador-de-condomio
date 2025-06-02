/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Models;

import com.mycompany.gerenciador.de.condominio.Enums.StatusPagamento;

/**
 * @author fkdia
 */
public class PagamentoResidencia {
    int id;
    int idResidencia;
    double valorPagamento;
    StatusPagamento statusPagamento;

    public PagamentoResidencia() {
    }

    public PagamentoResidencia(int id, int idResidencia, double valorPagamento, StatusPagamento statusPagamento) {
        this.id = id;
        this.idResidencia = idResidencia;
        this.valorPagamento = valorPagamento;
        this.statusPagamento = statusPagamento;
    }

    public PagamentoResidencia(int idResidencia, double valorPagamento, StatusPagamento statusPagamento) {
        this.idResidencia = idResidencia;
        this.valorPagamento = valorPagamento;
        this.statusPagamento = statusPagamento;
    }

    public int getId() {
        return id;
    }

    public int getIdResidencia() {
        return idResidencia;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }
}
