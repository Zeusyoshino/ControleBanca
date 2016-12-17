/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.BancaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zeus
 */
public class ListaBanca implements Tarefa{
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        ArrayList<BEAN.Banca> bancas = new ArrayList();
        try {
            bancas = new BancaDAO().buscaSimilar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaBanca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaBanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("bancas", bancas);
        return "/paginas/listbanca.jsp";
    }
}
