package br.udesc.ceavi.willeson.controller;

import java.io.Serializable;

/**
 *
 * @author Willeson Thomas da Silva
 */
public abstract class EstadoJogador implements Serializable {

    protected Jogador jogador;

    public EstadoJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public abstract void verificaEstado(ControllerTabuleiro c);

    public abstract void verificarPeca(ControllerTabuleiro c, int posicao);

}
