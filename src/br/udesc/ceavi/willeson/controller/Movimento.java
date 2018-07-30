package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;
import java.util.Map;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class Movimento implements Command {

    private Peca peca;

    public Movimento(Peca peca) {
        this.peca = peca;
    }

    @Override
    public void executar(int proxPos, Map<Integer, Casa> objetos) {
        peca.movimentar(proxPos, objetos);
    }
}
