package br.udesc.ceavi.willeson.model;

import br.udesc.ceavi.willeson.controller.Peca;
import java.util.Map;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class Elefante extends Peca {

    private String img;
    private int posicao;
    private int valor;
    private boolean verificaMovimento = false;
    private boolean verificaFimJogo = false;
    private String ImgPosAnt;

    public Elefante() {
    }

    public Elefante(String img, int posicao, int valor) {
        this.img = img;
        this.posicao = posicao;
        this.valor = valor;
    }

    @Override
    public boolean isVerificaMovimento() {
        return verificaMovimento;
    }

    @Override
    public void setVerificaMovimento(boolean verificaMovimento) {
        this.verificaMovimento = verificaMovimento;
    }

    @Override
    public boolean isVerificaFimJogo() {
        return verificaFimJogo;
    }

    @Override
    public void setVerificaFimJogo(boolean verificaFimJogo) {
        this.verificaFimJogo = verificaFimJogo;
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

    @Override
    public int getValor() {
        return valor;
    }

    @Override
    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String getImgPosAnt() {
        return ImgPosAnt;
    }

    @Override
    public void setImgPosAnt(String ImgPosAnt) {
        this.ImgPosAnt = ImgPosAnt;
    }

    @Override
    public void movimentar(int novaPos, Map<Integer, Casa> objetos) {
        if ((novaPos == getPosicao() + 1) || (novaPos == getPosicao() - 1)
                || (novaPos == getPosicao() + 7) || (novaPos == getPosicao() - 7)) {
            String getThis = getImg().substring(0, 4);
            setImgPosAnt("imgC\\01grama.png");
            if (!(objetos.get(novaPos).verificaImgCasa().equalsIgnoreCase("imgC\\01grama.png"))) {
                String imgCasa = objetos.get(novaPos).verificaImgCasa();
                verificaEntradaArmadilha(getThis, imgCasa, novaPos);
                verificaEntrarToca(getThis, imgCasa);
                int valorAnimalCasa = objetos.get(novaPos).valorAnimalCasa();
                if (valorAnimalCasa > -1) {
                    atacar(getThis, imgCasa, valorAnimalCasa);
                }
            } else {
                verificaSairArmadilha(getThis);
                if (isVerificaMovimento() == false) {
                    setVerificaMovimento(true);
                }
            }

        }
    }

    private void verificaSairArmadilha(String getThis) {
        if (getImg().equalsIgnoreCase(getThis + "\\TQ07elefante.png")) {
            setImg(getThis + "\\07elefante.png");
            setImgPosAnt("imgC\\02tocaQuadrada.png");
            setVerificaMovimento(true);
            setValor(8);
        }
    }

    private void verificaEntradaArmadilha(String getThis, String imgCasa, int pos) {
        if ((imgCasa.equalsIgnoreCase(imgCasa.substring(0, 4) + "\\02tocaQuadrada.png"))) {
            if ((pos == 2 || pos == 4 || pos == 10) && (getThis.equalsIgnoreCase("imgP"))) {
                setValor(0);
            } else if ((pos == 52 || pos == 58 || pos == 60) && (getThis.equalsIgnoreCase("imgB"))) {
                setValor(0);
            }
            setImg(getThis + "\\TQ07elefante.png");
            setImgPosAnt("imgC\\01grama.png");
            setVerificaMovimento(true);
        }
    }

    private void verificaEntrarToca(String getThis, String imgCasa) {
        String verificaProx = imgCasa.substring(0, 4);
        if (!(verificaProx.equalsIgnoreCase(getThis))) {
            if ((imgCasa.equalsIgnoreCase(verificaProx + "\\04tocaCircular.png"))) {
                if (getImg().equalsIgnoreCase(getThis + "\\TQ07elefante.png")) {
                    setImg(getThis + "\\TC07elefante.png");
                    setImgPosAnt("imgC\\02tocaQuadrada.png");
                    setVerificaMovimento(true);
                    setVerificaFimJogo(true);
                }
            }
        }

    }

    private void atacar(String getThis, String imgCasa, int valorAnimalCasa) {
        String verificaProx = imgCasa.substring(5, 7);
        if (!(getThis.equalsIgnoreCase(imgCasa.substring(0, 4)))) {
            if (!(imgCasa.equalsIgnoreCase(imgCasa.substring(0, 4) + "\\10rato.png"))) {
                if (getValor() >= valorAnimalCasa && valorAnimalCasa != 0) {
                    if (!((imgCasa.equalsIgnoreCase(imgCasa.substring(0, 4) + "\\TQ10rato.png"))
                            || (imgCasa.equalsIgnoreCase(imgCasa.substring(0, 4) + "\\12aguaRato.png")))) {
                        modoAtaqueA(getThis, verificaProx);
                    }
                } else if (valorAnimalCasa == 0) {
                    setImg(getThis + "\\TQ07elefante.png");
                    setImgPosAnt("imgC\\01grama.png");
                    setVerificaMovimento(true);
                }
            }
        }
    }

    private void modoAtaqueA(String getThis, String verificaProx) {
        if (!(getImg().equalsIgnoreCase(getThis + "\\TQ07elefante.png"))) {
            setImgPosAnt("imgC\\01grama.png");
            if (verificaProx.equalsIgnoreCase("TQ")) {
                setImg(getThis + "\\TQ07elefante.png");
                setValor(0);
            }
            setVerificaMovimento(true);
        } else {
            setImgPosAnt("imgC\\02tocaQuadrada.png");
            setImg(getThis + "\\07elefante.png");
            setValor(8);
            setVerificaMovimento(true);
        }
    }

}
