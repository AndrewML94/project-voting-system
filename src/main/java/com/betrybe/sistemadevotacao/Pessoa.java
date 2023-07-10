package com.betrybe.sistemadevotacao;

public abstract class Pessoa {
  protected String nome;

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
