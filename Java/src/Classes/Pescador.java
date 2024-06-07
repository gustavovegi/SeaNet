package Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Pescador extends Usuario {
    private String rgp;
    private String embarcacao;

    public Pescador(String nome, String senha, String rgp, String embarcacao) {
        super(nome, senha);
        this.rgp = rgp;
        this.embarcacao = embarcacao;
    }

    public String getRgp() {
        return rgp;
    }

    public void setRgp(String rgp) {
        this.rgp = rgp;
    }

    public String getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(String embarcacao) {
        this.embarcacao = embarcacao;
    }

    //Sobrescrita da classe mãe, adaptando a verificação para credencial do pescador
    @Override
    public boolean verificacao(String rgp) {
        if (rgp.length() == 8) {
            return true;
        } else {
            return false;
        }
    }

    //Método de sobrecarga, lista peixes dependendo dos parametros passados pelo usuário(região e habitat)
    public ArrayList<String> listarPeixes(String regiaoOuHabitat) {
        if (regiaoOuHabitat.equals("Norte")) {
            return new ArrayList<>(Arrays.asList("Salmão do Atlântico", "Truta", "Bacalhau"));
        } else if (regiaoOuHabitat.equals("Sul")) {
            return new ArrayList<>(Arrays.asList("Pescada", "Linguado", "Anchova"));
        }else if (regiaoOuHabitat.equals("Oceano")) {
            return new ArrayList<>(Arrays.asList("Salmão", "Tilápia", "Atum"));
        }else if (regiaoOuHabitat.equals("Rio")) {
            return new ArrayList<>(Arrays.asList("Baiacu", "Sardinha", "Dourado"));
        }

        return null;
    }

    //Método de sobrecarga, lista peixes dependendo dos parametros passados pelo usuário(região e habitat)
    public ArrayList<String> listarPeixes(String regiao, String habitat) {
        if (regiao.equals("Norte") && habitat.equals("Oceano") ) {
            return new ArrayList<>(Arrays.asList("Salmão do Atlântico", "Truta", "Bacalhau"));
        } else if (regiao.equals("Norte") && habitat.equals("Rio")) {
            return new ArrayList<>(Arrays.asList("Pescada", "Linguado", "Anchova"));
        }else if (regiao.equals("Sul") && habitat.equals("Oceano")) {
            return new ArrayList<>(Arrays.asList("Dourado", "Piranha", "Peixe-palhaço"));
        }else if (regiao.equals("Sul") && habitat.equals("Rio")) {
            return new ArrayList<>(Arrays.asList("Anchova", "Enguia", "Garoupa"));
        }

        return null;
    }






}







