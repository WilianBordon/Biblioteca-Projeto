package Usuarios;

import Modelos.*;


import java.util.ArrayList;

public abstract class Usuario {
    private String id;
    private String nome;
    private TipoUsuario tipoUsuario;
    private ArrayList<Livro> livrosEmprestados;

    public Usuario(String id, String nome, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String getId() {return id;}

    public String getNome() {return nome;}

    public TipoUsuario getTipoUsuario() {return tipoUsuario;}

    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public abstract boolean realizarEmprestimo(Livro livro);

    public void devolverLivro(Livro livro) {
        if (livrosEmprestados.remove(livro)) {
            livro.devolver();
        }
    }
}