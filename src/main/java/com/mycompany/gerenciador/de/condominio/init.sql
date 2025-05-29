/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */

/**
 * Author:  fkdia
 * Created: 28 de mai. de 2025
 */

CREATE DATABASE IF NOT EXISTS condominio;
USE condominio;

CREATE TABLE IF NOT EXISTS pessoas
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    nome       VARCHAR(150) NOT NULL,
    idade      INT          NOT NULL,
    rg         VARCHAR(12)  NOT NULL,
    cpf        VARCHAR(14)  NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS residencias
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    id_pessoa  INT,
    rua        VARCHAR(255) NOT NULL,
    numero     INT          NOT NULL,
    cep        VARCHAR(12)  NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_pessoa) references pessoas (id)
);

CREATE TABLE IF NOT EXISTS pagamentos_residencia
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    id_residencia    INT,
    valor_pagamento  DECIMAL(10, 2),
    status_pagamento ENUM ('vencido', 'pago', 'a pagar'),
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_residencia) REFERENCES residencias (id)
);

CREATE TABLE IF NOT EXISTS morador_residencia
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    id_residencia INT,
    id_morador    INT,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_residencia) REFERENCES residencias (id),
    FOREIGN KEY (id_morador) REFERENCES pessoas (id)
)