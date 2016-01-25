package br.ifpb.edu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcularIMC")
public class CalcularIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String pesoKG = request.getParameter("peso");
		double peso = Double.parseDouble(pesoKG);
		
		String AlturaCM = request.getParameter("altura");
		double altura = Double.parseDouble(AlturaCM);
		
		double alturaConversao = altura * 0.01;
		
		
		RequestDispatcher rq = request.getRequestDispatcher(
				"resultadoIMC.jsp");
		rq.forward(request, response);
		
	}

}
