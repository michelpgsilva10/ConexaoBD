package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBD {

	public static void main(String args[]) {
		Connection conexao;
		String url = "jdbc:postgresql://192.168.201.77:5432/grupo4";

		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, "grupo4", "grupo4");
			JOptionPane.showMessageDialog(null, "Conexão estabelecida");
			conexao.close();
		} catch (ClassNotFoundException cnf) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado - " + cnf.getMessage());
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Banco não encontrado - " + sqle.getMessage());
		}
	}

}
