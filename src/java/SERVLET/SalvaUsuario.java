package SERVLET;

import DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BEAN.Usuario;

/**
 *
 * @author Mylena
 */
public class SalvaUsuario implements Tarefa {

    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Usuario usu = new Usuario();

            //seta os dados da pessoa
            usu.setNome(req.getParameter("nome"));
            usu.setEmail(req.getParameter("email"));
            usu.setSenha(req.getParameter("senha"));
            usu.setCelular(req.getParameter("celular"));
            usu.setNivelacesso(Integer.parseInt(req.getParameter("nivel")));

            //adiciona a nova pessoa
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.Cadastro(usu)) { //verifica se foi cadastrado com sucesso
                req.setAttribute("usuario", usu); //cria um atributo para a saída de sucesso
                
            } else {
                System.out.println(">>>>> deu ruim");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "/paginas/caduser.jsp";
    }
}
