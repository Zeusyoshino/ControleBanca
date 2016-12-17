/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Banca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang3.BooleanUtils;

/**
 *
 * @author Mylena
 */
public class BancaDAO {

    private static Connection connection;

    public BancaDAO() throws ClassNotFoundException {
        BancaDAO.connection = ConnectionFactory.getConnection();
    }

    

    public ArrayList<Banca> buscaSimilar() throws SQLException {
        ArrayList<Banca> similares = new ArrayList<Banca>();
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM banca");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Banca obj = new Banca();
            obj.setId(rs.getInt("banc_id"));
            obj.setData(rs.getDate("banc_data"));
            obj.setHora(rs.getTime("banc_hora"));
            obj.setTema(rs.getString("banc_tema"));
            obj.setCurso(rs.getString("banc_curso"));
            obj.setResumo(rs.getString("banc_resumo"));

            similares.add(obj);
        }
        rs.close();
        stmt.close();
        return similares;
    }
    
    
        public boolean Cadastro(Banca banca) throws SQLException {
        boolean salvo = false;
                
        PreparedStatement ps = this.connection.prepareStatement("insert into banca (banc_data, banc_hora, banc_resumo, banc_tema, banc_curso) values (?,?,?,?,?)");
        ps.setDate(1, new java.sql.Date(banca.getData().getTime()));
        ps.setTime(2,  new java.sql.Time(banca.getHora().getTime()));
        ps.setString(3, banca.getResumo());
        ps.setString(4, banca.getTema());
        ps.setString(5, banca.getCurso());
        

        if (ps.executeUpdate() > 0) {
            salvo = true;
        }
        return salvo;
    }
}
