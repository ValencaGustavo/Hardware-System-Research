package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public String cpuProcessor(){
        String cpu = "Desconhecido";
        try {
            Process processo = Runtime.getRuntime().exec("wmic cpu get Name");
        
            try (BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()))) {
                String linha;

                leitor.readLine();
                while ((linha = leitor.readLine()) != null) {

                    if (linha.trim().isEmpty()) {
                        continue;
                    }

                    cpu = linha.trim();
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao executar o comando: " + e.getMessage());
        }
        return cpu;
     }

     public String socketProcessor(){
        String socketCPU = "Desconhecido";
        try {
            Process processo = Runtime.getRuntime().exec("wmic cpu get socketdesignation");
        
            try (BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()))) {
                String linha;

                leitor.readLine();
                while ((linha = leitor.readLine()) != null) {

                    if (linha.trim().isEmpty()) {
                        continue;
                    }

                    socketCPU = linha.trim();
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao executar o comando: " + e.getMessage());
        }
        return socketCPU;
     }

    public String especificacaoProcessador(){
        String especificacao = "";
        especificacao = System.getenv("PROCESSOR_IDENTIFIER");
     
        return especificacao;
     }

    public String totalMemoriaRAM() {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long totalMemoriaRam = osBean.getTotalPhysicalMemorySize() / (1023 * 1023 * 1023);
        String maxMemoryString = "" + totalMemoriaRam;

        return maxMemoryString;
    }

    public String tipoMemoriaRAM() {
        String tipoMemoria = "Desconhecido";
        try {
            Process processo = Runtime.getRuntime().exec("wmic memorychip get MemoryType");
        
            try (BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()))) {
                String linha;
                while ((linha = leitor.readLine()) != null) {
                
                    try {
                        int codigo = Integer.parseInt(linha.trim());
                    
                        switch (codigo) {
                            case 20:
                                tipoMemoria = "DDR1";
                                break;
                            case 21:
                                tipoMemoria = "DDR2";
                                break;
                            case 24:
                                tipoMemoria = "DDR3";
                                break;
                            case 26:
                                tipoMemoria = "DDR4";
                                break;
                            default:
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao executar o comando: " + e.getMessage());
        }
        return tipoMemoria;
    }

    public String channelMemoriaRAM() {
        try {
            Process processo = Runtime.getRuntime().exec("wmic memorychip get BankLabel");
            
            try (BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()))) {
                String linha;
                int count = 0;
    
                while ((linha = leitor.readLine()) != null) {
                    if (!linha.contains("BankLabel")) {
                        count++;
                    }
                }
    
                if (count >= 2) {
                    return "Dual Channel";
                } else {
                    return "Single Channel";
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao executar o comando: " + e.getMessage());
            return "Desconhecido";
        }
    }
    

    public String fabricanteMemoriaRAM() {
        String fabricante = "Desconhecido";
        try {
            Process processo = Runtime.getRuntime().exec("wmic memorychip get Manufacturer");
        
            try (BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()))) {
                String linha;

                leitor.readLine();
                while ((linha = leitor.readLine()) != null) {

                    if (linha.trim().isEmpty()) {
                        continue;
                    }

                        fabricante = linha.trim();
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao executar o comando: " + e.getMessage());
        }
        return fabricante;
    }
}
