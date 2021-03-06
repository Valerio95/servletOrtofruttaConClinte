package it.dstech.servlet.modelli;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import it.dstech.servlet.modelli.Prodotto;

public class Scontrino {
private int id;
private int idCliente;
List<Prodotto> prodottiAquistati = new ArrayList<>();
private Timestamp dataDiEmissione;
private int prezzoTotale;



public int getIdCliente() {
	return idCliente;
}
public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}
public int getPrezzoTotale() {
	return prezzoTotale;
}
public void setPrezzoTotale(int prezzoTotale) {
	this.prezzoTotale = prezzoTotale;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public List<Prodotto> getProdottiAquistati() {
	return prodottiAquistati;
}
public void setProdottiAquistati(List<Prodotto> prodottiAquistati) {
	this.prodottiAquistati = prodottiAquistati;
}

public Timestamp getDataDiEmissione() {
	return dataDiEmissione;
}
public void setDataDiEmissione(Timestamp dataDiEmissione) {
	this.dataDiEmissione = dataDiEmissione;
}
public int calcolaPrezzoTotale() {
	for(Prodotto prodotto:prodottiAquistati) {
		this.prezzoTotale+=prodotto.getPrezzo();
	}
	return this.prezzoTotale;
}
@Override
public String toString() {
	return "Scontrino [id=" + id + ", idCliente=" + idCliente + ", prodottiAquistati=" + prodottiAquistati
			+ ", dataDiEmissione=" + dataDiEmissione + ", prezzoTotale=" + prezzoTotale + "]";
}


}
