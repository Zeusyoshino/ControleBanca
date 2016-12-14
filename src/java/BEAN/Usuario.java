/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

/**
 *
 * @author Mylena
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String celular;
    private int nivelacesso;
    private boolean status;

    public Usuario(int id, String nome, String email, String senha, String celular, int nivelacesso, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.nivelacesso = nivelacesso;
        this.status = status;
    }

    public Usuario(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(int nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public boolean isStatus() {
        return status;
    }
}
