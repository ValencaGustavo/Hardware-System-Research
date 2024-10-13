package controller;
public class BuscadorSistemaController {

    
    public String sistemaOperacional() {
        return System.getProperty("os.name");
    }

    public String versaoDoSistema() {
        return System.getProperty("os.version");
    }

    public String nomeDoUsuario() {
        return System.getProperty("user.name");
    }

    public String arquiteturaSistema() {
        return System.getProperty("os.arch");
    }

    public String maxMemorySystem() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        String maxMemoryString = (maxMemory == Long.MAX_VALUE) ? "no limit" : String.valueOf(maxMemory);

        return maxMemoryString;
    }
}
