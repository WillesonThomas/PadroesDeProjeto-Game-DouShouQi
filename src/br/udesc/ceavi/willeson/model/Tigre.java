package br.udesc.ceavi.willeson.model;

import br.udesc.ceavi.willeson.controller.Peca;
import java.util.Map;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class Tigre extends Peca {

    private String img;
    private int posicao;
    private int valor;
    private boolean verificaMovimento = false;
    private boolean verificaFimJogo = false;
    private String ImgPosAnt;

    public Tigre() {
    }

    public Tigre(String img, int posicao, int valor) {
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
                || (novaPos == getPosicao() + 7) || (novaPos == getPosicao() - 7)
                || (novaPos == getPosicao() + 28) || (novaPos == getPosicao() - 28)
                || (novaPos == getPosicao() + 3) || (novaPos == getPosicao() - 3)) {
            String getThis = getImg().substring(0, 4);
            setImgPosAnt("imgC\\01grama.png");
            if (!(objetos.get(novaPos).verificaImgCasa().equalsIgnoreCase("imgC\\01grama.png"))) {
                String imgCasa = objetos.get(novaPos).verificaImgCasa();
                verificaEntradaArmadilha(getThis, imgCasa, novaPos);
                verificaEntrarToca(getThis, imgCasa);
                int valorAnimalCasa = objetos.get(novaPos).valorAnimalCasa();
                if (valorAnimalCasa > -1) {
                    atacar(getThis, imgCasa, valorAnimalCasa, novaPos, objetos);
                }
            } else {
                if ((novaPos == getPosicao() + 28) || (novaPos == getPosicao() - 28)
                        || (novaPos == getPosicao() + 3) || (novaPos == getPosicao() - 3)) {
                    boolean entrarAgua = verificarSalto(novaPos, objetos);
                    if (entrarAgua == false) {
                        setVerificaMovimento(true);
                    }

                } else {
                    verificaSairArmadilha(getThis);
                    if (isVerificaMovimento() == false) {
                        setVerificaMovimento(true);
                    }
                }
            }

        }
    }

    private void verificaSairArmadilha(String getThis) {
        if (getImg().equalsIgnoreCase(getThis + "\\TQ03tigre.png")) {
            setImg(getThis + "\\03tigre.png");
            setImgPosAnt("imgC\\02tocaQuadrada.png");
            setVerificaMovimento(true);
            setValor(6);
        }
    }

    private void verificaEntradaArmadilha(String getThis, String imgCasa, int pos) {
        if ((imgCasa.equalsIgnoreCase(imgCasa.substring(0, 4) + "\\02tocaQuadrada.png"))) {
            if ((pos == 2 || pos == 4 || pos == 10) && (getThis.equalsIgnoreCase("imgP"))) {
                setValor(0);
            } else if ((pos == 52 || pos == 58 || pos == 60) && (getThis.equalsIgnoreCase("imgB"))) {
                setValor(0);
            }
            setImg(getThis + "\\TQ03tigre.png");
            setImgPosAnt("imgC\\01grama.png");
            setVerificaMovimento(true);
        }
    }

    private void verificaEntrarToca(String getThis, String imgCasa) {
        String verificaProx = imgCasa.substring(0, 4);
        if (!(verificaProx.equalsIgnoreCase(getThis))) {
            if ((imgCasa.equalsIgnoreCase(verificaProx + "\\04tocaCircular.png"))) {
                if (getImg().equalsIgnoreCase(getThis + "\\TQ03tigre.png")) {
                    setImg(getThis + "\\TC03tigre.png");
                    setImgPosAnt("imgC\\02tocaQuadrada.png");
                    setVerificaMovimento(true);
                    setVerificaFimJogo(true);
                }
            }
        }

    }

    public boolean verificarSalto(int novaPos, Map<Integer, Casa> objetos) {
        boolean v = false;
        int identifica = 0;
        if (novaPos > getPosicao()) {
            if (novaPos == (getPosicao() + 3)) {
                identifica = 1;
            } else if (novaPos == (getPosicao() + 28)) {
                identifica = 7;
            }
        } else {
            if (novaPos == (getPosicao() - 3)) {
                identifica = -1;
            } else if (novaPos == (getPosicao() - 28)) {
                identifica = -7;
            }

        }
        boolean vi = verificaRato(getPosicao(), novaPos, identifica, objetos);
        if (vi == true) {
            v = true;
        }
        return v;
    }

    private boolean verificaRato(int getPosicao, int getProx, int identifica, Map<Integer, Casa> objetos) {
        boolean v = false;
        if (identifica > 0) {
            for (int i = getPosicao; i < getProx; i += identifica) {
                Object o = objetos.get(i);
                String imgCasa = objetos.get(i).verificaImgCasa();
                if ((imgCasa.equalsIgnoreCase("imgB\\12aguaRato.png"))
                        || (imgCasa.equalsIgnoreCase("imgP\\12aguaRato.png"))) {
                    v = true;
                    break;
                }
            }

        } else {
            for (int i = getPosicao; i > getProx; i += identifica) {
                Object o = objetos.get(i);
                String imgCasa = objetos.get(i).verificaImgCasa();
                if ((imgCasa.equalsIgnoreCase("imgB\\12aguaRato.png"))
                        || (imgCasa.equalsIgnoreCase("imgP\\12aguaRato.png"))) {
                    v = true;
                    break;
                }
            }
        }
        return v;

    }

    private void atacar(String getThis, String imgCasa, int valorAnimalCasa, int novaPos, Map<Integer, Casa> objetos) {
        String verificaProx = imgCasa.substring(5, 7);
        if (!(getThis.equalsIgnoreCase(imgCasa.substring(0, 4)))) {
            if (getValor() >= valorAnimalCasa && valorAnimalCasa != 0) {
                if ((novaPos == getPosicao() + 28) || (novaPos == getPosicao() - 28)
                        || (novaPos == getPosicao() + 3) || (novaPos == getPosicao() - 3)) {
                    boolean entrarAgua = verificarSalto(novaPos, objetos);
                    if (entrarAgua == false) {
                        setImgPosAnt("imgC\\01grama.png");
                        setVerificaMovimento(true);
                    }
                } else {
                    if (!(imgCasa.equalsIgnoreCase(imgCasa.substring(0, 4) + "\\12aguaRato.png"))) {
                        modoAtaqueA(getThis, verificaProx);
                    }
                }
            } else if (valorAnimalCasa == 0) {
                setImg(getThis + "\\TQ03tigre.png");
                setImgPosAnt("imgC\\01grama.png");
                setVerificaMovimento(true);
            }
        }
    }

    private void modoAtaqueA(String getThis, String verificaProx) {
        if (!(getImg().equalsIgnoreCase(getThis + "\\TQ03tigre.png"))) {
            if (verificaProx.equalsIgnoreCase("TQ")) {
                setImgPosAnt("imgC\\01grama.png");
                setImg(getThis + "\\TQ03tigre.png");
                setValor(0);
            }
            setVerificaMovimento(true);
        } else {
            setImgPosAnt("imgC\\02tocaQuadrada.png");
            setImg(getThis + "\\03tigre.png");
            setVerificaMovimento(true);
            setValor(6);
        }
    }
}
