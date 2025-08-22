package com.system.piks.core;

import java.time.LocalDateTime;

public class ContaEspecial extends Conta {

    private double limite;

    public ContaEspecial(int id, String chavePiks, double saldo, double limite) {
        super(id, chavePiks, saldo);
        this.limite = limite;
    }

    public ContaEspecial(int id, String chavePiks, double limite) {
        this(id, chavePiks, 0.0, limite);
    }

    @Override
    public void debitar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("O valor de debito deve ser positivo");
        
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            adicionar(new Lancamento(LocalDateTime.now(), valor, "-"));
            return;
        }

        double diferenca = getSaldo() - valor;

        if (diferenca < -limite) 
            throw new IllegalArgumentException("Saldo insuficiente. Saldo: " + getSaldo() + ", Limite: " + limite + ", Valor: " + valor + ", Diferenca: " + diferenca);

        setSaldo(getSaldo() - valor);
        adicionar(new Lancamento(LocalDateTime.now(), valor, "-"));
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }


}
