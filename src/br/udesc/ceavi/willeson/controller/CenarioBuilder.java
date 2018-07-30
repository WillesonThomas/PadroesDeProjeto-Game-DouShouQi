package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Agua;
import br.udesc.ceavi.willeson.model.Armadilha;
import br.udesc.ceavi.willeson.model.Grama;
import br.udesc.ceavi.willeson.model.Toca;

/**
 *
 * @author Willeson Thomas da Silva
 */
public abstract class CenarioBuilder {

    protected CenarioConcretFactory cenario;

    public CenarioBuilder(CenarioConcretFactory cenario) {
        this.cenario = cenario;
    }

    public CenarioAbstractFactory getCenario() {
        return cenario;
    }

    public Armadilha construirArmadilha(String img, int posicao) {
        return null;
    }

    public Toca construirTocaCircular(String img, int posicao) {
        return null;
    }

    public Agua construirAgua(String img, int posicao) {
        return null;
    }

    public Grama construirGrama(String img, int posicao) {
        return null;
    }

}
