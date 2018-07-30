package br.udesc.ceavi.willeson.controller;

import java.io.Serializable;

/**
 *
 * @author Willeson Thomas da Silva
 */
public abstract class Dados implements Serializable, Comparable<Dados> {

    private String jogador;
    private int pontos;

    public void addDados(Dados dado) throws Exception {
        throw new Exception("Adicionar Dados");
    }

    public void ler() throws Exception {
        throw new Exception("Ler Dados");
    }

    public void gravar() throws Exception {
        throw new Exception("Gravar Dados");
    }

    public void gerarRanking() throws Exception {
        throw new Exception("Gravar Dados em aquivo");
    }

    public String getJogador() {
        return jogador;
    }

    public int getPontos() {
        return pontos;
    }

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
