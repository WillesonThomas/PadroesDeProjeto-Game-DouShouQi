package br.udesc.ceavi.willeson.controller;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class Ativo extends EstadoJogador {

    public Ativo(Jogador jogador) {
        super(jogador);
    }

    @Override
    public void verificaEstado(ControllerTabuleiro c) {
        this.jogador.setJogador(new Inativo(jogador));
    }

    @Override
    public void verificarPeca(ControllerTabuleiro c, int posicao) {
        if (jogador.getTime().equalsIgnoreCase(c.getPeca().getImg().substring(0, 4))) {
            c.setPosAnimal(posicao);
            c.setVerifica(true);
        }
    }
}
