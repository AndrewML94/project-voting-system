package com.betrybe.sistemadevotacao;

public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
  * Método construtor.
  */
  
  public PessoaCandidata(String nome, int numero) {
    super.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  @Override
  public String getNome() {
    return super.nome;
  }

  @Override
  public void setNome(String nome) {
    super.nome = nome;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return this.votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
