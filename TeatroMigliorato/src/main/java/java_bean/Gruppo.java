package java_bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gruppo extends MasterEntity {
	
	private String nome;
	private int numeroPersone;
	@OneToMany(mappedBy ="id_gruppo")
	private List <Spettacolo> spettacoli;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroPersone() {
		return numeroPersone;
	}
	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}
	public List<Spettacolo> getSpettacoli() {
		return spettacoli;
	}
	public void setSpettacoli(List<Spettacolo> spettacoli) {
		this.spettacoli = spettacoli;
	}
	
	
	
}
