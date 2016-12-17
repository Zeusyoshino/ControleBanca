package SERVLET;

import DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BEAN.Usuario;

/**
 *
 * @author Mylena
 */
public class NovaBanca implements Tarefa {
    
       
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            usuarios = new UsuarioDAO().buscaSimilar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("integrantes", usuarios);
        return "/paginas/cadbanca.jsp";
    }

    
    
   
}
