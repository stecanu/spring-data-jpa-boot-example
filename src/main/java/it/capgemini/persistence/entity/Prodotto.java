package it.capgemini.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prodotto {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long codiceProdotto;
	private String descrizione;
	private Double prezzo;
	private Integer quantita;
	
	@ManyToOne 
	private Categoria categoria;
	
	
	
	public Long getCodiceProdotto() {
		return codiceProdotto;
	}
	public void setCodiceProdotto(Long codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	
}
