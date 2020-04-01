package it.dstech.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SceltaAzione extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		System.out.println(azione);
		if ("azioni magazzino".equalsIgnoreCase(azione)) {
			
			req.getRequestDispatcher("azioniMagazzino.jsp").forward(req, resp);

		}
		
else if ("Azioni Cliente".equalsIgnoreCase(azione)) {
	
req.getRequestDispatcher("azioniCliente.jsp").forward(req, resp);
		}
	}}
