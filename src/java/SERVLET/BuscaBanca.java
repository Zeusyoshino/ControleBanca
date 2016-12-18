/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import BEAN.Banca;
import DAO.BancaDAO;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zeus
 */
public class BuscaBanca implements Tarefa {
    
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        int idBanca = Integer.parseInt(req.getParameter("id"));
        Collection<Banca> banca;
        try {
            banca = new BancaDAO().buscaBanca(idBanca);
            req.setAttribute("banca", banca);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscaBanca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaBanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/paginas/editbanca.jsp";
    }
}
