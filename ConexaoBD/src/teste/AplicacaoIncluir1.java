package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AplicacaoIncluir1 {

	public static Connection obterConexao() {
		Connection conexao = null;
		String url = "jdbc:postgresql://192.168.201.77:5432/grupo4";

		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, "grupo4", "grupo4");
			JOptionPane.showMessageDialog(null, "Conex�o estabelecida"); 
		} catch (ClassNotFoundException cnf) {
			JOptionPane.showMessageDialog(null, "Driver n�o encontrado - " + cnf.getMessage());
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Banco n�o encontrado - " + sqle.getMessage());
		}

		return conexao;
	}
	
	public static void main(String args[]) {
		Connection conexao = obterConexao();
		Statement comando = null;
		String sql = "INSERT INTO GRUPOPRODUTO(NOME, PROMOCAO, MARGEMLUCRO) VALUES ";
		String nome = "Bebidas Detox";
		float promocao = 20;
		float margem = 60;
		sql += "('" + nome + "', " + promocao + ", " + margem + ")";
		
		System.out.println(sql);
		
		try {
			comando = conexao.createStatement();
			comando.execute(sql);
			JOptionPane.showMessageDialog(null, "Inclus�o realizada com sucesso");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao incluir grupo de produto " + ex.toString());
		} finally {
			try {
				comando.close();
				conexao.close();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Erro ao desconectar - " + ex.toString());
			}
		}
	}

}
