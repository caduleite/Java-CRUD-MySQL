
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    
    public Connection conexaoMySql(){
        
        // Atributo
        Connection conexao = null;
        
        // Execução
        try{
                String url = "jdbc:mysql://localhost:3306/java?user=root&password=root";
                conexao = DriverManager.getConnection(url);
            } 
        catch (SQLException erro){
            
                JOptionPane.showMessageDialog(null,"ConexaoDAO: " + erro.getMessage());
            }
        return conexao;
    }    
}
