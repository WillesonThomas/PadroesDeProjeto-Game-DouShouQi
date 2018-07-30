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
public class PecaConcretFactory extends PecaAbstractFactory {

    @Override
    public Leao criarLeao() {
        Leao leao = new Leao();
        leao.setValor(7);
        return leao;
    }

    @Override
    public Tigre criarTigre() {
        Tigre tigre = new Tigre();
        tigre.setValor(6);
        return tigre;
    }

    @Override
    public Cachorro criarCachorro() {
        Cachorro cachorro = new Cachorro();
        cachorro.setValor(3);
        return cachorro;
    }

    @Override
    public Gato criarGatos() {
        Gato gato = new Gato();
        gato.setValor(2);
        return gato;
    }

    @Override
    public Elefante criarElefantes() {
        Elefante elefante = new Elefante();
        elefante.setValor(8);
        return elefante;
    }

    @Override
    public Lobo criarLobo() {
        Lobo lobo = new Lobo();
        lobo.setValor(4);
        return lobo;
    }

    @Override
    public Leopardo criarLeopardo() {
        Leopardo leopardo = new Leopardo();
        leopardo.setValor(5);
        return leopardo;
    }

    @Override
    public Rato criarRato() {
        Rato rato = new Rato();
        rato.setValor(1);
        return rato;
    }
}
