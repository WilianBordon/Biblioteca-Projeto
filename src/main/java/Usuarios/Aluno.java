package Usuarios;

import Modelos.*;

public class Aluno extends Usuario {
    private static final int LIMITE_LIVROS = 3;

    public Aluno(String id, String nome) {
        super(id, nome, TipoUsuario.ALUNO);
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