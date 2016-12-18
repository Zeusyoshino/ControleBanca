/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Usuario;
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
public class UsuarioDAO {

    private static Connection connection;

    public UsuarioDAO() throws ClassNotFoundException {
        UsuarioDAO.connection = ConnectionFactory.getConnection();
    }

    public Usuario buscaPorEmailESenha(String email, String senha) throws SQLException {
        if (email == null || senha == null) {
            return null;
        }
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE usua_email = '" + email + "'");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario(rs.getInt("usua_id"), rs.getString("usua_nome"), rs.getString("usua_email"), rs.getString("usua_senha"), rs.getString("usua_celular"), rs.getInt("usua_na"), rs.getInt("usua_status"));
            if (usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        rs.close();
        stmt.close();
        return null;
    }

    public ArrayList<Usuario> buscaSimilar() throws SQLException {
        ArrayList<Usuario> similares = new ArrayList<Usuario>();
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE usua_status = 1");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario obj = new Usuario(rs.getInt("usua_id"), rs.getString("usua_nome"), rs.getString("usua_email"), rs.getString("usua_senha"), rs.getString("usua_celular"), rs.getInt("usua_na"), rs.getInt("usua_status"));
            obj.setId(rs.getInt("usua_id"));
            obj.setNome(rs.getString("usua_nome"));
            obj.setEmail(rs.getString("usua_email"));
            obj.setSenha(rs.getString("usua_senha"));
            obj.setCelular(rs.getString("usua_celular"));
            obj.setNivelacesso(rs.getInt("usua_na"));
            obj.setStatus(rs.getInt("usua_status"));

            similares.add(obj);
        }
        rs.close();
        stmt.close();
        return similares;
    }
    
    public ArrayList<Usuario> buscaUsuario(int idUsu) throws SQLException {
        ArrayList<Usuario> similares = new ArrayList<Usuario>();
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE usua_id = " + idUsu);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario obj = new Usuario(rs.getInt("usua_id"), 
                    rs.getString("usua_nome"), 
                    rs.getString("usua_email"), 
                    rs.getString("usua_senha"), 
                    rs.getString("usua_celular"), 
                    rs.getInt("usua_na"), 
                    rs.getInt("usua_status"));


            similares.add(obj);
        }
        rs.close();
        stmt.close();
        return similares;
    }


    public boolean Cadastro(Usuario usuario) throws SQLException {
        boolean salvo = false;
        
        usuario.setStatus(1);
        
        PreparedStatement ps = this.connection.prepareStatement("insert into usuario (usua_nome, usua_email, usua_senha, usua_celular, usua_na, usua_status) values (?,?,?,?,?,?)");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getCelular());
        ps.setInt(5, usuario.getNivelacesso());
        ps.setInt(6, usuario.getStatus());

        if (ps.executeUpdate() > 0) {
            salvo = true;
        }
        return salvo;
    }
    
    public boolean edita(Usuario usuario) throws SQLException {
        boolean salvo = false;
        
        usuario.setStatus(1);
        
        String sql = "UPDATE usuario "
                + "SET usua_nome = ?, "
                + "usua_email = ?, "
                + "usua_senha = ?, "
                + "usua_celular = ?, "
                + "usua_na = ? "
                + "WHERE usua_id = ?;";
        
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getCelular());
        ps.setInt(5, usuario.getNivelacesso());
        ps.setInt(6, usuario.getId());

        if (ps.executeUpdate() > 0) {
            salvo = true;
        }
        return salvo;
    }
    
    public boolean delete(Usuario usuario) throws SQLException {
        boolean salvo = false;
        
        usuario.setStatus(1);
        
        String sql = "UPDATE usuario "
                + "SET usua_status = 0 "
                + "WHERE usua_id = ?;";
        
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, usuario.getId());

        if (ps.executeUpdate() > 0) {
            salvo = true;
        }
        return salvo;
    }

    public void salvarUsuarioDAO(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
