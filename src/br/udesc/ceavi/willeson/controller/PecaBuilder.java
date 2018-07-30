package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Cachorro;
import br.udesc.ceavi.willeson.model.Elefante;
import br.udesc.ceavi.willeson.model.Gato;
import br.udesc.ceavi.willeson.model.Leao;
import br.udesc.ceavi.willeson.model.Leopardo;
import br.udesc.ceavi.willeson.model.Lobo;
import br.udesc.ceavi.willeson.model.Rato;
import br.udesc.ceavi.willeson.model.Tigre;

/**
 *
 * @author Willeson Thomas da Silva
 */
public abstract class PecaBuilder {

    protected PecaConcretFactory peca;

    public PecaBuilder(PecaConcretFactory peca) {
        this.peca = peca;
    }

    public PecaAbstractFactory getPeca() {
        return peca;
    }

    public Leao construirLeao(String img) {
        return null;
    }

    public Tigre construirTigre(String img) {
        return null;
    }

    public Cachorro construirCachorro(String img) {
        return null;
    }

    public Gato construirGato(String img) {
        return null;
    }

    public Rato construirRato(String img) {
        return null;
    }

    public Leopardo construirLeopardo(String img) {
        return null;
    }

    public Lobo construirLobo(String img) {
        return null;
    }

    public Elefante construirElefante(String img) {
        return null;
    }
}
