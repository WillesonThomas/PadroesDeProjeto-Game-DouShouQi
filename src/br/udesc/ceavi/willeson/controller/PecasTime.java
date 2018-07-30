package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;
import java.util.Map;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class PecasTime {

    private Map<Integer, Casa> casas;

    public PecasTime(Map<Integer, Casa> casas) {
        this.casas = casas;
    }

    public void accept(Visitor visitor) throws Exception {
        Casa casa = null;
        for (int i = 0; i < casas.size(); i++) {
            casa = casas.get(i);
            visitor.visit(casa);
        }
    }

}
