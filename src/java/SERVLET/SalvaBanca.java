package SERVLET;

import DAO.BancaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BEAN.Banca;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mylena
 */
public class SalvaBanca implements Tarefa {

    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Banca banca = new Banca();
            

            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  //formato da data
            String data = req.getParameter("dt_nasc"); //recebe a data da requisição (ex.: 2015-12-31)
            java.util.Date Data = null; //cria uma data nula
            Data = sdf.parse(data); //altera o formato da data
            
            //seta os dados da pessoa
            banca.setData(Data);
            banca.setHora(Time.valueOf(req.getParameter("hora")));
            banca.setResumo(req.getParameter("resumo"));
            banca.setTema(req.getParameter("tema"));
            banca.setCurso(req.getParameter("curso"));

            //adiciona a nova pessoa
            BancaDAO dao = new BancaDAO();
            if (dao.Cadastro(banca)) { //verifica se foi cadastrado com sucesso
                req.setAttribute("banca", banca); //cria um atributo para a saída de sucesso
            } else {
                System.out.println(">>>>> deu ruim");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "/paginas/listbanca.jsp";
    }
}
