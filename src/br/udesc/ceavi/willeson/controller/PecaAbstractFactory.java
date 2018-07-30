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
public abstract class PecaAbstractFactory {

    public abstract Leao criarLeao();

    public abstract Tigre criarTigre();

    public abstract Cachorro criarCachorro();

    public abstract Gato criarGatos();

    public abstract Elefante criarElefantes();

    public abstract Lobo criarLobo();

    public abstract Leopardo criarLeopardo();

    public abstract Rato criarRato();

}
