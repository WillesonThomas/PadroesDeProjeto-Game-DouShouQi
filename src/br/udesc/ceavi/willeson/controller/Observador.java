package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;
import java.util.ArrayList;

/**
 *
 * @author Willeson Thomas da Silva
 */
public interface Observador {

    void novoJogo(DirectorCenario c1, DirectorPeca d1, DirectorPeca d2);

    void carregarJogo(ArrayList<Casa> casa);

    void mover(int posDestino, int posOrigem, Peca peca, String imgPosOrigem);

    void fimJogo(int qtdadeBranco, int qtdadePreto, String msgVitoria, String jogador) throws Exception;

    void montrarDados(String dados);
}
