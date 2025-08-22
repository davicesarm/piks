package com.system.piks.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lancamento {

    public LocalDateTime datahora;
    public double valor;
    public String tipo;

    public Lancamento(LocalDateTime datahora, double valor, String tipo) {
        this.datahora = datahora;
        this.valor = valor;
        this.tipo = tipo;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Data: " + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(datahora) + ", Tipo: " + tipo + ", Valor: " + valor;
    }
	
}
