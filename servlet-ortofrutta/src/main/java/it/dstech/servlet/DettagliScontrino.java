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

public class DettagliScontrino extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idScontrino = Integer.parseInt(req.getParameter("idScontrino"));
		try {
			DBManagment dbManagment = new DBManagment();
			
			List<Prodotto> lista = dbManagment.dettagliScontrino(idScontrino);
			req.setAttribute("lista", lista);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("dettagli.jsp").forward(req, resp);

	}
 
	}

