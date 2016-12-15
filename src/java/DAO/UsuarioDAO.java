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
    
    public UsuarioDAO() throws ClassNotFoundException{
        UsuarioDAO.connection = ConnectionFactory.getConnection();
    }
			
    public Usuario buscaPorEmailESenha(String email, String senha) throws SQLException {
        if (email == null || senha == null){
            return null;
        }
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE usua_email = '" + email + "'");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Usuario usuario = new Usuario(rs.getInt("usua_id"), rs.getString("usua_nome"), rs.getString("usua_email"), rs.getString("usua_senha"), rs.getString("usua_celular"),rs.getInt("usua_na"), BooleanUtils.toBoolean(rs.getInt("usua_status")));
            if (usuario.getSenha().equals(senha))
                return usuario;
        }  
        rs.close();
        stmt.close();
        return null;
    }
    
    public Collection<Usuario> buscaSimilar() throws SQLException {
        List<Usuario> similares = new ArrayList<>();
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("usua_id");
            String nome = rs.getString("usua_nome");
            String email = rs.getString("usua_email");
            String senha = rs.getString("usua_senha");
            String celular = rs.getString("usua_celular");
            int nivelacesso = rs.getInt("usua_na");
            Boolean status = rs.getBoolean("usua_status");
            Usuario usuario = new Usuario(id, nome, email, senha, celular, nivelacesso, status);
            similares.add(usuario);
        }
        rs.close();
        stmt.close();
        return similares;
    }
    
    public static void adiciona(Usuario usuario) throws SQLException {
        String sql = "insert into usuario (usua_nome, usua_email, usua_senha, usua_celular, usua_na, usua_status) values (?,?,?,?,?,?,1)";
        System.out.println("O sql é " + sql);
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.setString(4, usuario.getCelular());
        stmt.setInt(5, usuario.getNivelacesso());
        stmt.execute();
        stmt.close();
    }
}
