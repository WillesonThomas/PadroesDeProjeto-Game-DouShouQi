package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;
import java.util.Map;

/**
 *
 * @author Willeson Thomas da Silva
 */
public interface Command {

    public void executar(int novaPos, Map<Integer, Casa> objetos);
}
