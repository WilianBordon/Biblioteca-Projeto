package Usuarios;


import Modelos.*;

    public class Professor extends Usuario {
    private static final int LIMITE_LIVROS = 10;

    public Professor(String id, String nome) {
        super(id, nome, TipoUsuario.PROFESSOR);
    }

    @Override
    public boolean realizarEmprestimo(Livro livro) {
        if (getLivrosEmprestados().size() < LIMITE_LIVROS && livro.isDisponivel()) {
            getLivrosEmprestados().add(livro);
            livro.emprestar();
            return true;
        }
        return false;
    }
}
