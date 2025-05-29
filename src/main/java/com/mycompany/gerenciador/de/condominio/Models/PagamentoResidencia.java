/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Models;

import com.mycompany.gerenciador.de.condominio.Enums.StatusPagamento;

/**
 *
 * @author fkdia
 */
public record PagamentoResidencia (int id, int id_residencia, double valor_pagamento,StatusPagamento status) {
    
}
