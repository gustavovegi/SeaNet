package Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class GuardaCosteiro extends Usuario {
    private String cac;
    private String regiao;
    private String departamento;

    public GuardaCosteiro(String nome, String senha, String cac, String regiao, String departamento) {
        super(nome, senha);
        this.cac = cac;
        this.regiao = regiao;
        this.departamento = departamento;
    }

    public String getCac() {
        return cac;
    }

    public void setCac(String cac) {
        this.cac = cac;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean verificacao(String rpm) {
        if (rpm.length()==10) {
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<String> listar(String regiaoOuHabitat) {
        if (regiaoOuHabitat.equals("Norte")) {
            return new ArrayList<>(Arrays.asList("Lucas Manoel", "Cristovão Machado", "Miguel Paulista"));
        } else if (regiaoOuHabitat.equals("Sul")) {
            return new ArrayList<>(Arrays.asList("Carlos Miguel", "Laura Silva", "Augusto Vieira"));
        }else if (regiaoOuHabitat.equals("Água Doce")) {
            return new ArrayList<>(Arrays.asList("Celine Rodrigues", "Jordan Machado", "Gabriel Rodrigues"));
        }else if (regiaoOuHabitat.equals("Água Salgada")) {
            return new ArrayList<>(Arrays.asList("Rodrigo Romulo", "Luisa Silva", "Karina Reis"));
        }

        return null;
    }

    public ArrayList<String> listar(String regiao, String habitat) {
        if (regiao.equals("Norte") && habitat.equals("Água Doce") ) {
            return new ArrayList<>(Arrays.asList("Carlos Miguel", "Laura Silva", "Augusto Vieira"));
        } else if (regiao.equals("Norte") && habitat.equals("Água Salgada")) {
            return new ArrayList<>(Arrays.asList("Rodrigo Romulo", "Luisa Silva", "Karina Reis"));
        }else if (regiao.equals("Sul") && habitat.equals("Água Salgada")) {
            return new ArrayList<>(Arrays.asList("Celine Rodrigues", "Jordan Machado", "Gabriel Rodrigues"));
        }else if (regiao.equals("Sul") && habitat.equals("Água Doce")) {
            return new ArrayList<>(Arrays.asList("Lucas Manoel", "Cristovão Machado", "Miguel Paulista"));
        }

        return null;
    }




}
