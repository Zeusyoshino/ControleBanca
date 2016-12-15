/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import BEAN.Usuario;
import DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mylena
 */
public class NovoUsuario implements Tarefa {

    
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Usuario usuario = new Usuario(req.getParameter("usuario"));
        try {
            try {
                new UsuarioDAO().adiciona(usuario);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("usuario", usuario);
        return "/paginas/caduser.jsp";
    }

    
    
   
}
