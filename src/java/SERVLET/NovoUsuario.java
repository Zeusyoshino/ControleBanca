package SERVLET;

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
        return "/paginas/caduser.jsp";
    }

    
    
   
}
