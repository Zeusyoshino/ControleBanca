/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import BEAN.Usuario;
import DAO.UsuarioDAO;
import SERVLET.Tarefa;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Mylena
 */
public class ListaUsuario implements Tarefa{
    
    
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Collection<Usuario> usuarios = null;
        try {
            usuarios = new UsuarioDAO().buscaSimilar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("usuario", usuarios);
        return "/paginas/listuser.jsp";
    }

    
    
}
