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

public class CompraProdotto extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai provato a fare l'accesso all'aggiunta di un prodotto dalla get");
		req.getRequestDispatcher("welcomeCliente.jsp").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		int idProdotto = Integer.parseInt(req.getParameter("id"));
		int qta = Integer.parseInt(req.getParameter("qta")); 
		int idCliente=Integer.parseInt(req.getParameter("idCliente"));
		Prodotto p = new Prodotto();
		p.setId(idProdotto);
		p.setQuantità(qta);
		if("Aggiungi".equalsIgnoreCase(azione)) {
		try {
			DBManagment db = new DBManagment();
			boolean vendiProdotto = db.vendiProdotto(idCliente,p);
			List<Prodotto> lista = db.getAll();
			List<Prodotto> carrello = db.stampaCarrello();

			if(vendiProdotto) {
				req.setAttribute("idCliente", idCliente);
				req.setAttribute("lista", lista);
				req.setAttribute("carrello", carrello);
				req.getRequestDispatcher("compraProdotto.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("messaggio", "quantita insufficente per essere venduta");
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}if("Compra".equalsIgnoreCase(azione)) {
		try {
			DBManagment db = new DBManagment();
			boolean vendiProdotto = db.vendiProdotto(idCliente, p);
			if(vendiProdotto) {
				db.creaScontrino(idCliente);
				req.getRequestDispatcher("welcomeCliente.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("messaggio", "quantita insufficente per essere venduta");
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		}

}
