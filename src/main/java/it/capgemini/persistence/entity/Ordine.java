package it.capgemini.persistence.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ordine {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long codiceOrdine;
	
	@ManyToOne
	private Cliente cliente;
	
   @OneToMany
	private List<Prodotto> prodotti;
	
	public Long getCodiceOrdine() {
		return codiceOrdine;
	}

	public void setCodiceOrdine(Long codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	
	
	

}
