package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;
import java.util.Map;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class CommandInvoker {

    public void execute(int proxPos, Peca pecaOri, Map<Integer, Casa> objetos) {
        Movimento mov = new Movimento(pecaOri);
        mov.executar(proxPos, objetos);
    }
}
