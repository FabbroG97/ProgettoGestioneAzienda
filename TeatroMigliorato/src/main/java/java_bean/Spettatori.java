package java_bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Spettatori extends MasterEntity{
	
	private String nome, cognome;
	@OneToOne(mappedBy = "id_spettatore")
	private Biglietto id_ticket;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Biglietto getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(Biglietto id_ticket) {
		this.id_ticket = id_ticket;
	}
	
	
}
