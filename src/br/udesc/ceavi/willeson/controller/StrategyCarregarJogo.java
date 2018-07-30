package br.udesc.ceavi.willeson.controller;

import br.udesc.ceavi.willeson.model.Casa;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class StrategyCarregarJogo implements StrategyMenu {

    private final ControllerTabuleiro controller;

    public StrategyCarregarJogo(ControllerTabuleiro controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        escolherCarregarJogo();
    }

    public void escolherCarregarJogo() {
        String nomeArquivo = JOptionPane.showInputDialog(null, "Carregar Jogo:" + "\nInforme o nome do arquivo que deseja carregar");
        String nome = nomeArquivo + ".arq";
        File arquivo = new File(nome);
        if (arquivo.exists() == true) {
            controller.carregarJogo(jogo(nome));
        } else {
            JOptionPane.showMessageDialog(null, "Nao existe jogo para carregar");
        }

    }

    public void escolhaJogador(Jogador jogador01, Jogador jogador02) {
        if (jogador01.getTime().equalsIgnoreCase("imgB")) {
            controller.jogar(jogador01.getNome(), "branco", jogador02.getNome(), "preto");
        } else if (jogador01.getTime().equalsIgnoreCase("imgP")) {
            controller.jogar(jogador01.getNome(), "preto", jogador02.getNome(), "branco");
        }

    }

    public ArrayList jogo(String nomeArquivo) {
        ArrayList<Casa> lista = new ArrayList<>();
        try {
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream obj = new ObjectInputStream(arquivo);
            for (int i = 0; i < 63; i++) {
                Casa c = (Casa) obj.readObject();
                lista.add(c);
            }
            Jogador jogador01 = (Jogador) obj.readObject();
            Jogador jogador02 = (Jogador) obj.readObject();
            escolhaJogador(jogador01, jogador02);
        } catch (Exception e) {
            System.err.println("Arquivo não encontrado");
        }
        return lista;
    }

    @Override
    public String toString() {
        return "Carregar jogo";
    }

}
