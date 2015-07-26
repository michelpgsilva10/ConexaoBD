package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AplicacaoAlterar1 {

public static void main(String[] args) {
	Connection conexao = AplicacaoIncluir1.obterConexao();
	PreparedStatement comando = null;
	
	float promocao = 20;
	float margem = 30;
	int codigo = 8;
	try{
		comando = conexao.prepareStatement("UPDATE grupoproduto SET promocao = ?, margemlucro =? WHERE codigo=?");
		comando.setFloat(1, promocao);
		comando.setFloat(2, margem);
		comando.setInt(3, codigo);
		comando.executeUpdate();
		JOptionPane.showMessageDialog(null, "Alteracao realizada com sucesso!!!");
	} catch(SQLException ex){
		JOptionPane.showMessageDialog(null, "Erro na Alteração!!!");
	}
}
}
