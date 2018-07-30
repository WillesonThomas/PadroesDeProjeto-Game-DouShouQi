package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class Estatistica implements Visitor {

    private int qtdadeBranco;
    private int qtdadePreto;

    @Override
    public void visit(Casa casa) throws Exception {
        if (casa.getPeca() != null) {
            if (casa.verificaImgCasa().substring(0, 4).equalsIgnoreCase("imgB")) {
                qtdadeBranco++;
            } else if (casa.verificaImgCasa().substring(0, 4).equalsIgnoreCase("imgP")) {
                qtdadePreto++;
            }
        }
    }

    public int getQtdadeBranco() {
        return qtdadeBranco;
    }

    public int getQtdadePreto() {
        return qtdadePreto;
    }
}
