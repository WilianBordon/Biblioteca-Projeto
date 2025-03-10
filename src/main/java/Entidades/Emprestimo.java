package Entidades;

import Modelos.*;
import Usuarios.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private static final double MULTA_DIARIA = 2.00; // Valor da multa por dia de atraso

    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null; // Ainda não devolvido
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    // Metedo para calcular multa
    public double calcularMulta(LocalDate dataDevolucao) {
        long diasEmprestado = ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
        int diasPermitidos = 0; // Exemplo: o usuário pode ficar com o livro por 7 dias

        if (diasEmprestado > diasPermitidos) {
            long diasAtraso = diasEmprestado - diasPermitidos;
            return diasAtraso * MULTA_DIARIA;
        }
        return 0.0; // Sem multa
    }

    //Metodo para devolver livro e calcular multa
    public void devolverLivro(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        livro.devolver(); // Torna o livro disponível novamente

        double multa = calcularMulta(dataDevolucao);
        if (multa > 0) {
            System.out.println(" Multa por atraso: R$ " + String.format("%.2f", multa));
        } else {
            System.out.println(" Livro devolvido sem multas.");
        }
    }
}
