package DAO;

import DTO.AlunoDTO;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class AlunoDAO {
    
    // Atributo
    Connection conexao;
    PreparedStatement pstm;
    ResultSet retornoSQL;
    ArrayList<AlunoDTO> lista = new ArrayList<>();
    
    
    // Método
    public ArrayList<AlunoDTO> listaAluno(){
      
        // Conexão c/BD
        conexao = new ConexaoDAO().conexaoMySql();
        
        // Senteça SQL
        String comandoSQL = "SELECT * FROM ALUNO";
        
        // Execução
        try{
                // Atributo
                pstm = conexao.prepareStatement(comandoSQL);
                retornoSQL = pstm.executeQuery();
                
                // Repetição
                while(retornoSQL.next()){
                    AlunoDTO objAlunoDTO = new AlunoDTO();
                    objAlunoDTO.setMatricula(retornoSQL.getInt("MATRICULA"));
                    objAlunoDTO.setNome(retornoSQL.getString("NOME"));
                    objAlunoDTO.setEmail(retornoSQL.getString("EMAIL"));
                    objAlunoDTO.setSenha(retornoSQL.getString("SENHA"));
                    
                    // Registro do BD - Lista
                    lista.add(objAlunoDTO);
                }                
            } 
        catch (SQLException erro)
            {
                // Classe
                JOptionPane.showMessageDialog(null,"Classe AlunoDAO: " + erro);
            }  
      
      // Saida 
      return lista;
      
  }
    
    
    // Método
    public void inserirAluno(AlunoDTO objAlunoDTO){
        
        // Conexão c/BD
        conexao = new ConexaoDAO().conexaoMySql();
        
        // Senteça SQL
        String comandoSQL = "INSERT INTO ALUNO (NOME,EMAIL,SENHA) VALUES (?,?,?)";
        
        // Execução
        try{
                
                // Atributo
                pstm = conexao.prepareStatement(comandoSQL);
                
                // Método
                pstm.setString(1,objAlunoDTO.getNome());
                pstm.setString(2,objAlunoDTO.getEmail());
                pstm.setString(3,objAlunoDTO.getSenha());
                
                // Execução SQL
                pstm.execute();
                pstm.close();
                
                // Saida
                JOptionPane.showMessageDialog(null,"# Aluno Adicionado c/Sucesso!!!","# Sistema CRUD",JOptionPane.INFORMATION_MESSAGE );
            } 
        catch (SQLException erro)
            {
                // Classe
                JOptionPane.showMessageDialog(null,"Classe AlunoDAO: " + erro);
                
            }  
    }
       
    public void editarAluno (AlunoDTO objAlunoDTO){
        // Conexão c/BD
        conexao = new ConexaoDAO().conexaoMySql();
        
        // Senteça SQL
        String comandoSQL = "UPDATE ALUNO SET NOME = ?,EMAIL = ?,SENHA = ? WHERE MATRICULA = ?";

        // Execução
        try{
                
                // Atributo
                pstm = conexao.prepareStatement(comandoSQL);
                
                // Método
                pstm.setString(1,objAlunoDTO.getNome());
                pstm.setString(2,objAlunoDTO.getEmail());
                pstm.setString(3,objAlunoDTO.getSenha());
                pstm.setInt(4,objAlunoDTO.getMatricula());
                
                // Execução SQL
                pstm.execute();
                pstm.close();
                
                // Saida
                JOptionPane.showMessageDialog(null,"# Aluno Editado c/Sucesso!!!","# Sistema CRUD",JOptionPane.INFORMATION_MESSAGE );
            } 
        catch (SQLException erro)
            {
                // Classe
                JOptionPane.showMessageDialog(null,"Classe AlunoDAO Editar: " + erro);
                
            }       
    }
    
     public void excluirAluno (AlunoDTO objAlunoDTO){

        // Conexão c/BD
        conexao = new ConexaoDAO().conexaoMySql();
        
        // Senteça SQL
        String comandoSQL = "DELETE FROM ALUNO WHERE MATRICULA = ?";
        // Execução
        try{
                
                // Atributo
                pstm = conexao.prepareStatement(comandoSQL);
                
                // Método
                pstm.setInt(1,objAlunoDTO.getMatricula());
                
                // Execução SQL
                pstm.execute();
                pstm.close();
                
                // Saida
                JOptionPane.showMessageDialog(null,"# Aluno Excluído c/Sucesso!!!","# Sistema CRUD",JOptionPane.INFORMATION_MESSAGE );
            } 
        catch (SQLException erro)
            {
                // Classe
                JOptionPane.showMessageDialog(null,"Classe AlunoDAO Excluir: " + erro);
                
            }                
     }
}
