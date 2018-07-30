package br.udesc.ceavi.willeson.model;

import br.udesc.ceavi.willeson.controller.Cenario;
import br.udesc.ceavi.willeson.controller.Peca;
import java.io.Serializable;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class Casa implements Serializable {

    private Peca peca;
    private Cenario cenario;
    private boolean verifica;

    public Casa(Object peca, Object cenario) {
        if (peca != null) {
            setPeca((Peca) peca);
            setCenario((Cenario) cenario);
            setVerifica(true);
        } else {
            setCenario((Cenario) cenario);
            setVerifica(false);

        }

    }

    public int valorAnimalCasa() {
        int valor = -1;
        if (isVerifica() == true) {
            valor = getPeca().getValor();
        }
        return valor;
    }

    public String verificaImgCasa() {
        String imgCasa = "";
        if (isVerifica() == true) {
            imgCasa = getPeca().getImg();
        } else {
            imgCasa = getCenario().getImg();
        }
        return imgCasa;
    }

    public Object verificaObjeto() {
        Object objeto = "";
        if (isVerifica() == true) {
            objeto = getPeca();
        } else {
            objeto = getCenario();
        }
        return objeto;

    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        if (peca != null) {
            setVerifica(true);
            this.peca = peca;
        } else {
            setVerifica(false);
            this.peca = peca;
        }

    }

    public Cenario getCenario() {
        return cenario;
    }

    public void setCenario(Cenario cenario) {
        if (cenario != null) {
            setVerifica(false);
            this.cenario = cenario;
        } else {
            setVerifica(true);
        }

    }

    public boolean isVerifica() {
        return verifica;
    }

    public void setVerifica(boolean verifica) {
        this.verifica = verifica;
    }

}
