package br.udesc.ceavi.willeson.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Willeson Thomas da Silva
 */
public class StrategyNovoJogo implements StrategyMenu {

    private final ControllerTabuleiro controller;

    public StrategyNovoJogo(ControllerTabuleiro controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        escolhaJogador();
        controller.novoJogo(jogo());
    }

    public void escolhaJogador() {
        String j1 = JOptionPane.showInputDialog(null, "Informe o nome do jogador 01:");
        int time01 = Integer.parseInt(JOptionPane.showInputDialog(null, j1 + ", escolha seu time: " + "\n1-Branco" + "\n2-Preto"));
        String j2 = JOptionPane.showInputDialog(null, "Informe o nome do jogador 02:");
        if (time01 == 1) {
            controller.jogar(j1, "branco", j2, "preto");
        } else if (time01 == 2) {
            controller.jogar(j1, "preto", j2, "branco");
        }

    }

    private ArrayList jogo() {
        ArrayList lista = new ArrayList<>();

        lista.add("imgC\\02tocaQuadrada.png");//0
        lista.add("imgB\\04tocaCircular.png");//1
        lista.add("imgP\\04tocaCircular.png");//2
        lista.add("imgC\\11agua.png");//3
        lista.add("imgC\\01grama.png");//4

        lista.add("imgB\\01Leao.png");//5
        lista.add("imgB\\05cachorro.png");//6
        lista.add("imgB\\07elefante.png");//7
        lista.add("imgB\\06gato.png");//8
        lista.add("imgB\\09leopardo.png");//9
        lista.add("imgB\\08lobo.png");//10
        lista.add("imgB\\10rato.png");//11
        lista.add("imgB\\03tigre.png");//12
        lista.add("imgB\\04tocaCircular.png");//13

        lista.add("imgP\\01Leao.png");//14
        lista.add("imgP\\05cachorro.png");//15
        lista.add("imgP\\07elefante.png");//16
        lista.add("imgP\\06gato.png");//17
        lista.add("imgP\\09leopardo.png");//18
        lista.add("imgP\\08lobo.png");//19
        lista.add("imgP\\10rato.png");//20
        lista.add("imgP\\03tigre.png");//21
        lista.add("imgP\\04tocaCircular.png");//22

        return lista;
    }

    @Override
    public String toString() {
        return "Novo jogo";
    }

}
