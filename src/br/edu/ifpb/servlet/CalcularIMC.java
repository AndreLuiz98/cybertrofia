
package br.edu.ifpb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.entidade.Pessoa;

@WebServlet("/CalcularIMC")
public class CalcularIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		List<Pessoa> pessoas = (List<Pessoa>) session.getAttribute("pessoas");

		if (pessoas == null) {			
			pessoas = new ArrayList<Pessoa>();		
		} 

		Double alturaDouble = Double.parseDouble(request.getParameter("altura"));
		Double pesoDouble = Double.parseDouble(request.getParameter("peso"));

		Double resultadocalcIMC = pesoDouble / (alturaDouble * alturaDouble);

		Pessoa pessoa = new Pessoa();
		pessoa.setImc(resultadocalcIMC);

		pessoas.add(pessoa);

		session.setAttribute("pessoas", pessoas);
		
		RequestDispatcher rq = request.getRequestDispatcher("resultadoIMC.jsp");
		rq.forward(request, response);

	}

}
