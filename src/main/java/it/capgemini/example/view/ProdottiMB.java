package it.capgemini.example.view;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import it.capgemini.persistence.entity.Categoria;
import it.capgemini.persistence.entity.Prodotto;
import it.capgemini.persistence.repositories.CategoriaRepo;


@Named
@ViewScoped
public class ProdottiMB {

	
	//@Autowired
	//private ProdottiRepo prodottiRepo;

	@Autowired
	private CategoriaRepo categoriaRepo;

	private Boolean crudEnable;

	private Prodotto prodottoExample = new Prodotto();
	
	private Prodotto prodottoExampleEs2 = new Prodotto();

	private Prodotto prodottoInsert = new Prodotto();

	private Prodotto prodottoUpdate = new Prodotto();

	private Long prodottoIdDelete;

	private List<Prodotto> tuttiProdotti;

	private List<Categoria> categorie = new LinkedList<Categoria>();

	private List<SelectItem> categorieItem = new LinkedList<SelectItem>();

	private Long catSelezionata = 1L;

	@PostConstruct
	private void init() {

		categorie = categoriaRepo.findAll();

		for (Categoria c : categorie) {
			categorieItem.add(new SelectItem(c, c.getNome()));
		}
	}

	/* SCOMMENTARE PER ESERCIZIO 1 DA QUI
	public String insertProdotto() {

		prodottoInsert.setCategoria(categoriaRepo.findById(catSelezionata).get());
		prodottiRepo.save(prodottoInsert);
		prodottoInsert = new Prodotto();
		this.cercaTutti();

		return "";
	}

	public String deleteProdotto(Prodotto p) {

		prodottiRepo.deleteById(p.getCodiceProdotto());
		this.cercaTutti();

		return "";
	}

	public String updateProdotto() {

		prodottiRepo.save(prodottoUpdate);
		prodottoUpdate = new Prodotto();

		return "";
	}

	public String cercaTutti() {

		tuttiProdotti = (List<Prodotto>) prodottiRepo.findAll();

		return "";
	}
SCOMMENTARE PER ESERCIZIO 1 FINO a QUI */

	
	
	

	
	/* ESERIZIO 2
	public String esercizio2() {

		tuttiProdotti = (List<Prodotto>) prodottiRepo.queryEsercizio2(prodottoExampleEs2.getDescrizione().toUpperCase(),
				prodottoExampleEs2.getPrezzo(), prodottoExampleEs2.getQuantita());

		prodottoExampleEs2 = new Prodotto();
		return "";
	}
	
	FINE ESERCIZIO 2*/
	
	
	public String esercizio3() {

		//inserire qui la soluzione dell'esercizio 3 utilizzare l'oggeto prodottoExample
		prodottoExample = new Prodotto();
		return "";
	}
	

	
	public String esercizio4() {

	

		prodottoExample.setCategoria(null);
		prodottoExample.setCodiceProdotto(null);
		prodottoExample.setNome(null);
		prodottoExample.setQuantita(null);
		prodottoExample.setPrezzo(null);

		// inserire qui la soluzione dell'esercizio 4 utilizzare l'oggeto prodottoExample
		
		prodottoExample = new Prodotto();
		return "";
	}


	public Prodotto getProdottoInsert() {
		return prodottoInsert;
	}

	public void setProdottoInsert(Prodotto prodottoInsert) {
		this.prodottoInsert = prodottoInsert;
	}

	public Long getProdottoIdDelete() {
		return prodottoIdDelete;
	}

	public void setProdottoIdDelete(Long prodottoIdDelete) {
		this.prodottoIdDelete = prodottoIdDelete;
	}

	public List<Prodotto> getTuttiProdotti() {
		return tuttiProdotti;
	}

	public void setTuttiProdotti(List<Prodotto> tuttiProdotti) {
		this.tuttiProdotti = tuttiProdotti;
	}

	public List<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}

	public Long getCatSelezionata() {
		return catSelezionata;
	}

	public void setCatSelezionata(Long catSelezionata) {
		this.catSelezionata = catSelezionata;
	}

	public Prodotto getProdottoUpdate() {
		return prodottoUpdate;
	}

	public void setProdottoUpdate(Prodotto prodottoUpdate) {
		this.prodottoUpdate = prodottoUpdate;
	}

	public Boolean getCrudEnable() {

		return true;

	}

	public void setCrudEnable(Boolean crudEnable) {
		this.crudEnable = crudEnable;
	}

	public Prodotto getProdottoExample() {
		return prodottoExample;
	}

	public void setProdottoExample(Prodotto prodottoExample) {
		this.prodottoExample = prodottoExample;
	}

	public Prodotto getProdottoExampleEs2() {
		return prodottoExampleEs2;
	}

	public void setProdottoExampleEs2(Prodotto prodottoExampleEs2) {
		this.prodottoExampleEs2 = prodottoExampleEs2;
	}

}
