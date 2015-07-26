package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AplicacaoSelecao1 {
	
	public static void main(String[] args) {
		Connection conexao = AplicacaoIncluir1.obterConexao();
		PreparedStatement comando = null;

		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o código a ser pesquisado"));
		try{
			comando = conexao.prepareStatement("SELECT * FROM grupoproduto WHERE codigo = ?");
			comando.setInt(1, codigo);
			
		  ResultSet resultado = comando.executeQuery();
		  
		  if(resultado.next()){
			  JOptionPane.showMessageDialog(null, "Encontrado: "+resultado.getString("nome"));
		  }else{
			  JOptionPane.showMessageDialog(null, "Não encontrado");
		  }
			
		} catch(SQLException ex){
			
			JOptionPane.showMessageDialog(null, "Erro na Busca!!!");
		}
	}

}
