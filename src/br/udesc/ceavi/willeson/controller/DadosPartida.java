package br.udesc.ceavi.willeson.controller;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class DadosPartida extends Dados {

    private String jogador;
    private int pontos;

    public DadosPartida(String jogador, int pontos) {
        this.jogador = jogador;
        this.pontos = pontos;
    }

    @Override
    public String getJogador() {
        return jogador;
    }

    @Override
    public int getPontos() {
        return pontos;
    }

    @Override
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public int compareTo(Dados o) {
        if (this.pontos > o.getPontos()) {
            return -1;
        }
        if (this.pontos < o.getPontos()) {
            return 1;
        }
        return 0;
    }

}
