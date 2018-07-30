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
public class Player1ConcretBuilder extends PecaBuilder {

    public Player1ConcretBuilder(PecaConcretFactory peca) {
        super(peca);
    }

    @Override
    public Leao construirLeao(String img) {
        Leao leao = peca.criarLeao();
        leao.setImg(img);
        leao.setPosicao(0);
        return leao;
    }

    @Override
    public Tigre construirTigre(String img) {
        Tigre tigre = peca.criarTigre();
        tigre.setImg(img);
        tigre.setPosicao(6);
        return tigre;
    }

    @Override
    public Cachorro construirCachorro(String img) {
        Cachorro cachorro = peca.criarCachorro();
        cachorro.setImg(img);
        cachorro.setPosicao(8);
        return cachorro;
    }

    @Override
    public Gato construirGato(String img) {
        Gato gato = peca.criarGatos();
        gato.setImg(img);
        gato.setPosicao(12);
        return gato;
    }

    @Override
    public Rato construirRato(String img) {
        Rato rato = peca.criarRato();
        rato.setImg(img);
        rato.setPosicao(14);
        return rato;
    }

    @Override
    public Leopardo construirLeopardo(String img) {
        Leopardo leopardo = peca.criarLeopardo();
        leopardo.setImg(img);
        leopardo.setPosicao(16);
        return leopardo;

    }

    @Override
    public Lobo construirLobo(String img) {
        Lobo lobo = peca.criarLobo();
        lobo.setImg(img);
        lobo.setPosicao(18);
        return lobo;
    }

    @Override
    public Elefante construirElefante(String img) {
        Elefante elefante = peca.criarElefantes();
        elefante.setImg(img);
        elefante.setPosicao(20);
        return elefante;
    }
}
