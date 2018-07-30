package br.udesc.ceavi.willeson.model;

import br.udesc.ceavi.willeson.controller.Cenario;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class Armadilha extends Cenario {

    private String img;
    private int posicao;

    public Armadilha() {
    }

    public Armadilha(String img, int posicao) {
        this.img = img;
        this.posicao = posicao;
    }

    @Override
    public String getImg() {
        return img;
    }

    @Override
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int getPosicao() {
        return posicao;
    }

    @Override
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
