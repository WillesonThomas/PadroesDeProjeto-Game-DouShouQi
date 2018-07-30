package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Agua;
import br.udesc.ceavi.willeson.model.Armadilha;
import br.udesc.ceavi.willeson.model.Grama;
import br.udesc.ceavi.willeson.model.Toca;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class CenarioConcretBuilder extends CenarioBuilder {

    public CenarioConcretBuilder(CenarioConcretFactory cenario) {
        super(cenario);
    }

    @Override
    public Armadilha construirArmadilha(String img, int posicao) {
        Armadilha quadrada = cenario.criarArmadilha();
        quadrada.setImg(img);
        quadrada.setPosicao(posicao);
        return quadrada;
    }

    @Override
    public Toca construirTocaCircular(String img, int posicao) {
        Toca circular = cenario.criarTocaCircular();
        circular.setImg(img);
        circular.setPosicao(posicao);
        return circular;
    }

    @Override
    public Agua construirAgua(String img, int posicao) {
        Agua agua = cenario.criarAgua();
        agua.setImg(img);
        agua.setPosicao(posicao);
        return agua;
    }

    @Override
    public Grama construirGrama(String img, int posicao) {
        Grama grama = cenario.criarGrama();
        grama.setImg(img);
        grama.setPosicao(posicao);
        return grama;
    }

}
