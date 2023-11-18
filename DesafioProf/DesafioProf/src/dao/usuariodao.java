package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import dto.UsuarioDto;
import desafioprof.ConexaoDao;
import javax.swing.JOptionPane;

public class usuariodao {
    Connection conn;
    
    public ResultSet autenticacaoUsuario(UsuarioDto objusuariodto) {
        conn = new ConexaoDao().conectaDB();
        
        try {
            String sql = "SELECT * FROM usuario WHERE nome = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome());
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
