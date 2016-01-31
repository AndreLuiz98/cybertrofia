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

		List<Pessoa> imcs = (List<Pessoa>) session.getAttribute("imcs");

		if (imcs == null) {			
			imcs = new ArrayList<Pessoa>();		
		} 

		String alturaString = request.getParameter("altura");
		String pesoString = request.getParameter("peso");

		double alturaDouble = Double.parseDouble(alturaString);
		double pesoDouble = Double.parseDouble(pesoString);

		double calcIMC = pesoDouble / (alturaDouble * alturaDouble);

		Pessoa pessoa = new Pessoa();
		pessoa.setImc(calcIMC);

		imcs.add(pessoa);

		session.setAttribute("imcs", imcs);

		response.sendRedirect("resultadoIMC.jsp");

	}

}
