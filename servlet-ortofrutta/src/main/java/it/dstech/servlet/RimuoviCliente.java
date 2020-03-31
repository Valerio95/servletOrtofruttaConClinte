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

public class RimuoviCliente extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setAttribute("messaggio", "hai provato a fare l'accesso alla rimozione di un prodotto dalla get");
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);

		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id = Integer.parseInt(req.getParameter("idCliente"));
			try {
				DBManagment db = new DBManagment();
				 db.rimuoviCliente(id);
				 List<Cliente> lista = db.listaClienti();
					req.setAttribute("lista", lista);
					req.getRequestDispatcher("rimuoviCliente.jsp").forward(req, resp);
				}
			catch (SQLException | ClassNotFoundException e) {
				        e.printStackTrace();
			}
		}
}
