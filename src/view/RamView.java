package view;
import javax.swing.*;

import controller.*;

import java.awt.*;
import java.awt.event.*;

public class RamView extends JFrame {

    BuscadorSistemaController buscadorSistema = new BuscadorSistemaController();
    
    public final JLabel tipoDDR = new JLabel(buscadorSistema.sistemaOperacional(), SwingConstants.RIGHT);
    public final JLabel tamanhoRAM = new JLabel(buscadorSistema.totalMemoriaRAM(), SwingConstants.RIGHT);
    public final JLabel channelPCI = new JLabel(buscadorSistema.arquiteturaSistema(), SwingConstants.RIGHT);

    public static RamView application = new RamView();

    public RamView() {
        super("System");
        setLayout(new GridLayout(7, 3, 5, 5));

        JPanel linha1 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha2 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha3 =  new JPanel(new GridLayout(1, 1, 10, 10));

        
        JMenu ramMenu = new JMenu("Memoria RAM");
        ramMenu.setMnemonic('M');

        JMenuItem sistemaMenu = new JMenuItem("Sistema");
        sistemaMenu.setMnemonic('S');
        ramMenu.add(sistemaMenu);

        JMenuItem cpuMenu = new JMenuItem("CPU");
        cpuMenu.setMnemonic('C');
        ramMenu.add(cpuMenu);

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(ramMenu);

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

        /* Informações Memoria Ram */

        linha1.add(new JLabel("Nome do Usuario:", SwingConstants.LEFT));
        linha1.add(tipoDDR);

        add(linha1);
        
        linha2.add(new JLabel("Versão do Sistema Operacional:", SwingConstants.LEFT));
        linha2.add(tamanhoRAM);
        add(linha2);
        
        linha3.add(new JLabel("Arquitetura do Sistema Operacional:", SwingConstants.LEFT));
        linha3.add(channelPCI);
        add(linha3);
        
        setSize(600, 400);
        setVisible(true);
        
    }

    
    public static void main(String[] args) {
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}