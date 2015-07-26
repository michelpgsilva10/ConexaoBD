package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AplicacaoIncluir2 {
	
public static void main(String[] args) {
	Connection conexao = AplicacaoIncluir1.obterConexao();
	PreparedStatement comando = null;
	String nome = "Refrigerantes";
	float promocao = 0;
	float margem = 50;
	try{
		comando = conexao.prepareStatement("INSERT INTO GRUPOPRODUTO(NOME, PROMOCAO, MARGEMLUCRO) VALUES (?,?,?)");
		comando.setString(1, nome);
		comando.setFloat(2, promocao);
		comando.setFloat(3, margem);
		comando.executeUpdate();
		JOptionPane.showMessageDialog(null, "Inclusão realizada com sucesso!!!");
	} catch(SQLException ex){
		JOptionPane.showMessageDialog(null, "Erro na Inclusão!!!");
	}
}
}
