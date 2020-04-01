package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.servlet.modelli.Prodotto;
import it.dstech.servlet.repos.DBManagment;

public class AzioniMagazzino extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		System.out.println(azione);
		 if ("aggiungi prodotto".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Prodotto> lista = db.getAll();
				req.setAttribute("lista", lista);
			req.getRequestDispatcher("creaProdotto.jsp").forward(req, resp);
} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		} else if ("stampa prodotti".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Prodotto> lista = db.getAll();
				req.setAttribute("lista", lista);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			req.getRequestDispatcher("stampa.jsp").forward(req, resp);
		
		}else if ("stampa vendite".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Prodotto> lista = db.creaListaVendite();
				req.setAttribute("lista", lista);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			req.getRequestDispatcher("stampaVendite.jsp").forward(req, resp);

	}else if ("rimuovi prodotto".equalsIgnoreCase(azione)) {
		try {
			DBManagment db = new DBManagment();
			List<Prodotto> lista = db.getAll();
			req.setAttribute("lista", lista);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
req.getRequestDispatcher("rimuoviProdotto.jsp").forward(req, resp);
}else if ("modifica prodotto".equalsIgnoreCase(azione)) {
	try {
		DBManagment db = new DBManagment();
		List<Prodotto> lista = db.getAll();
		req.setAttribute("lista", lista);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
req.getRequestDispatcher("modificaProdotto.jsp").forward(req, resp);
}
	}}



