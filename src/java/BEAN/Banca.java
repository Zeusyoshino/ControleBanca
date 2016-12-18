/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Mylena
 */
public class Banca {
    private int id;
    private Date data;
    private Time hora;
    private String resumo;
    private String tema;
    private String curso;

    public Banca(int id, java.sql.Date data, Time hora, String resumo, String tema, String curso) {
       
    }

    public Banca() {

    }

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public Date getData() {
        return data;
    }

    
    public void setData(Date data) {
        this.data = data;
    }

    
    public Time getHora() {
        return hora;
    }

    
    public void setHora(Time hora) {
        this.hora = hora;
    }

    
    public String getResumo() {
        return resumo;
    }

    
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    
    public String getTema() {
        return tema;
    }

    
    public void setTema(String tema) {
        this.tema = tema;
    }

    
    public String getCurso() {
        return curso;
    }

    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
          
            
    
}
