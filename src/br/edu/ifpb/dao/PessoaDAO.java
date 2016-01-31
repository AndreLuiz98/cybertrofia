package br.edu.ifpb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.edu.ifpb.entidade.Pessoa;

public class PessoaDAO implements GenericDAO <String, Pessoa>{

	static ConnectionFactory banco;

	public Connection connection;

	private static PessoaDAO instance;

	public static PessoaDAO getInstance() {

		banco = ConnectionFactory.getInstance();

		instance = new PessoaDAO(banco);

		return instance;

	}

	public PessoaDAO(ConnectionFactory banco) {

		this.connection = (Connection) banco.getConnection();

	}

	@Override
	public int insert(Pessoa pessoa) throws SQLException {

		Integer id = BancoUtil.IDVAZIO;

		try {

			String sql = "INSERT INTO tb_pessoa ("
					+ " NOME,"
					+ " EMAIL,"
					+ " SENHA)"
					+ " VALUES (?, ?, ?)";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getSenha());

			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			// Cadastra e recuperar identifica��o da Pessoa.
			id = BancoUtil.getGenerateKey(stmt);

		} catch (SQLException e) {

			connection.close();	
		}

		return id;
	}

	@Override
	public Pessoa getById(String nome) throws SQLException {


		Pessoa pessoa = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT *"
					+ "	FROM tb_pessoa AS pessoa"
					+ " WHERE pessoa.NOME = " 
					+ nome;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Pessoa> pessoas = convertToList(rs);

			if (!pessoas.isEmpty())

				pessoa = pessoas.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return pessoa;
	}

	private List<Pessoa> convertToList(ResultSet rs) throws SQLException {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {

			while (rs.next()) {

				// Pessoa
				Pessoa pessoa = new Pessoa();

				pessoa.setNome(rs.getString("pessoa.NOME"));
				pessoa.setEmail(rs.getString("pessoa.EMAIL"));
				pessoa.setSenha(rs.getString("pessoa.SENHA"));

				pessoas.add(pessoa);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return pessoas;
	}
	
	public boolean authenticateLogin(String email, String senha) throws SQLException{
		
		boolean isValid = false;
		
		try {			

			String sql = "SELECT *"
					+ "	FROM tb_pessoa AS pessoa"
					+ " WHERE pessoa.EMAIL = ?"
					+ " and pessoa.SENHA = ?";
			
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, email);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				
				isValid = true; 
				
			}
			
		} catch(SQLException sqle) {
			
			throw sqle;
			
		} finally {

			connection.close();
		}

		return isValid;
	}

	@Override
	public void update(Pessoa pessoa) throws SQLException {

	}

	@Override
	public List<Pessoa> getAll() throws SQLException {

		return null;

	}

	@Override
	public List<Pessoa> find(Pessoa pessoa) throws SQLException {

		return null;

	}

	@Override
	public int delete(String pk) throws SQLException {

		return 0;

	}

}
