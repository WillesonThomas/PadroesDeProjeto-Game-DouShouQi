package br.udesc.ceavi.willeson.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class DadosRanking extends Dados {

    private List<Dados> dados = new ArrayList<>();

    @Override
    public void addDados(Dados dado) {
        dados.add(dado);
    }

    @Override
    public void ler() {

        try {
            FileInputStream arquivo = new FileInputStream("Ranking.arq");
            ObjectInputStream obj = new ObjectInputStream(arquivo);
            String nome = "";
            for (int i = 0; i < arquivo.available(); i++) {
                Dados c = (Dados) obj.readObject();
                nome = c.getJogador();
                int pontuacao = 0;
                boolean verifica = false;

                for (int j = 0; j < dados.size(); j++) {
                    if (dados.get(j).getJogador().equalsIgnoreCase(nome)) {
                        pontuacao = c.getPontos() + dados.get(j).getPontos();
                        dados.get(j).setPontos(pontuacao);
                        verifica = true;
                        break;
                    }
                }
                if (verifica == false) {
                    dados.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel ler o arquivo");
        }
    }

    @Override
    public void gravar() {
        try {
            FileOutputStream arquivo = new FileOutputStream("Ranking.arq");
            ObjectOutputStream obj = new ObjectOutputStream(arquivo);
            for (int i = 0; i < dados.size(); i++) {
                obj.writeObject(dados.get(i));
                obj.flush();
            }
            obj.close();
        } catch (Exception e) {
            System.out.println("Não foi possivel gravar os dados do jogo");
        }
    }

    @Override
    public void gerarRanking() {
        File arquivo = new File("Ranking.arq");
        if (arquivo.exists() == true) {
            ler();
        }
        Collections.sort(dados);
        gravar();
    }
}
