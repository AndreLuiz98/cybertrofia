package br.ifpb.edu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import br.ifpb.edu.entidades.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		PessoaDAO pessoadao = new PessoaDAO();

		List<Pessoa> pessoalista = (List<Pessoa>) pessoadao.getAll();

		if (pessoalista != null && !pessoalista.isEmpty()) {


			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");

			for (Pessoa pessoa: pessoalista) {
				if (pessoa.getNome().equals(nome)
						&& pessoa.getSenha().equals(senha)){


					RequestDispatcher rq = request.getRequestDispatcher(
							"index.html");
					rq.forward(request, response);
				}
			}

			response.sendRedirect("index.html");

		}else {


			response.sendRedirect("index.html");
		}




	}

}
