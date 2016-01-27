package br.edu.ifpb.servlet;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.dao.PessoaDAO;
import br.edu.ifpb.entidade.Pessoa;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome(request.getParameter("nome"));
			pessoa.setEmail(request.getParameter("email"));
			pessoa.setSenha(request.getParameter("senha"));
			
				
			PessoaDAO.getInstance().insert(pessoa);		

			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			pessoas.add(pessoa);
			

			request.setAttribute("pessoas", pessoas);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		RequestDispatcher rq = request.getRequestDispatcher("index.html");
		rq.forward(request, response);
	}
}


