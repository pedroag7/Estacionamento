package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import model.bean.Motorista;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MotoristaDAO {
    
     public void create (Motorista m){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            try{
                stmt = con.prepareStatement("INSERT INTO motorista (nome, genero, rg, cpf, celular, email, senha)  VALUES (?,?,?,?,?,?,?)") ;
                stmt.setString(1, m.getNome());
                stmt.setString(2, m.getGenero());
                stmt.setInt(3, m.getRg());
                stmt.setInt(4, m.getCpf());
                stmt.setInt(5, m.getCelular());
                stmt.setString (6, m.getEmail());
                stmt.setString (7, m.getSenha());
                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Motorista Cadastrado com sucesso!");
                
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
            
        }
}
