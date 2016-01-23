package br.ifpb.edu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifpb.edu.entidades.*;
@WebServlet("/InserirBD")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			
			Pessoa pessoa = new Pessoa ();
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			
			pessoa.setNome(request.getParameter("nome"));
			pessoa.setEmail(request.getParameter("email"));
			pessoa.setSenha(request.getParameter("senha"));
			
			
			pessoaDAO.insert(pessoa);
			
			response.sendRedirect("index.html");
		}

	
	}


