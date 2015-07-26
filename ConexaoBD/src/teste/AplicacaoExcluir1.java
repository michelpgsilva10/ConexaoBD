package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AplicacaoExcluir1 {

public static void main(String[] args) {
	Connection conexao = AplicacaoIncluir1.obterConexao();
	PreparedStatement comando = null;

	int codigo = 4;
	try{
		comando = conexao.prepareStatement("DELETE FROM grupoproduto WHERE codigo = ?");
		comando.setInt(1, codigo);
		
		int cont = comando.executeUpdate();
		JOptionPane.showMessageDialog(null, "Excluido realizada com sucesso!!!["+cont+" excluido]");
	} catch(SQLException ex){
		
		JOptionPane.showMessageDialog(null, "Erro na Exclusão!!!");
	}
}

}
