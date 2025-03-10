package Usuarios;

import Modelos.*;

    public class Funcionario extends Usuario {
    public Funcionario(String id, String nome) {
        super(id, nome, TipoUsuario.FUNCIONARIO);
    }

    @Override
    public boolean realizarEmprestimo(Livro livro) {
        if (livro.isDisponivel()) {
            getLivrosEmprestados().add(livro);
            livro.emprestar();
            return true;
        }
        return false;
    }
}
