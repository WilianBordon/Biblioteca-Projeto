
package Aplicacao;

import Entidades.*;
import Modelos.*;
import Usuarios.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println(" \n======================================   ");
            System.out.println("SISTEMA DE GERENCIAMENTO DE BIBLIOTECA   ");
            System.out.println("======================================\n ");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2️ - Cadastrar Usuário");
            System.out.println("3️ - Emprestar Livro");
            System.out.println("4️ - Devolver Livro");
            System.out.println("5 - Listar Livros Disponíveis");
            System.out.println("6️ - Listar Usuários Cadastrados");
            System.out.println("7️ - Listar Todos os Livros");
            System.out.println("8 - Excluir Usuário");
            System.out.println("9️ - Excluir Livro");
            System.out.println("0️ - Sair\n");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do Scanner

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> cadastrarUsuario();
                case 3 -> emprestarLivro();
                case 4 -> devolverLivro();
                case 5 -> biblioteca.listarLivrosDisponiveis();
                case 6 -> listarUsuarios();
                case 7 -> listarTodosOsLivros();
                case 8 -> excluirUsuario();
                case 9 -> excluirLivro();
                case 0 -> System.out.println(" Encerrando o sistema...");
                default -> System.out.println(" Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarLivro() {
        System.out.print(" ID do Livro: ");
        String id = scanner.nextLine();
        if (biblioteca.verificarLivroExiste(id)) {
            System.out.println(" Erro: Já existe um livro cadastrado com esse ID!");
            return;
        }
        System.out.print(" Título: ");
        String titulo = scanner.nextLine();
        System.out.print(" Autor: ");
        String autor = scanner.nextLine();
        System.out.print(" Ano de Publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        Livro livro = new Livro(id, titulo, autor, ano);
        biblioteca.cadastrarLivro(livro);
    }

    // Excluir um livro
    private static void excluirLivro() {
        System.out.print(" ID do Livro a ser excluído: ");
        String id = scanner.nextLine();
        biblioteca.excluirLivro(id);
    }

    private static void cadastrarUsuario() {
        System.out.print(" ID do Usuário: ");
        String id = scanner.nextLine();
        if (biblioteca.verificarUsuarioExiste(id)) {
            System.out.println(" Erro: Já existe um usuário cadastrado com esse ID!");
            return;
        }
        System.out.print(" Nome: ");
        String nome = scanner.nextLine();
        System.out.print(" Tipo (1-ALUNO, 2-PROFESSOR, 3-FUNCIONARIO): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario;
        if (tipo == 1) {
            usuario = new Aluno(id, nome);
        } else if (tipo == 2) {
            usuario = new Professor(id, nome);
        } else {
            usuario = new Funcionario (id, nome);
        }

        biblioteca.cadastrarUsuario(usuario);
    }

    // Excluir um usuário
    private static void excluirUsuario() {
        System.out.print(" ID do Usuário a ser excluído: ");
        String id = scanner.nextLine();
        biblioteca.excluirUsuario(id);
    }


    private static void emprestarLivro() {
        System.out.print(" ID do Usuário: ");
        String userId = scanner.nextLine();
        System.out.print(" ID do Livro: ");
        String livroId = scanner.nextLine();
        System.out.print(" Data do Empréstimo (dd/MM/yyyy): ");
        String dataEmprestimoStr = scanner.nextLine();

        LocalDate dataEmprestimo = LocalDate.parse(dataEmprestimoStr, formatter);
        biblioteca.emprestarLivro(userId, livroId, dataEmprestimo);
    }

    private static void devolverLivro() {
        System.out.print(" ID do Usuário: ");
        String userId = scanner.nextLine();
        System.out.print(" ID do Livro: ");
        String livroId = scanner.nextLine();
        System.out.print(" Data da Devolução (dd/MM/yyyy): ");
        String dataDevolucaoStr = scanner.nextLine();

        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr, formatter);
        biblioteca.devolverLivro(userId, livroId, dataDevolucao);
    }

    private static void listarUsuarios() {
        System.out.println(" =============================");
        System.out.println(" Lista de Usuários Cadastrados");
        System.out.println(" =============================\n");
        biblioteca.listarUsuarios();
    }

    private static void listarTodosOsLivros() {
        System.out.println(" ========================");
        System.out.println(" Lista de Todos os Livros");
        System.out.println(" ========================\n");
        biblioteca.listarTodosOsLivros();
    }

}
