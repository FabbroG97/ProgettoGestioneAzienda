package java_bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Spettacolo extends MasterEntity{
	
	private String nome;
	@ManyToOne
	private Gruppo id_gruppo;
	private boolean confermato;
	@Temporal(TemporalType.DATE)
	private Date dataSpettacolo;
	
	
	
	public Date getDataSpettacolo() {
		return dataSpettacolo;
	}
	public void setDataSpettacolo(Date dataSpettacolo) {
		this.dataSpettacolo = dataSpettacolo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Gruppo getId_gruppo() {
		return id_gruppo;
	}
	public void setId_gruppo(Gruppo id_gruppo) {
		this.id_gruppo = id_gruppo;
	}
	public boolean isConfermato() {
		return confermato;
	}
	public void setConfermato(boolean confermato) {
		this.confermato = confermato;
	}
	
	
}
