package Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Pescador extends Usuario {
    private String rgb;
    private String embarcacao;

    public Pescador(String nome, String senha, String rgb, String embarcacao) {
        super(nome, senha);
        this.rgb = rgb;
        this.embarcacao = embarcacao;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public String getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(String embarcacao) {
        this.embarcacao = embarcacao;
    }

    @Override
    public boolean verificacao(String rgb) {
        if (rgb.length() == 8) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> listar(String regiaoOuHabitat) {
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

    public ArrayList<String> listar(String regiao, String habitat) {
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







