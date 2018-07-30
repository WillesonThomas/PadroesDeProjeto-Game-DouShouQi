package br.udesc.ceavi.willeson.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class DirectorCenario {

    private CenarioBuilder builder;
    private List<Cenario> elementos = new ArrayList<>();

    public DirectorCenario(CenarioBuilder builder) {
        this.builder = builder;
    }

    public void construir(ArrayList lista) {
        elementos.add(builder.construirGrama(lista.get(4).toString(), 0));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 1));
        elementos.add(builder.construirArmadilha(lista.get(0).toString(), 2));
        elementos.add(builder.construirTocaCircular(lista.get(1).toString(), 3));
        elementos.add(builder.construirArmadilha(lista.get(0).toString(), 4));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 5));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 6));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 7));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 8));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 9));
        elementos.add(builder.construirArmadilha(lista.get(0).toString(), 10));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 11));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 12));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 13));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 14));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 15));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 16));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 17));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 18));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 19));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 20));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 21));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 22));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 23));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 24));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 25));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 26));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 27));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 28));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 29));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 30));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 31));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 32));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 33));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 34));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 35));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 36));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 37));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 38));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 39));
        elementos.add(builder.construirAgua(lista.get(3).toString(), 40));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 41));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 42));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 43));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 44));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 45));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 46));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 47));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 48));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 49));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 50));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 51));
        elementos.add(builder.construirArmadilha(lista.get(0).toString(), 52));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 53));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 54));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 55));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 56));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 57));
        elementos.add(builder.construirArmadilha(lista.get(0).toString(), 58));
        elementos.add(builder.construirTocaCircular(lista.get(2).toString(), 59));
        elementos.add(builder.construirArmadilha(lista.get(0).toString(), 60));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 61));
        elementos.add(builder.construirGrama(lista.get(4).toString(), 62));
    }

    public CenarioAbstractFactory getPeca() {
        return builder.getCenario();
    }

    public ArrayList getListCenario() {
        ArrayList imagens = new ArrayList();
        String img = "";
        for (int i = 0; i < elementos.size(); i++) {
            img = elementos.get(i).getImg();
            imagens.add(img);
        }
        return imagens;
    }

    public ArrayList<Cenario> getListObj() {
        ArrayList<Cenario> objList = new ArrayList();
        Cenario o = null;
        for (int i = 0; i < elementos.size(); i++) {
            o = elementos.get(i);
            objList.add(o);
        }
        return objList;
    }
}
