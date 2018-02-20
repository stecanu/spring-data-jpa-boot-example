package it.capgemini.persistence.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cognome;
    private String comune;
    private String telefono;
    private String cap;

    @OneToMany(mappedBy="cliente")
    private Set<Ordine> ordini;
 
    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



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



	public String getComune() {
		return comune;
	}



	public void setComune(String comune) {
		this.comune = comune;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCap() {
		return cap;
	}



	public void setCap(String cap) {
		this.cap = cap;
	}



	





}
