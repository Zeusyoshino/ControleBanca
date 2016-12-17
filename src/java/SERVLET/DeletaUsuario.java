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
public class DeletaUsuario implements Tarefa {

    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Usuario usu = new Usuario();

            //seta os dados da pessoa
            usu.setId(Integer.parseInt(req.getParameter("id")));

            System.out.println("\nAqui <<<<<\n");
            //adiciona a nova pessoa
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.delete(usu)) { //verifica se foi cadastrado com sucesso
                req.setAttribute("usuario", usu); //cria um atributo para a saída de sucesso
                System.out.println("Mylena");
            } else {
                System.out.println(">>>>> deu ruim");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "/paginas/listuser.jsp";
    }
}
