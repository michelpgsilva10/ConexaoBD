package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AplicacaoCreate {

	public static void main(String[] args) {
		Connection conexao = AplicacaoIncluir1.obterConexao();
		Statement comando = null;
        String sql="CREATE TABLE teste (codigo SERIAL PRIMARY KEY, nome CHAR(40))";
		
		try{
			comando = conexao.createStatement();
			comando.execute(sql);
			JOptionPane.showMessageDialog(null,"Instrução executada com sucesso");
			
			
		} catch(SQLException ex){
			
			JOptionPane.showMessageDialog(null, "Erro na execução da instrução!!!");
		}
	}
}
