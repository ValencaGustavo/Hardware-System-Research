package view;
import javax.swing.*;

import controller.*;

import java.awt.*;
import java.awt.event.*;

public class SistemaView extends JFrame {

    BuscadorSistemaController buscadorSistema = new BuscadorSistemaController();
    
    public final JLabel nomeSistemaLabel = new JLabel(buscadorSistema.sistemaOperacional(), SwingConstants.RIGHT);
    public final JLabel versaoSistemaLabel = new JLabel(buscadorSistema.versaoDoSistema(), SwingConstants.RIGHT);
    public final JLabel arquiteturaSistemaLabel = new JLabel(buscadorSistema.arquiteturaSistema(), SwingConstants.RIGHT);

    public SistemaView() {
        super("System");
        setLayout(new GridLayout(7, 3, 5, 5));

        JPanel linha1 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha2 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha3 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha4 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha5 =  new JPanel(new GridLayout(1, 1, 10, 10));
        
        JMenu sistemaMenu = new JMenu("Sistema");
        sistemaMenu.setMnemonic('S');

        JMenuItem cpuMenu = new JMenuItem("CPU");
        cpuMenu.setMnemonic('C');
        sistemaMenu.add(cpuMenu);

        JMenuItem ramMenu = new JMenuItem("Memoria RAM");
        ramMenu.setMnemonic('M');
        sistemaMenu.add(ramMenu);

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(sistemaMenu);

        /* Configuração Botões */

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

        cpuMenu.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    CpuView.application.dispose();
                    
                    setVisible(false);
                    CpuView application = new CpuView();
                    application.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            }
        );

        /* Informações Sistema */
        
        linha2.add(new JLabel("Versão do Sistema Operacional:", SwingConstants.LEFT));
        linha2.add(versaoSistemaLabel);
        add(linha2);
        
        linha3.add(new JLabel("Arquitetura do Sistema Operacional:", SwingConstants.LEFT));
        linha3.add(arquiteturaSistemaLabel);
        add(linha3);
        
        linha4.add(new JLabel("Sistema Operacional:", SwingConstants.LEFT));
        linha4.add(nomeSistemaLabel);
        add(linha4);
        
        setSize(600, 400);
        setVisible(true);
        
    }

    
    public static void main(String[] args) {

        SistemaView application = new SistemaView();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}