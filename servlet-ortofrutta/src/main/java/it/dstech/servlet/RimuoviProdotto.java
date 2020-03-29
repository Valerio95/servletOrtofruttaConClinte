package it.dstech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.servlet.modelli.Prodotto;
import it.dstech.servlet.repos.DBManagment;

public class RimuoviProdotto extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai provato a fare l'accesso alla rimozione di un prodotto dalla get");
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("prodottoScelto"));
		Prodotto p = new Prodotto();
        p.setId(id);
		try {
			DBManagment db = new DBManagment();
			 db.rimuoviProdotto(p);
				req.getRequestDispatcher("welcome.jsp").forward(req, resp);
			}
		catch (SQLException | ClassNotFoundException e) {
			        e.printStackTrace();
		}
	}

}
