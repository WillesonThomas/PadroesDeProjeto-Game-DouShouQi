package br.udesc.ceavi.willeson.view;

/**
 *
 * @author Willeson Thomas da Silva
 */
import br.udesc.ceavi.willeson.controller.Peca;
import br.udesc.ceavi.willeson.controller.DirectorCenario;
import br.udesc.ceavi.willeson.controller.Observador;
import java.awt.GridLayout;
import br.udesc.ceavi.willeson.controller.DirectorPeca;
import br.udesc.ceavi.willeson.model.Casa;
import br.udesc.ceavi.willeson.controller.ControllerTabuleiro;
import br.udesc.ceavi.willeson.controller.StrategyCarregarJogo;
import br.udesc.ceavi.willeson.controller.StrategyMenu;
import br.udesc.ceavi.willeson.controller.StrategyNovoJogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//Trabalho 02 - Game de Tabuleiro (Codigo correto)!

public class Tabuleiro implements Observador {

    private JFrame frame;
    private JPanel painel;
    public JButton botoes[];
    private JMenuBar menuBar;
    private Map<Integer, Casa> casas = new HashMap<>();
    private EventoPeca evento;
    private EventoSalvarJogo salvar;
    private EventoDadosJogo dados;
    private ControllerTabuleiro controller;

    private Tabuleiro() {
        Iniciar();
    }

    private static Tabuleiro instance;

    public synchronized static Tabuleiro getInstance() {
        if (instance == null) {
            instance = new Tabuleiro();
        }

        return instance;
    }

    private void Iniciar() {
        controller = new ControllerTabuleiro();
        controller.addObservador(this);

        menuBar = new JMenuBar();
        botoes = new JButton[63];
        frame = new JFrame(" Dou Shou Qi ");
        frame.setSize(700, 600);
        frame.setLocation(300, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painel = new JPanel();
        painel.setLayout(new GridLayout(9, 9));

        //Menu
        frame.setJMenuBar(menuBar);
        JMenu editMenu = new JMenu("Jogo");
        menuBar.add(editMenu);
        JMenuItem salvarAction = new JMenuItem("Salvar");
        JMenuItem dadosAction = new JMenuItem("Ranking");
        editMenu.add(salvarAction);
        editMenu.add(dadosAction);
        salvar = new EventoSalvarJogo();
        salvarAction.addActionListener(salvar);
        dados = new EventoDadosJogo();
        dadosAction.addActionListener(dados);

        menuJogo();
    }

    public void action() {
        for (int i = 0; i < botoes.length; i++) {
            evento = new EventoPeca();
            botoes[i].addActionListener(evento);
        }
    }

    public void menuJogo() {
        try {
            List<StrategyMenu> ss = new ArrayList<>();
            ss.add(new StrategyNovoJogo(controller));//0
            ss.add(new StrategyCarregarJogo(controller));//1
            int index = 1;
            String opcoes = "";
            for (StrategyMenu sm : ss) {
                opcoes += "\n" + index + "-" + sm;
                index++;
            }
            int iniciar = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer: " + opcoes));
            StrategyMenu sm = ss.get(iniciar - 1);
            sm.run();

            action();
        } catch (Exception e) {
            System.out.println("Jogo encerrado.");
        }
    }

    public class EventoSalvarJogo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nomeArquivo = JOptionPane.showInputDialog(null, "Salvar Jogo:" + "\nInforme o nome do arquivo");
            controller.gravarJogo(casas, nomeArquivo);
        }
    }

    public class EventoDadosJogo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.mostrarDadosRanking();
        }
    }

    public class EventoPeca implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (controller.isVerifica() == false) {
                for (int i = 0; i < botoes.length; i++) {
                    if (botoes[i] == e.getSource()) {
                        controller.escolherPeca(i, casas);
                    }
                }

            } else {
                for (int i = 0; i < botoes.length; i++) {
                    if (botoes[i] == e.getSource()) {
                        controller.movimentarPeca(i, casas);
                    }
                }
            }
        }
    }

    @Override
    public void novoJogo(DirectorCenario c1, DirectorPeca d1, DirectorPeca d2) {
        for (int i = 0; i < 63; i++) {
            botoes[i] = new JButton();
            painel.add(botoes[i]);
        }

        int x = 0;
        for (int i = 0; i <= 20; i++) {
            if (i == 0 || i == 6 || i == 8 || i == 12 || i == 14 || i == 16 || i == 18 || i == 20) {
                botoes[i].setIcon(new ImageIcon(d1.getListPecas().get(x).toString()));
                casas.put(i, new Casa(d1.getListObj().get(x), c1.getListObj().get(i)));
                x += 1;
            } else {
                botoes[i].setIcon(new ImageIcon(c1.getListObj().get(i).getImg()));
                casas.put(i, new Casa(null, c1.getListObj().get(i)));
            }
        }

        for (int i = 21; i <= 41; i++) {
            botoes[i].setIcon(new ImageIcon(c1.getListObj().get(i).getImg()));
            casas.put(i, new Casa(null, c1.getListObj().get(i)));
        }

        int y = 7;
        for (int i = 42; i <= 62; i++) {
            if (i == 42 || i == 44 || i == 46 || i == 48 || i == 50 || i == 54 || i == 56 || i == 62) {
                botoes[i].setIcon(new ImageIcon(d2.getListPecas().get(y).toString()));
                casas.put(i, new Casa(d2.getListObj().get(y), c1.getListObj().get(i)));
                y -= 1;
            } else {
                botoes[i].setIcon(new ImageIcon(c1.getListObj().get(i).getImg()));
                casas.put(i, new Casa(null, c1.getListObj().get(i)));
            }
        }

        frame.getContentPane().add(painel);
        frame.setVisible(true);

    }

    @Override
    public void carregarJogo(ArrayList<Casa> casa) {
        for (int i = 0; i < 63; i++) {
            botoes[i] = new JButton();
            painel.add(botoes[i]);
        }
        for (int i = 0; i < casa.size(); i++) {
            Casa c = casa.get(i);
            if (c.getPeca() == null) {
                botoes[i].setIcon(new ImageIcon(c.getCenario().getImg()));
            } else {
                botoes[i].setIcon(new ImageIcon(c.getPeca().getImg()));
            }
            casas.put(i, casa.get(i));
        }
        frame.getContentPane().add(painel);
        frame.setVisible(true);

    }

    @Override
    public void mover(int posDestino, int posOrigem, Peca peca, String imgPosOrigem) {
        Icon iconX = new ImageIcon(peca.getImg());
        botoes[posDestino].setIcon(iconX);
        Icon iconY = new ImageIcon(imgPosOrigem);
        botoes[posOrigem].setIcon(iconY);

        Casa origem = casas.get(posOrigem);
        Casa destino = casas.get(posDestino);

        destino.setPeca(peca);
        origem.setPeca(null);
    }

    @Override
    public void fimJogo(int qtdadeBranco, int qtdadePreto, String msgVitoria, String jogador) throws Exception {
        JOptionPane.showMessageDialog(null, msgVitoria
                + "\n____________________________________"
                + "\nEstatistica: "
                + "\nPecas Brancas = " + qtdadeBranco + "\nPecas Pretas = " + qtdadePreto
                + "\n____________________________________");
        controller.gravarDadosRanking(jogador, 1);
        System.exit(0);

    }

    @Override
    public void montrarDados(String dados) {
        JOptionPane.showMessageDialog(null, dados, "RANKING", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[]) {
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
    }
}
