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

public class AggiungiCliente extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai provato a fare l'accesso all'aggiunta di un prodotto dalla get");
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		Cliente c = new Cliente();
		c.setNome(nome);
		
		try {
			DBManagment dbManagment = new DBManagment();
			List<Cliente> lista =  dbManagment.listaClienti();
			req.setAttribute("lista", lista);
			dbManagment.aggiungiCliente(c);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("aggiungiCliente.jsp").forward(req, resp);

	}
}
