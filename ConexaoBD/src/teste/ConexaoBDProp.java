package teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConexaoBDProp {
	
	public static void main(String args[]) {
		Properties proBD = new Properties();
		FileInputStream leitorArquivo;
		
		try {
			leitorArquivo = new FileInputStream("src/teste/ConexaoBD.properties");
			proBD.load(leitorArquivo);
			leitorArquivo.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null, "Configurações não encontradas - " + fnfe.getMessage());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao ler configurações - " + ex.getMessage());
		}
		
		Connection conexao;
		String url = proBD.getProperty("url");
		
		try {
			Class.forName(proBD.getProperty("driver"));
			conexao = DriverManager.getConnection(url, proBD.getProperty("usuario"), proBD.getProperty("senha"));
			JOptionPane.showMessageDialog(null, "Conexão Estabelecida");
			conexao.close();
		} catch (ClassNotFoundException cnf) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado - " + cnf.getMessage());
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Banco não conectado - " + sqle.getMessage());
		} 
	}
	
}
