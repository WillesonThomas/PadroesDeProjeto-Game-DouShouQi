package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;

/**
 *
 * @author Willeson Thomas da Silva
 */
public interface Visitor {

    void visit(Casa casa) throws Exception;
}
