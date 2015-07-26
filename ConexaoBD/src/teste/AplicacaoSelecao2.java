package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AplicacaoSelecao2 {
	
	public static void main(String[] args) {
		Connection conexao = AplicacaoIncluir1.obterConexao();
		PreparedStatement comando = null;

		
		try{
			comando = conexao.prepareStatement("SELECT * FROM grupoproduto ORDER BY nome");
			
		  ResultSet resultado = comando.executeQuery();
		  
		  while(resultado.next()){
			 
			  System.out.println("Codigo: "+resultado.getInt("codigo") );
			  System.out.println("Nome: "+resultado.getString("nome") );
			  System.out.println("% Promoção: "+resultado.getFloat("promocao") );
			  System.out.println("% Margem lucro: "+resultado.getFloat("margemlucro") );
			  System.out.println("_______________________________________________________");
		  }
		  resultado.close();
			
		} catch(SQLException ex){
			
			JOptionPane.showMessageDialog(null, "Erro na Busca!!!");
		}
	}

}
