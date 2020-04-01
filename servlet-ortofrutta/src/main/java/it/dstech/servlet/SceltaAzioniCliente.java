package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.servlet.modelli.Cliente;
import it.dstech.servlet.repos.DBManagment;

public class SceltaAzioniCliente extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		System.out.println(azione);
		if ("accedi".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Cliente> listaClienti =db.listaClienti();
				req.setAttribute("lista", listaClienti);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	req.getRequestDispatcher("scegliCliente.jsp").forward(req, resp);
		} else if ("aggiungi Cliente".equalsIgnoreCase(azione)) {
			try {
				DBManagment db = new DBManagment();
				List<Cliente> lista =  db.listaClienti();
				req.setAttribute("lista", lista);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			req.getRequestDispatcher("aggiungiCliente.jsp").forward(req, resp);
			}else if ("rimuovi Cliente".equalsIgnoreCase(azione)) {
				try {
					DBManagment db = new DBManagment();
					List<Cliente> lista = db.listaClienti();
					req.setAttribute("lista", lista);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			req.getRequestDispatcher("rimuoviCliente.jsp").forward(req, resp);
					}

}
}
