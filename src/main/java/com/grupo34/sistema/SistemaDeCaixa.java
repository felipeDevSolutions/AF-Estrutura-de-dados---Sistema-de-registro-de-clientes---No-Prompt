package com.grupo34.sistema;

import com.grupo34.model.Cliente; // Importação da classe Cliente
import com.grupo34.model.Hash; // Importação da classe Hash

import java.util.Scanner; // Importação da classe Scanner para entrada de dados pelo usuário

public class SistemaDeCaixa { // Classe Main para testar o sistema
    public static void main(String[] args) { // Método main
        Scanner scanner = new Scanner(System.in); // Criando um objeto Scanner para entrada de dados

        System.out.println("Bem-vindo ao sistema de Registro de Clientes!");

        System.out.print("Informe o tamanho da tabela hash: ");
        int tamanhoHash = scanner.nextInt(); // Lendo o tamanho da tabela hash fornecido pelo usuário
        Hash tabelaHash = new Hash(tamanhoHash); // Criando uma tabela hash com o tamanho fornecido

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir cliente");
            System.out.println("2. Remover cliente");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Visualizar tabela hash");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt(); // Lendo a opção escolhida pelo usuário

            switch (opcao) {
                case 1:
                    // Inserir cliente
                    System.out.print("\nInforme o nome do cliente: ");
                    String nome = scanner.next();
                    System.out.print("\nInforme o CPF do cliente: ");
                    String cpf = scanner.next();
                    System.out.print("\nInforme o celular do cliente: ");
                    String celular = scanner.next();
                    System.out.print("\nInforme o email do cliente: ");
                    String email = scanner.next();

                    Cliente novoCliente = new Cliente(nome, cpf, celular, email);
                    tabelaHash.inserir(novoCliente);
                    System.out.println("Cliente inserido com sucesso!");
                    break;
                case 2:
                    // Remover cliente
                    System.out.print("\nInforme o CPF do cliente a ser removido: ");
                    String cpfRemover = scanner.next();
                    if (tabelaHash.remover(cpfRemover)) {
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado na tabela hash.");
                    }
                    break;
                case 3:
                    // Buscar cliente
                    System.out.print("\nInforme o CPF do cliente a ser buscado: ");
                    String cpfBuscar = scanner.next();
                    Cliente clienteEncontrado = tabelaHash.buscar(cpfBuscar);
                    if (clienteEncontrado != null) {
                        System.out.println("Cliente encontrado:");
                        System.out.println(clienteEncontrado);
                    } else {
                        System.out.println("Cliente não encontrado na tabela hash.");
                    }
                    break;
                case 4:
                    // Visualizar tabela hash
                    System.out.println("\nEstado atual da tabela hash:");
                    System.out.println(tabelaHash);
                    break;
                case 0:
                    // Sair do programa
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close(); // Fechando o Scanner após a utilização
    }
}
