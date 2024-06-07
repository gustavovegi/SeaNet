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
    //Sobrescrita da classe mãe, adaptando a verificação para credencial do guarda costeiro
    @Override
    public boolean verificacao(String cac) {
        if (cac.length()==10) {
            return true;
        }else{
            return false;
        }
    }
    //Método de sobrecarga, lista pescadores dependendo dos parametros passados pelo usuário(região e tipo de pesca)
    public ArrayList<String> listarPescadores(String regiaoOutipoPesca) {
        if (regiaoOutipoPesca.equals("Norte")) {
            return new ArrayList<>(Arrays.asList("Lucas Manoel", "Cristovão Machado", "Miguel Paulista"));
        } else if (regiaoOutipoPesca.equals("Sul")) {
            return new ArrayList<>(Arrays.asList("Carlos Miguel", "Laura Silva", "Augusto Vieira"));
        }else if (regiaoOutipoPesca.equals("Água Doce")) {
            return new ArrayList<>(Arrays.asList("Celine Rodrigues", "Jordan Machado", "Gabriel Rodrigues"));
        }else if (regiaoOutipoPesca.equals("Água Salgada")) {
            return new ArrayList<>(Arrays.asList("Rodrigo Romulo", "Luisa Silva", "Karina Reis"));
        }

        return null;
    }

    //Método de sobrecarga, lista pescadores dependendo dos parametros passados pelo usuário(região e tipo de pesca)
    public ArrayList<String> listarPescadores(String regiao, String tipoPesca) {
        if (regiao.equals("Norte") && tipoPesca.equals("Água Doce") ) {
            return new ArrayList<>(Arrays.asList("Carlos Miguel", "Laura Silva", "Augusto Vieira"));
        } else if (regiao.equals("Norte") && tipoPesca.equals("Água Salgada")) {
            return new ArrayList<>(Arrays.asList("Rodrigo Romulo", "Luisa Silva", "Karina Reis"));
        }else if (regiao.equals("Sul") && tipoPesca.equals("Água Salgada")) {
            return new ArrayList<>(Arrays.asList("Celine Rodrigues", "Jordan Machado", "Gabriel Rodrigues"));
        }else if (regiao.equals("Sul") && tipoPesca.equals("Água Doce")) {
            return new ArrayList<>(Arrays.asList("Lucas Manoel", "Cristovão Machado", "Miguel Paulista"));
        }

        return null;
    }




}
