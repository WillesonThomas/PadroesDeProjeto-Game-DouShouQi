package br.udesc.ceavi.willeson.controller;

import java.io.Serializable;

/**
 *
 * @author Willeson Thomas da Silva
 */
public abstract class Cenario implements Serializable {

    public abstract String getImg();

    public abstract void setImg(String img);

    public abstract int getPosicao();

    public abstract void setPosicao(int posicao);

}
