package DAO;

import DTO.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


public class UsuarioDAO {
    
    // Atributo
    Connection conexao;
    
    // Método
    public ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDTO){
        
        // Conexão c/BD
        conexao = new ConexaoDAO().conexaoMySql();
        
        // Execução
        try{
                // Senteça SQL
                String comandoSQL = "SELECT * FROM ALUNO WHERE EMAIL = ? AND SENHA = ?";
                
                // Classe - Objeto
                PreparedStatement pstm = conexao.prepareStatement(comandoSQL);
                
                // Método
                pstm.setString(1,objUsuarioDTO.getEmail());
                pstm.setString(2,objUsuarioDTO.getSenha());
                
                // Execução SQL
                ResultSet execucaoSQL = pstm.executeQuery();
                
                // Saida
                return execucaoSQL;
            } 
        catch (SQLException erro)
            {
                // Classe
                JOptionPane.showMessageDialog(null,"Classe ConexaoDAO: " + erro);
                
                // Saida
                return null;
            }  
    }
}
