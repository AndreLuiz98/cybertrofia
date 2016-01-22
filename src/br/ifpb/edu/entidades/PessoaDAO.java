package br.ifpb.edu.entidades;

import java.sql.*;

import br.ifpb.edu.conexao.*;

public class PessoaDAO {
	private Connection connection;

	public PessoaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insert (Pessoa pessoa) throws SQLException {
		try{
			Connection connection = new ConnectionFactory().getConnection();
		} catch (RuntimeException e){
			System.out.println("Erro de Conexão");
			return false;

		}
		String sql = "insert into tb_pessoa " +
				"(NOME,EMAIL,SENHA)" +
				" values (?,?,?);";

		try {


			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1,pessoa.getNome());
			stmt.setString(2,pessoa.getEmail());
			stmt.setString(3,pessoa.getSenha());

			stmt.execute();
			stmt.close();


		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return true;
	}
	  public void disconnect() throws SQLException {
			this.connection.close();	
	  }
	
}
