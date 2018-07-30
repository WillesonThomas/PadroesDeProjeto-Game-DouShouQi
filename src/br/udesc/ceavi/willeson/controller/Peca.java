package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;
import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Willeson Thomas da Silva
 */
public abstract class Peca implements Serializable {

    public abstract String getImgPosAnt();

    public abstract String getImg();

    public abstract void setImg(String img);

    public abstract void setImgPosAnt(String ImgPosAnt);

    public abstract int getPosicao();

    public abstract void setPosicao(int posicao);

    public abstract void setVerificaMovimento(boolean verificaMovimento);

    public abstract boolean isVerificaMovimento();

    public abstract boolean isVerificaFimJogo();

    public abstract void setVerificaFimJogo(boolean verificaFimJogo);

    public abstract int getValor();

    public abstract void setValor(int valor);

    public abstract void movimentar(int novaPos, Map<Integer, Casa> objetos);

}
