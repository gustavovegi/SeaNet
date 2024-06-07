package Classes;

import java.util.ArrayList;

public class Usuario {
    private Long id;
    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Realiza a verificação da credencial passada pelo usuário
    public boolean verificacao(String verificacao) {
        if (verificacao.length()==5) {
            return true;
        }else{
            return false;
        }
    }
}
