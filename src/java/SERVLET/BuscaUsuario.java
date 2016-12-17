package SERVLET;

import DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BEAN.Usuario;
import java.util.Collection;

/**
 *
 * @author Mylena
 */
public class BuscaUsuario implements Tarefa {

    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        int idUsu = Integer.parseInt(req.getParameter("id"));
        Collection<Usuario> usuario;
        try {
            usuario = new UsuarioDAO().buscaUsuario(idUsu);
            req.setAttribute("usu", usuario);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/paginas/edituser.jsp";
    }
}
