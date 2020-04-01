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

public class ModificaProdotto extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai provato a fare l'accesso alla modifica di un prodotto dalla get");
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("idProdotto"));
		String nome = req.getParameter("nome");
		int qta = Integer.parseInt(req.getParameter("qta"));
		String descrizione =req.getParameter("descrizione");
		int prezzo = Integer.parseInt(req.getParameter("prezzo"));
		Prodotto p = new Prodotto();
		p.setNome(nome);
		p.setQuantità(qta);
		p.setDescrizione(descrizione);
		p.setPrezzo(prezzo);
		try {
			DBManagment dbManagment = new DBManagment();
			dbManagment.modificaProdotto(id, p);
			List<Prodotto> lista = dbManagment.getAll();
			req.setAttribute("lista", lista);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("modificaProdotto.jsp").forward(req, resp);

	}

}
