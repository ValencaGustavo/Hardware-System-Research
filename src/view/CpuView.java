package view;
import javax.swing.*;

import controller.*;

import java.awt.*;
import java.awt.event.*;

public class CpuView extends JFrame {

    BuscadorSistemaController buscadorSistema = new BuscadorSistemaController();
    
    public final JLabel nomeProcessador = new JLabel(buscadorSistema.sistemaOperacional(), SwingConstants.RIGHT);
    public final JLabel socketLGA = new JLabel(buscadorSistema.versaoDoSistema(), SwingConstants.RIGHT);
    public final JLabel especificacaoProcessador = new JLabel(buscadorSistema.arquiteturaSistema(), SwingConstants.RIGHT);

    public static CpuView application = new CpuView();

    public CpuView() {
        super("System");
        setLayout(new GridLayout(4, 2, 5, 5));

        JPanel linha1 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha2 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha3 =  new JPanel(new GridLayout(1, 1, 10, 10));

        JMenu cpuMenu = new JMenu("CPU");
        cpuMenu.setMnemonic('C');

        JMenuItem sistemaMenu = new JMenuItem("Sistema");
        sistemaMenu.setMnemonic('S');
        cpuMenu.add(sistemaMenu);

        JMenuItem ramMenu = new JMenuItem("Memoria RAM");
        ramMenu.setMnemonic('M');
        cpuMenu.add(ramMenu);

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(cpuMenu);

        sistemaMenu.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    CpuView.application.dispose();
                    
                    setVisible(false);
                    SistemaView application = new SistemaView();
                    application.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            }
        );

        ramMenu.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    RamView.application.dispose();
                    
                    setVisible(false);
                    RamView application = new RamView();
                    application.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            }
        );

        /* Informações CPU */

        linha1.add(new JLabel("Nome do Usuario:", SwingConstants.LEFT));
        linha1.add(nomeProcessador);

        add(linha1);
        
        linha2.add(new JLabel("Versão do Sistema Operacional:", SwingConstants.LEFT));
        linha2.add(socketLGA);
        add(linha2);
        
        linha3.add(new JLabel("Arquitetura do Sistema Operacional:", SwingConstants.LEFT));
        linha3.add(especificacaoProcessador);
        add(linha3);
        
        setSize(600, 400);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}