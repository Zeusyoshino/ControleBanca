/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.ServerException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mylena
 */
public class Controller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tarefa = req.getParameter("tarefa");
        
        if(tarefa==null) {
            throw new IllegalArgumentException("Você esqueceu de passar a tarefa!");
        }

        tarefa = "SERVLET." + tarefa;
       
        String metodo = req.getParameter("metodo");
        
        if(metodo==null)
        {
            try {
                Class<?> tipo = Class.forName(tarefa);
                Tarefa instancia = (Tarefa) tipo.newInstance();

                
                String pagina = instancia.executa(req, resp);
                this.redireciona(pagina, req, resp);
                

            } catch (ClassNotFoundException | InstantiationException | 
                    IllegalAccessException | ServletException | IOException e) {
                throw new ServletException(e);
            }
        }
        
        else {
            try {

                Class<?> classe = Class.forName(tarefa);
                Method method = classe.getDeclaredMethod(metodo, HttpServletRequest.class, HttpServletResponse.class);
                String pagina = (String) method.invoke(classe.newInstance(), req, resp);
                this.redireciona(pagina, req, resp);

            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException 
                    | IllegalArgumentException  | InvocationTargetException | InstantiationException e) {
                throw new ServletException(e);
            }
            
        }
    }
    
    private void redireciona(String pagina, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
        requestDispatcher.forward(req, resp);
    }
}

    
