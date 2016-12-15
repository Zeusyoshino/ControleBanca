/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mylena
 */
public class Usuario implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    
    public String novoUsuario(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("chamou o método");
        return "/paginas/caduser.jsp";
    }

    public String ListaUsuario(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("chamou o método");
        return "/paginas/listuser.jsp";
    }
        
}
