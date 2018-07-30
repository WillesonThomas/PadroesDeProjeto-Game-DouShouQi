package br.udesc.ceavi.willeson.controller;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class Inativo extends EstadoJogador {

    public Inativo(Jogador jogador) {
        super(jogador);
    }

    @Override
    public void verificaEstado(ControllerTabuleiro c) {
        this.jogador.setJogador(new Ativo(jogador));
        c.setJogadorAtual(jogador);
    }

    @Override
    public void verificarPeca(ControllerTabuleiro c, int posicao) {
    }
}
