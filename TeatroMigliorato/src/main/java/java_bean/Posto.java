package java_bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Posto extends MasterEntity{
	
	private String codice;
	@OneToOne(mappedBy = "id_posto")
	private Biglietto id_biglietto;
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public Biglietto getId_biglietto() {
		return id_biglietto;
	}
	public void setId_biglietto(Biglietto id_biglietto) {
		this.id_biglietto = id_biglietto;
	}
	
}
