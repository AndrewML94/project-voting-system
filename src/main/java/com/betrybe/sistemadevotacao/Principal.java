package com.betrybe.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Classe principal.
   */

  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    byte opcao;
    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");

      opcao = scanner.nextByte();

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.next();

        System.out.println("Entre com o número da pessoa candidata:");

        int numero = scanner.nextInt();

        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      }

    } while (opcao == 1);

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");

      opcao = scanner.nextByte();

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scanner.next();

        System.out.println("Entre com o CPF da pessoa candidata:");

        String cpf = scanner.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      }
      
    } while (opcao == 1);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");

      opcao = scanner.nextByte();

      if (opcao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfEleitor = scanner.next();

        System.out.println("Entre com o número da pessoa candidata:");

        int numeroCandidato = scanner.nextInt();

        gerenciamentoVotacao.votar(cpfEleitor, numeroCandidato);

      } else if (opcao == 2) {
        gerenciamentoVotacao.mostrarResultado();
      }
      
    } while (opcao == 1 || opcao == 2);

    gerenciamentoVotacao.mostrarResultado();

    scanner.close();
  }
}
