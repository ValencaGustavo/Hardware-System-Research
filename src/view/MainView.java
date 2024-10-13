package view;
import javax.swing.*;

import controller.*;

import java.awt.*;
import java.awt.event.*;

public class MainView extends JFrame {

    BuscadorSistemaController buscadorSistema = new BuscadorSistemaController();
    
    public final JLabel nomeSistemaLabel = new JLabel(buscadorSistema.sistemaOperacional(), SwingConstants.RIGHT);
    public final JLabel versaoSistemaLabel = new JLabel(buscadorSistema.versaoDoSistema(), SwingConstants.RIGHT);
    public final JLabel arquiteturaSistemaLabel = new JLabel(buscadorSistema.arquiteturaSistema(), SwingConstants.RIGHT);
    public final JLabel userOSLabel = new JLabel(buscadorSistema.nomeDoUsuario(), SwingConstants.RIGHT);
    public final JLabel maxMemoryLabel = new JLabel(buscadorSistema.maxMemorySystem(), SwingConstants.RIGHT);

    public MainView() {
        super("System");
        setLayout(new GridLayout(7, 3, 5, 5));

        JPanel linha1 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha2 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha3 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha4 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha5 =  new JPanel(new GridLayout(1, 1, 10, 10));
        
        linha1.add(new JLabel("Nome do Usuario:", SwingConstants.LEFT));
        linha1.add(userOSLabel);

        add(linha1);
        
        linha2.add(new JLabel("Versão do Sistema Operacional:", SwingConstants.LEFT));
        linha2.add(versaoSistemaLabel);
        add(linha2);
        
        linha3.add(new JLabel("Arquitetura do Sistema Operacional:", SwingConstants.LEFT));
        linha3.add(arquiteturaSistemaLabel);
        add(linha3);
        
        linha4.add(new JLabel("Sistema Operacional:", SwingConstants.LEFT));
        linha4.add(nomeSistemaLabel);
        add(linha4);

        linha5.add(new JLabel("Memoria Armazenamento ( Bytes ):", SwingConstants.LEFT));
        linha5.add(maxMemoryLabel);
        add(linha5);

        System.out.println(maxMemoryLabel);
        
        setSize(600, 400);
        setVisible(true);
        
    }

    
    public static void main(String[] args) {

        MainView application = new MainView();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}