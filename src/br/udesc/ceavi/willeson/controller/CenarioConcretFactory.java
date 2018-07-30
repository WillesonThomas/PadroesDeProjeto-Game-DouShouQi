package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Agua;
import br.udesc.ceavi.willeson.model.Armadilha;
import br.udesc.ceavi.willeson.model.Grama;
import br.udesc.ceavi.willeson.model.Toca;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class CenarioConcretFactory extends CenarioAbstractFactory {

    @Override
    public Armadilha criarArmadilha() {
        return new Armadilha();
    }

    @Override
    public Toca criarTocaCircular() {
        return new Toca();
    }

    @Override
    public Agua criarAgua() {
        return new Agua();
    }

    @Override
    public Grama criarGrama() {
        return new Grama();
    }

}
