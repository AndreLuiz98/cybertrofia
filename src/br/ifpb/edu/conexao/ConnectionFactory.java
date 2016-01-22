package br.ifpb.edu.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {

	public Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/pessoa","root","");
		} catch (SQLException e) {
			System.out.println("erro de conexao");
			throw new RuntimeException(e);
		}
	}
}


