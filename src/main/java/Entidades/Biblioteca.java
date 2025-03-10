package Entidades;

import Modelos.*;
import Usuarios.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;
    private Scanner scanner;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }


    // Cadastrar um novo livro
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println(" Livro cadastrado com sucesso: " + livro.getTitulo());
    }

    public void excluirLivro(String id) {
        Livro livro = buscarLivro(id);
        if (livro != null) {
            if (livro.isDisponivel()) {
                livros.remove(livro);
                System.out.println(" Livro removido com sucesso!");
            } else {
                System.out.println(" O livro está emprestado e não pode ser removido!");
            }
        } else {
            System.out.println(" Livro não encontrado.");
        }
    }

    public boolean verificarLivroExiste(String id) {
        return buscarLivro(id) != null;
    }



    // Cadastrar um novo usuário
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println(" Usuário cadastrado com sucesso: " + usuario.getNome());
    }

    // Verifica se um usuário possui empréstimos ativos
    private boolean possuiEmprestimosAtivos(Usuario usuario) {
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }


    // Remover um usuário pelo ID
    public void excluirUsuario(String id) {
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            if (possuiEmprestimosAtivos(usuario)) {
                System.out.println(" O usuário possui empréstimos ativos e não pode ser removido!");
            } else {
                usuarios.remove(usuario);
                System.out.println(" Usuário removido com sucesso!");
            }
        } else {
            System.out.println(" Usuário não encontrado.");
        }
    }

    public boolean verificarUsuarioExiste(String id) {
        return buscarUsuario(id) != null;
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println(" Nenhum usuário cadastrado.");
            return;
        }

        for (Usuario u : usuarios) {
            String tipo = (u instanceof Aluno) ? "Aluno" :
                    (u instanceof Professor) ? "Professor" :
                            "Funcionário";
            System.out.println(" ID: " + u.getId() + " | Nome: " + u.getNome() + " | Tipo: " + tipo);
        }
    }

    public void listarTodosOsLivros() {
        if (livros.isEmpty()) {
            System.out.println(" Nenhum livro cadastrado.");
            return;
        }

        for (Livro l : livros) {
            System.out.println(" ID: " + l.getId() + " |  Título: " + l.getTitulo() +
                    " |  Autor: " + l.getAutor() + " |  Ano: " + l.getAnoPublicacao());
        }
    }

    // Listar todos os livros disponíveis
    public void listarLivrosDisponiveis() {
        System.out.println("\n Livros Disponíveis:");
        boolean temLivrosDisponiveis = false;

        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println("- " + livro.getTitulo() + " | Autor: " + livro.getAutor());
                temLivrosDisponiveis = true;
            }
        }

        if (!temLivrosDisponiveis) {
            System.out.println(" Nenhum livro disponível no momento.");
        }
    }

    public void emprestarLivro(String userId, String livroId, LocalDate dataEmprestimo) {
        Usuario usuario = buscarUsuario(userId);
        Livro livro = buscarLivro(livroId);

        if (usuario != null && livro != null && livro.isDisponivel()) {
            boolean sucesso = usuario.realizarEmprestimo(livro);
            if (sucesso) {
                emprestimos.add(new Emprestimo(livro, usuario, dataEmprestimo));  //  Agora passa a data
                System.out.println(" Livro emprestado para " + usuario.getNome() + " em " + dataEmprestimo);
            } else {
                System.out.println(" Empréstimo não realizado!");
            }
        } else {
            System.out.println(" Usuário ou livro não encontrado, ou livro indisponível.");
        }
    }

    public void devolverLivro(String userId, String livroId, LocalDate dataDevolucao) {
        Usuario usuario = buscarUsuario(userId);
        Livro livro = buscarLivro(livroId);

        if (usuario != null && livro != null) {
            Emprestimo emprestimoEncontrado = null;

            for (Emprestimo e : emprestimos) {
                if (e.getUsuario().equals(usuario) && e.getLivro().equals(livro)) {
                    emprestimoEncontrado = e;
                    break;
                }
            }

            if (emprestimoEncontrado != null) {
                double multa = emprestimoEncontrado.calcularMulta(dataDevolucao); // Calcula a multa antes de remover

                emprestimoEncontrado.devolverLivro(dataDevolucao); // Exibe a multa no console
                emprestimos.remove(emprestimoEncontrado); // Remove da lista

                System.out.println(" Devolução concluída.");
                if (multa > 0) {
                    System.out.println(" Multa a pagar: R$ " + String.format("%.2f", multa));
                }
            } else {
                System.out.println(" Empréstimo não encontrado.");
            }
        } else {
            System.out.println(" Usuário ou livro não encontrado.");
        }
    }


    // Métodos auxiliares para buscar usuário, livro e empréstimo
    private Usuario buscarUsuario(String id) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) return u;
        }
        return null;
    }

    private Livro buscarLivro(String id) {
        for (Livro l : livros) {
            if (l.getId().equals(id)) return l;
        }
        return null;
    }

    private Emprestimo buscarEmprestimo(Usuario usuario, Livro livro) {
        for (Emprestimo e : emprestimos) {
                if (e.getUsuario().equals(usuario) && e.getLivro().equals(livro)) {
                return e;
            }
        }
        return null;
    }
}
