package br.udesc.ceavi.willeson.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class DirectorPeca {

    private PecaBuilder builder;
    private List<Peca> pecas = new ArrayList<>();

    public DirectorPeca(PecaBuilder builder) {
        this.builder = builder;
    }

    public void construir(String leao, String cachorro, String elefante, String gato, String leopardo, String lobo,
            String rato, String tigre, String circular) {
        pecas.add(builder.construirLeao(leao));
        pecas.add(builder.construirTigre(tigre));
        pecas.add(builder.construirCachorro(cachorro));
        pecas.add(builder.construirGato(gato));
        pecas.add(builder.construirRato(rato));
        pecas.add(builder.construirLeopardo(leopardo));
        pecas.add(builder.construirLobo(lobo));
        pecas.add(builder.construirElefante(elefante));
    }

    public PecaAbstractFactory getPeca() {
        return builder.getPeca();
    }

    public ArrayList getListPecas() {
        ArrayList imagens = new ArrayList();
        String img = "";
        for (int i = 0; i < pecas.size(); i++) {
            img = pecas.get(i).getImg();
            imagens.add(img);
        }
        return imagens;
    }

    public ArrayList<Peca> getListObj() {
        ArrayList<Peca> objList = new ArrayList();
        Peca o = null;
        for (int i = 0; i < pecas.size(); i++) {
            o = pecas.get(i);
            objList.add(o);
        }
        return objList;
    }
}
