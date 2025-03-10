package Modelos;

public class Livro {
    private String id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;

    public Livro(String id, String titulo, String autor, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public boolean isDisponivel() { return disponivel; }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro foi emprestado com sucesso!");
        } else {
            System.out.println("Livro indisponível!");
        }
    }

    public void devolver() {
        disponivel = true;
        System.out.println("O livro foi devolvido com sucesso!");
    }
}

