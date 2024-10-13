import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    public final String nameOS = "os.name";  
    public final String versionOS = "os.version";  
    public final String architectureOS = "os.arch";
    public final String userOS = "user.name";
    public final long maxMemory = Runtime.getRuntime().maxMemory();
    
    private final String nomeSistemaString = System.getProperty(nameOS);  
    private final String versaoSistemaString = System.getProperty(versionOS);  
    private final String arquiteturaSistemaString = System.getProperty(architectureOS);
    private final String userOSString = System.getProperty(userOS);
    public final String memoriaRAMString = (maxMemory == Long.MAX_VALUE) ? "no limit" : String.valueOf(maxMemory);
    
    public final JLabel nomeSistemaLabel = new JLabel(nomeSistemaString);
    public final JLabel versaoSistemaLabel = new JLabel(versaoSistemaString);
    public final JLabel arquiteturaSistemaLabel = new JLabel(arquiteturaSistemaString);
    public final JLabel userOSLabel = new JLabel(userOSString);
    public final JLabel maxMemoryLabel = new JLabel(memoriaRAMString);
    
    private final JLabel nomeSistema = new JLabel("Sistema Operacional:", SwingConstants.LEFT);
    private final JLabel versaoSistema = new JLabel("Versão do Sistema Operacional:", SwingConstants.LEFT);
    private final JLabel arquiteturaSistema = new JLabel("Arquitetura do Sistema Operacional:", SwingConstants.LEFT);
    private final JLabel usuarioSistema = new JLabel("Nome do Usuario:", SwingConstants.LEFT);
    private final JLabel memoriaRAM = new JLabel("Memoria RAM:", SwingConstants.LEFT);

    private final JLabel espacador1 = new JLabel("");
    private final JLabel espacador2 = new JLabel("");
    private final JLabel espacador3 = new JLabel("");
    private final JLabel espacador4 = new JLabel("");
    private final JLabel espacador5 = new JLabel("");

    public Main() {
        super("System");
        setLayout(new GridLayout(7, 3, 5, 5));

        JPanel linha1 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha2 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha3 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha4 =  new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel linha5 =  new JPanel(new GridLayout(1, 1, 10, 10));
        
        linha1.add(usuarioSistema);
        linha1.add(espacador4);
        linha1.add(userOSLabel);

        add(linha1);
        
        linha2.add(versaoSistema);
        linha2.add(espacador2);
        linha2.add(versaoSistemaLabel);
        add(linha2);
        
        linha3.add(arquiteturaSistema);
        linha3.add(espacador3);
        linha3.add(arquiteturaSistemaLabel);
        add(linha3);
        
        linha4.add(nomeSistema);
        linha4.add(espacador1);
        linha4.add(nomeSistemaLabel);
        add(linha4);

        linha5.add(memoriaRAM);
        linha5.add(espacador5);
        linha5.add(maxMemoryLabel);
        add(linha5);

        System.out.println(maxMemoryLabel);
        
        
        
        setSize(600, 400);
        setVisible(true);
        
    }

    
    public static void main(String[] args) {

        Main application = new Main();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}