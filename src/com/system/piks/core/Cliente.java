package com.system.piks.core;

public class Cliente {

    private int cpf;
    private String nome;
    private Conta conta;

    public Cliente(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

}
