package it.dstech.servlet.modelli;

public class Prodotto {
	
	private String nome;
    private int quantit�;
    private int id;
	private int prezzo;
	private String descrizione;
	
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}
	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", quantit�=" + quantit� + ", id=" + id + "]";
	}
    
}
