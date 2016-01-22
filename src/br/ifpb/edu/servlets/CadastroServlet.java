package br.ifpb.edu.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.ifpb.edu.conexao.*;
import br.ifpb.edu.servlets.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ifpb.edu.entidades.*;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Pessoa pessoa = new Pessoa ();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setEmail(request.getParameter("email"));
		pessoa.setSenha(request.getParameter("senha"));
		
		try {
			
			pessoaDAO.insert(pessoa);
			pessoaDAO.disconnect();
			
		} catch (SQLException e) {
			
			System.out.println("Erro");
		}
		
		response.sendRedirect("index.html");
	}

}
