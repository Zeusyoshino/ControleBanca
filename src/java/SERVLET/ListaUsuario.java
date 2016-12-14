/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import BEAN.Usuario;
import DAO.UsuarioDAO;
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
public class ListaUsuario {
    
    
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String filtro = req.getParameter("filtro");
        Collection<Usuario> usuarios = null;
        try {
            usuarios = new UsuarioDAO().buscaSimilar(filtro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("usuario", usuarios);
        return "/WEB-INF/paginas/listuser.jsp";
    }

    
    
}
