package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Agua;
import br.udesc.ceavi.willeson.model.Armadilha;
import br.udesc.ceavi.willeson.model.Grama;
import br.udesc.ceavi.willeson.model.Toca;

/**
 *
 * @author Willeson Thomas da Silva
 */
public abstract class CenarioAbstractFactory {

    public abstract Armadilha criarArmadilha();

    public abstract Toca criarTocaCircular();

    public abstract Agua criarAgua();

    public abstract Grama criarGrama();

}
