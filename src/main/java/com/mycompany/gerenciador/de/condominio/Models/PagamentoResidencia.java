/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Models;

import com.mycompany.gerenciador.de.condominio.Enums.StatusPagamento;
import java.time.LocalDateTime;

/**
 * @author fkdia
 */
public class PagamentoResidencia {
    int id;
    int idResidencia;
    double valorPagamento;
    StatusPagamento statusPagamento;
    LocalDateTime data;
    
    public PagamentoResidencia() {
    }

    public PagamentoResidencia(int id, int idResidencia, double valorPagamento, StatusPagamento statusPagamento, LocalDateTime dataCriacao) {
        this.id = id;
        this.idResidencia = idResidencia;
        this.valorPagamento = valorPagamento;
        this.statusPagamento = statusPagamento;
        this.data = dataCriacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PagamentoResidencia{" + "id=" + id + ", idResidencia=" + idResidencia + ", valorPagamento=" + valorPagamento + ", statusPagamento=" + statusPagamento + ", data=" + data + '}';
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
