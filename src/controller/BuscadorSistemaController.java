package controller;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

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

    public String totalMemoriaRAM() {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long totalMemoriaRam = osBean.getTotalPhysicalMemorySize() / (1023 * 1023 * 1023);
        String maxMemoryString = "" + totalMemoriaRam;

        return maxMemoryString;
    }
}
