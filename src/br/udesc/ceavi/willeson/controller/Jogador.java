package br.udesc.ceavi.willeson.controller;

import java.io.Serializable;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class Jogador implements Serializable {

    private String nome;
    private String time;
    private EstadoJogador jogador;

    public Jogador(String nome, String time) {
        if (time.equalsIgnoreCase("branco")) {
            this.nome = nome;
            this.time = "imgB";
            this.jogador = new Ativo(this);
        } else if (time.equalsIgnoreCase("preto")) {
            this.nome = nome;
            this.time = "imgP";
            this.jogador = new Inativo(this);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getTime() {
        return time;
    }

    public void setJogador(EstadoJogador jogador) {
        this.jogador = jogador;
    }

    public void alterarEstado(ControllerTabuleiro c) {
        jogador.verificaEstado(c);
    }

    public void verificarEstado(ControllerTabuleiro c, int posicao) {
        jogador.verificarPeca(c, posicao);
    }

    public String mensagemVitoria() {
        String x = "";
        if (getTime().equalsIgnoreCase("imgB")) {
            x = "Branco";
        } else if (getTime().equalsIgnoreCase("imgP")) {
            x = "Preto";
        }
        return "Jogador vencedor : " + getNome() + " ( " + "Time: " + x + " ) ";
    }
}
