package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
  * Método construtor.
  */

  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  /**
  * Método responsável pelo cadastro de candidatos.
  */

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    this.pessoasCandidatas.add(new PessoaCandidata(nome, numero));
  }

  /**
  * Método responsável pelo cadastro de eleitores.
  */

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora eleitor : pessoasEleitoras) {
      if (eleitor.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    this.pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
  }

  /**
  * Método responsável pela lógica de voto.
  */

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }
    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numeroPessoaCandidata) {
        candidato.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
      }
    }
  }

  /**
  * Método responsável pela apresentação do resultado.
  */

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.size() == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }
    int total = cpfsComputados.size();

    for (PessoaCandidata candidato: pessoasCandidatas) {
      int votosDoCandidato = candidato.getVotos();
      double porcentagemDeVotos = (double) votosDoCandidato / total * 100;

      System.out.println("Nome: "
          + candidato.getNome() + " - " 
          + votosDoCandidato + " votos" 
          + " ( " + Math.round((porcentagemDeVotos))
      );
    }

    System.out.println("Total de votos: " + total);
  }
}
