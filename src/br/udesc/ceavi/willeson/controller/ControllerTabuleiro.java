package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class ControllerTabuleiro {

    private CommandInvoker invoker;
    private Peca peca;
    public int posAnimal;
    private boolean verifica = false;
    private List<Observador> obs = new ArrayList<>();
    private Jogador jogador01;
    private Jogador jogador02;
    private Jogador jogadorAtual;

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(Jogador jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public int getPosAnimal() {
        return posAnimal;
    }

    public void setPosAnimal(int posAnimal) {
        this.posAnimal = posAnimal;
    }

    public void addObservador(Observador o) {
        obs.add(o);
    }

    public boolean isVerifica() {
        return verifica;
    }

    public void setVerifica(boolean verifica) {
        this.verifica = verifica;
    }

    public void carregarJogo(ArrayList lista) {
        for (Observador ob : obs) {
            ob.carregarJogo(lista);
        }
    }

    public void novoJogo(ArrayList lista) {
        CenarioConcretFactory cenarioFactory = new CenarioConcretFactory();
        CenarioBuilder c = new CenarioConcretBuilder(cenarioFactory);
        DirectorCenario c1 = new DirectorCenario(c);
        PecaConcretFactory pecaFactory = new PecaConcretFactory();
        PecaBuilder p1 = new Player1ConcretBuilder(pecaFactory);
        PecaBuilder p2 = new Player2ConcretBuilder(pecaFactory);
        DirectorPeca d1 = new DirectorPeca(p1);
        DirectorPeca d2 = new DirectorPeca(p2);

        c1.construir(lista);
        d1.construir(lista.get(5).toString(), lista.get(6).toString(), lista.get(7).toString(), lista.get(8).toString(),
                lista.get(9).toString(), lista.get(10).toString(), lista.get(11).toString(), lista.get(12).toString(),
                lista.get(13).toString());

        d2.construir(lista.get(14).toString(), lista.get(15).toString(), lista.get(16).toString(), lista.get(17).toString(),
                lista.get(18).toString(), lista.get(19).toString(), lista.get(20).toString(), lista.get(21).toString(),
                lista.get(22).toString());

        for (Observador ob : obs) {
            ob.novoJogo(c1, d1, d2);
        }
    }

    public void escolherPeca(int posicao, Map<Integer, Casa> objetos) {
        if (objetos.get(posicao).isVerifica() == true) {
            setPeca(objetos.get(posicao).getPeca());
            getJogadorAtual().verificarEstado(this, posicao);
        }
    }

    public void movimentarPeca(int proxPos, Map<Integer, Casa> objetos) {
        if (proxPos != getPosAnimal()) {
            invoker = new CommandInvoker();
            invoker.execute(proxPos, getPeca(), objetos);
            if (getPeca().isVerificaMovimento() == true) {
                for (Observador ob : obs) {
                    ob.mover(proxPos, getPeca().getPosicao(), getPeca(), getPeca().getImgPosAnt());
                }
                verificaFimJogo(objetos);
                alterarJogador();
                getPeca().setPosicao(proxPos);
                getPeca().setVerificaMovimento(false);
            }
        }
        setVerifica(false);
    }

    public void jogar(String j01, String time01, String j02, String time02) {
        jogador01 = new Jogador(j01, time01);
        jogador02 = new Jogador(j02, time02);
        jogadorAtual = jogador01;
    }

    public void alterarJogador() {
        jogador01.alterarEstado(this);
        jogador02.alterarEstado(this);
    }

    public void verificaFimJogo(Map<Integer, Casa> objetos) {
        try {
            PecasTime x = new PecasTime(objetos);
            Estatistica est = new Estatistica();
            x.accept(est);
            if (getPeca().isVerificaFimJogo() == true || est.getQtdadeBranco() == 0 || est.getQtdadePreto() == 0) {
                for (Observador ob : obs) {
                    ob.fimJogo(est.getQtdadeBranco(), est.getQtdadePreto(),
                            jogadorAtual.mensagemVitoria(), jogadorAtual.getNome());
                }
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel finalizar o jogo corretamente.");
        }
    }

    public void gravarJogo(Map<Integer, Casa> casas, String nomeArquivo) {
        try {
            FileOutputStream arquivo = new FileOutputStream(nomeArquivo + ".arq");
            ObjectOutputStream obj = new ObjectOutputStream(arquivo);
            for (int i = 0; i < 63; i++) {
                obj.writeObject(casas.get(i));
                obj.flush();
            }
            obj.writeObject(jogador01);
            obj.flush();
            obj.writeObject(jogador02);
            obj.flush();
            obj.close();
        } catch (Exception e) {
            System.out.println("Não foi possível gravar o jogo.");
        }
    }

    public void gravarDadosRanking(String jogador, int pontos) throws Exception {
        Dados partida = new DadosPartida(jogador, pontos);
        Dados ranking = new DadosRanking();
        ranking.addDados(partida);
        ranking.gerarRanking();
    }

    public void mostrarDadosRanking() {
        try {
            FileInputStream arquivo = new FileInputStream("Ranking.arq");
            ObjectInputStream obj = new ObjectInputStream(arquivo);
            String nome = "";
            for (int i = 0; i < arquivo.available(); i++) {
                Dados c = (Dados) obj.readObject();
                nome += "Jogador: " + c.getJogador() + "\nPontuacao: " + c.getPontos() + "\n______________________" + "\n";
            }
            for (Observador ob : obs) {
                ob.montrarDados(nome);
            }
        } catch (Exception e) {
            System.out.println("Não foi possível mostrar dados");
        }
    }
}
