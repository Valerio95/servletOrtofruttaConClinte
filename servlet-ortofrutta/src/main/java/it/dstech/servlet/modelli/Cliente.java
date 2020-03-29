package it.dstech.servlet.modelli;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
private String nome;
private int id;
List<Scontrino> listaScontrini = new ArrayList<>();
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public List<Scontrino> getListaScontrini() {
	return listaScontrini;
}
public void setListaScontrini(List<Scontrino> listaScontrini) {
	this.listaScontrini = listaScontrini;
}
@Override
public String toString() {
	return "Cliente [nome=" + nome + ", id=" + id + ", listaScontrini=" + listaScontrini + "]";
}

}
