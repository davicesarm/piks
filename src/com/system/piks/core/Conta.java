package com.system.piks.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conta {

    private final int id;
    private String chavePiks; 
    private double saldo;
    private Cliente cliente;
    private List<Lancamento> lancamentos;

    public Conta(int id, String chavePiks, double saldo) {
        this.id = id;
        this.chavePiks = chavePiks;
        this.saldo = saldo;
        this.lancamentos = new ArrayList<>();
    }

    public Conta(int id, String chavePiks) {
        this(id, chavePiks, 0.0);
    }

    public void creditar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor de credito deve ser positivo");
        this.saldo += valor;
        adicionar(new Lancamento(LocalDateTime.now(), valor, "+"));
    }

    public void debitar(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("O valor de debito deve ser positivo");
        if (valor > saldo) throw new IllegalArgumentException("Saldo insuficiente");
        this.saldo -= valor;
        adicionar(new Lancamento(LocalDateTime.now(), valor, "-"));
    }

    public void adicionar(Lancamento lancamento) {
        this.lancamentos.add(lancamento);
    }

    public void transferir(Conta destino, double valor) {
        if (destino == null) throw new IllegalArgumentException("Conta de destino nao pode ser nula");
        if (destino.equals(this)) throw new IllegalArgumentException("Transferencia para a mesma conta nao é permitida");
        if (valor <= 0) throw new IllegalArgumentException("O valor de transferencia deve ser positivo");
        if (valor > saldo) throw new IllegalArgumentException("Saldo insuficiente para transferencia");

        this.debitar(valor);
        destino.creditar(valor);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setChavePiks(String chavePiks) {
        this.chavePiks = chavePiks;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getChavePiks() {
        return chavePiks;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Conta)) return false;
        Conta other = (Conta) obj; 
        return this.id == other.id && this.chavePiks.equals(other.chavePiks);
    }
}
