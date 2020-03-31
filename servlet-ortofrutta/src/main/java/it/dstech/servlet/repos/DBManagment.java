package it.dstech.servlet.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.dstech.servlet.modelli.Prodotto;
import it.dstech.servlet.modelli.Cliente;
import it.dstech.servlet.modelli.Scontrino;

public class DBManagment {
 static Scontrino scontrino =new Scontrino();
 static List<Integer> idProdottiVenduti = new ArrayList<>();
		private Connection connessione;

		public DBManagment() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String password = "95asroma"; 
			String username = "root"; 
			String url = "jdbc:mysql://localhost:3306/magazzinoortofrutticolo?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
			this.connessione = DriverManager.getConnection(url, username, password);
		}
		public void aggiungiCliente(Cliente c) throws SQLException {
			PreparedStatement prepareStatement = this.connessione.prepareStatement("INSERT INTO clienti(nome) VALUES ( ?);");
			prepareStatement.setString(1, c.getNome());
			prepareStatement.execute();
		}

		public boolean addProdotto(Prodotto p) throws SQLException {
			PreparedStatement controlloProdotti = this.connessione.prepareStatement("select * from prodotti ");
			ResultSet executeControlloProdotti = controlloProdotti.executeQuery();
			
			while (executeControlloProdotti.next()) {
				String nome=executeControlloProdotti.getString(2);
				int quantità=executeControlloProdotti.getInt(3);
				String descrizione=executeControlloProdotti.getString(4);
				
			if(p.getNome().equalsIgnoreCase(nome)&&p.getDescrizione().equalsIgnoreCase(descrizione)) {
				PreparedStatement updateQuery = this.connessione.prepareStatement("Update prodotti set quantità = ? where nome = ? and descrizione=?");
				updateQuery.setInt(1, p.getQuantità()+quantità);
				updateQuery.setString(2, p.getNome());
				updateQuery.setString(3, p.getDescrizione());
				updateQuery.execute();
				return true;
			}
			} 
				PreparedStatement prepareStatement = this.connessione.prepareStatement("INSERT INTO prodotti(nome, quantità, descrizione, prezzo) VALUES ( ?, ?, ?, ?);");
				prepareStatement.setString(1, p.getNome());
				prepareStatement.setInt(2, p.getQuantità());
				prepareStatement.setString(3, p.getDescrizione());
				prepareStatement.setInt(4, p.getPrezzo());
				prepareStatement.execute();
			
			return true;
			
			
			}
		
		public void rimuoviProdotto(Prodotto p) throws SQLException {
			PreparedStatement prepareStatement = this.connessione.prepareStatement("delete from prodotti where id = ? limit 1");
			prepareStatement.setInt(1,p.getId());
			prepareStatement.execute();
		}
		public void rimuoviCliente(int id) throws SQLException {
			PreparedStatement prepareStatement = this.connessione.prepareStatement("delete from clienti where id = ? limit 1;");
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
		}
		public void creaScontrino(int idCliente) throws SQLException {
			PreparedStatement prepareStatement = this.connessione.prepareStatement("INSERT INTO scontrino(id_clienti,spesa_totale) VALUES ( ?, ?);");
			prepareStatement.setInt(1, idCliente);
			prepareStatement.setInt(2, scontrino.calcolaPrezzoTotale());
			prepareStatement.execute();
            
		}
		public void assegnaIdScontrino(int idCliente) throws SQLException {
			PreparedStatement prepareStatement2 = this.connessione.prepareStatement("select Max(id) from scontrino where id_clienti=?;");
			prepareStatement2.setInt(1, idCliente);
            ResultSet executeQuery = prepareStatement2.executeQuery();
           int idScontrino=0;
            while(executeQuery.next()) {
            	idScontrino =executeQuery.getInt(1);
            }
            
            
            for(Integer idProdotto: idProdottiVenduti ) {
    			PreparedStatement updateQuery = this.connessione.prepareStatement("Update prodotti_venduti set id_scontrino = ? where id = ?;");
                updateQuery.setInt(1, idScontrino);
                updateQuery.setInt(2, idProdotto);
                updateQuery.execute();
			
				
				
            }
		}

		public boolean vendiProdotto(int idCliente,Prodotto p) throws SQLException {
			
			Prodotto prodottoDB =new Prodotto();
			
							
            PreparedStatement prepareStatement = this.connessione.prepareStatement("select * from prodotti where id = ? limit 1");
			prepareStatement.setInt(1, p.getId());
			ResultSet executeQuery = prepareStatement.executeQuery();
			
			while (executeQuery.next()) {
				prodottoDB.setId(executeQuery.getInt(1));
				prodottoDB.setQuantità(executeQuery.getInt(3));
				prodottoDB.setNome(executeQuery.getString(2));
				prodottoDB.setPrezzo(executeQuery.getInt(5));
			}
             
			Prodotto prodottoCarrello = new Prodotto();
			prodottoCarrello.setId(p.getId());
			prodottoCarrello.setNome(prodottoDB.getNome());
			prodottoCarrello.setQuantità(p.getQuantità());
			for(int i=0;i<p.getQuantità();i++) {
			prodottoCarrello.setPrezzo(prodottoDB.getPrezzo()+prodottoCarrello.getPrezzo());
			}
			if (p.getQuantità() > prodottoDB.getQuantità()) {
				return false;
			}
			if (p.getQuantità()==prodottoDB.getQuantità()) {
				
				scontrino.getProdottiAquistati().add(prodottoCarrello);
				PreparedStatement prepareStatement3 = this.connessione.prepareStatement("INSERT INTO prodotti_venduti(numero_vendite, id_prodotti_venduti, id_scontrino) VALUES ( ?, ?,?);");
				prepareStatement3.setInt(1,p.getQuantità());
				prepareStatement3.setInt(2,p.getId());
				prepareStatement3.setInt(3,0);
				prepareStatement3.execute();
				PreparedStatement deleteQuery = this.connessione.prepareStatement("Delete from prodotti where id = ?");
				deleteQuery.setInt(1, p.getId());
				deleteQuery.execute();
				PreparedStatement prepareStatement2 = this.connessione.prepareStatement("select Max(id) from prodotti_venduti where id_prodotti_venduti=?;");
				prepareStatement2.setInt(1, p.getId());
	            ResultSet executeQuery2 = prepareStatement2.executeQuery();
	           int idScontrino=0;
	            while(executeQuery2.next()) {
	            	idScontrino =executeQuery2.getInt(1);
	            }
	            idProdottiVenduti.add(idScontrino);
				return true;

			}else {
			
			scontrino.getProdottiAquistati().add(prodottoCarrello);
			PreparedStatement updateQuery = this.connessione.prepareStatement("Update prodotti set quantità = ? where id = ?");
			updateQuery.setInt(1, prodottoDB.getQuantità() - p.getQuantità());
			updateQuery.setInt(2, prodottoDB.getId());
			updateQuery.execute();
			PreparedStatement prepareStatement3 = this.connessione.prepareStatement("INSERT INTO prodotti_venduti(numero_vendite, id_prodotti_venduti, id_scontrino) VALUES ( ?, ?, ?);");
			prepareStatement3.setInt(1,p.getQuantità());
			prepareStatement3.setInt(2,p.getId());
			prepareStatement3.setInt(3,0);
			prepareStatement3.execute();
			PreparedStatement prepareStatement2 = this.connessione.prepareStatement("select Max(id) from prodotti_venduti where id_prodotti_venduti=?;");
			prepareStatement2.setInt(1, p.getId());
            ResultSet executeQuery2 = prepareStatement2.executeQuery();
			int idScontrino=0;
            while(executeQuery2.next()) {
            	idScontrino =executeQuery2.getInt(1);
            }
            idProdottiVenduti.add(idScontrino);
			return true;

			}
			

		}
		public List<Prodotto> dettagliScontrino(int idScontrino) throws SQLException{
			PreparedStatement updateQuery = this.connessione.prepareStatement("select * from prodotti_venduti where id_scontrino=?;");
			updateQuery.setInt(1, idScontrino);
			ResultSet executeQuery = updateQuery.executeQuery();
			
			List<Prodotto> dettagli= new ArrayList<>();
			while(executeQuery.next()) {
			Prodotto prodotto =new Prodotto();
			int id = executeQuery.getInt(3);
			PreparedStatement updateQuery2 = this.connessione.prepareStatement("select * from prodotti where id=?;");
			updateQuery2.setInt(1, id);
			ResultSet executeQuery2 = updateQuery2.executeQuery();
			while(executeQuery2.next()) {
				prodotto.setNome(executeQuery2.getString(2));
				prodotto.setDescrizione(executeQuery2.getString(4));
				prodotto.setPrezzo(executeQuery2.getInt(5));
			}
			
			prodotto.setQuantità(executeQuery.getInt(2));
			dettagli.add(prodotto);
			}
			return dettagli;
		}

		public List<Scontrino> scontriniCliente(int idCliente) throws SQLException {
			PreparedStatement updateQuery = this.connessione.prepareStatement("select * from scontrino where id_clienti=?;");
			updateQuery.setInt(1, idCliente);
			ResultSet executeQuery = updateQuery.executeQuery();
			List<Scontrino> listaScontrini= new ArrayList<>();
			while(executeQuery.next()) {
			Scontrino scontrino =new Scontrino();
			scontrino.setDataDiEmissione(executeQuery.getTimestamp(4));
			scontrino.setId(executeQuery.getInt(1));
			scontrino.setPrezzoTotale(executeQuery.getInt(3));
			listaScontrini.add(scontrino);
			}
			return listaScontrini;
		}
		public List<Prodotto> stampaCarrello(){
			List<Prodotto> carrello=new ArrayList<>();
			for (Prodotto prodotto: scontrino.getProdottiAquistati()) {
				carrello.add(prodotto);
			}
			return carrello;
		}
		public List<Cliente> stampaScontrini() throws SQLException {
			PreparedStatement updateQuery = this.connessione.prepareStatement("select * from clienti;");
			ResultSet executeQuery = updateQuery.executeQuery();
			List<Cliente> elencoClienti = new ArrayList<>();
			while(executeQuery.next()) {
				Cliente temp = new Cliente();
				temp.setId(executeQuery.getInt(1));
				temp.setNome(executeQuery.getString(2));
				PreparedStatement updateQuery2 = this.connessione.prepareStatement("select * from scontrino where id_clienti=?;");
				updateQuery2.setInt(1,temp.getId() );
				ResultSet executeQuery2 = updateQuery.executeQuery();
           while(executeQuery2.next()) {
				Scontrino temp2=new Scontrino();
        	   temp2.setId(executeQuery2.getInt(1));
        	   temp2.setDataDiEmissione(executeQuery2.getTimestamp(4));
        	   temp.getListaScontrini().add(temp2);
        	  
           }
           elencoClienti.add(temp);
			}
			return elencoClienti;
		}

		public List<Prodotto> getAll() throws SQLException {
			PreparedStatement updateQuery = this.connessione.prepareStatement("select * from prodotti;");
			ResultSet executeQuery = updateQuery.executeQuery();
			List<Prodotto> elenco = new ArrayList<>();
			while(executeQuery.next()) {
				Prodotto temp = new Prodotto();
				temp.setId(executeQuery.getInt(1));
				temp.setNome(executeQuery.getString(2));
				temp.setQuantità(executeQuery.getInt(3));
				temp.setDescrizione(executeQuery.getString(4));
				temp.setPrezzo(executeQuery.getInt(5));

				elenco.add(temp);
			}
			return elenco;
		}
		public List<Prodotto> creaListaVendite() throws SQLException {
			List<Prodotto> elenco = new ArrayList<>();
			PreparedStatement trovaIdProdotto = connessione
					.prepareStatement("select distinct id_prodotti_venduti from prodotti_venduti;");
			ResultSet executetrovaIdProdotto = trovaIdProdotto.executeQuery();
			List<Integer> elencoIdProdotti = new ArrayList<>();
			
			while (executetrovaIdProdotto.next()) {
				int idProdotto = executetrovaIdProdotto.getInt(1);
				elencoIdProdotti.add(idProdotto);
			} 
			for(Integer idProdotto:elencoIdProdotti ) {
				
			
			PreparedStatement updateQuery = this.connessione.prepareStatement("select * from prodotti_venduti where id_prodotti_venduti=?;");
			updateQuery.setInt(1, idProdotto);
			ResultSet executeQuery = updateQuery.executeQuery();
			Prodotto temp = new Prodotto();
			
			while(executeQuery.next()) {	
				temp.setQuantità(executeQuery.getInt(2)+temp.getQuantità());
			}
			PreparedStatement updateQuery2 = this.connessione.prepareStatement("select * from prodotti where id=?;");
			updateQuery2.setInt(1, idProdotto);
			ResultSet executeQuery2 = updateQuery2.executeQuery();
			while(executeQuery2.next()) {
				temp.setPrezzo(executeQuery2.getInt(5));
				temp.setDescrizione(executeQuery2.getString(4));
				temp.setNome(executeQuery2.getString(2));
				elenco.add(temp);
			}
			}
			return elenco;
		}
		public List<Cliente> listaClienti() throws SQLException{
			PreparedStatement updateQuery = this.connessione.prepareStatement("select * from clienti;");
			ResultSet executeQuery = updateQuery.executeQuery();
			List<Cliente> elenco = new ArrayList<>();
			while(executeQuery.next()) {
				Cliente temp = new Cliente();
				temp.setId(executeQuery.getInt(1));
				temp.setNome(executeQuery.getString(2));
				

				elenco.add(temp);
			}
			return elenco;
		}
		}
	

