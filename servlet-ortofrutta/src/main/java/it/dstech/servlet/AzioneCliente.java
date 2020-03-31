package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.servlet.modelli.Prodotto;
import it.dstech.servlet.modelli.Scontrino;
import it.dstech.servlet.repos.DBManagment;

public class AzioneCliente extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		int id = Integer.parseInt(req.getParameter("idCliente2"));
		System.out.println(azione);
		System.out.println(id);
		if ("compra".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Prodotto> lista = db.getAll();
				req.setAttribute("lista", lista);
                int costoTotale=0;
				req.setAttribute("costoTotale",costoTotale );
				List<Prodotto> carrello = db.stampaCarrello();
				req.setAttribute("carrello", carrello);
				req.setAttribute("idCliente", id);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			req.getRequestDispatcher("compraProdotto.jsp").forward(req, resp);
		} else if ("stampa".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Scontrino> lista = db.scontriniCliente(id);
				req.setAttribute("lista", lista);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			req.getRequestDispatcher("stampaScontriniCliente.jsp").forward(req, resp);
		}	

}}
