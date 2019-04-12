package java_bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Biglietto extends MasterEntity{
	
	
	@OneToOne
	private Spettatori id_spettatore;
	
	@OneToOne
	private Posto id_posto;
	
	private boolean venduto;
	
	public Spettatori getId_spettatore() {
		return id_spettatore;
	}
	public void setId_spettatore(Spettatori id_spettatore) {
		this.id_spettatore = id_spettatore;
	}
	public Posto getId_posto() {
		return id_posto;
	}
	public void setId_posto(Posto id_posto) {
		this.id_posto = id_posto;
	}
	public boolean isVenduto() {
		return venduto;
	}
	public void setVenduto(boolean venduto) {
		this.venduto = venduto;
	}
	
	
}
