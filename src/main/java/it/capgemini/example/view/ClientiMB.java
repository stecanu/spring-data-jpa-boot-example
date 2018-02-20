/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.capgemini.example.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import it.capgemini.example.ApplicationContextProvider;
import it.capgemini.persistence.entity.Cliente;
import it.capgemini.persistence.repositories.ClientiRepo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Named
@ViewScoped
public class ClientiMB implements Serializable {



	
	
	private static final long serialVersionUID = 1L;

	private String nome;

	private String cognome;
	
	private String comune;
	
	private String telefono;
	
	private String cap;
	
	
	
	

	private String cognomeCerca;

	

	
	private ClientiRepo clientiRepo;
	
	private Cliente clienteExample = new Cliente();

	private List<Cliente> tuttiClienti;

	@PostConstruct()
	private void init() {
		
		    clientiRepo= (ClientiRepo) ApplicationContextProvider.getApplicationContext().getBean(ClientiRepo.class);
		
	}

	public String cercaTuttiClienti() {

		tuttiClienti= clientiRepo.findAll();
		//clientiRepo.findByNomeStartingWithOrNomeIsNullAndCognomeIsNotNullOrTelefonoLike("m", "06");

		return "";
		  

	}

	
	
	public String cercaPerExample()
	{
		                           

		
	if(clienteExample.getCognome().isEmpty())
		clienteExample.setCognome(null);
	
	if(clienteExample.getCap().isEmpty())
		clienteExample.setCap(null);
	
	if(clienteExample.getNome().isEmpty())
		clienteExample.setNome(null);
	
	if(clienteExample.getTelefono().isEmpty())
		clienteExample.setTelefono(null);
	
	if(clienteExample.getComune().isEmpty())
		clienteExample.setComune(null);
	
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
		Example<Cliente> example = Example.of(clienteExample, matcher);

		this.tuttiClienti=clientiRepo.findAll(example);
		clienteExample = new Cliente();

		
		
		return "";
	}
	
	public String cercaPerCognome() {
		
		
		
		this.tuttiClienti=clientiRepo.findByCognome(this.cognomeCerca);
		this.cognomeCerca="";
		


		return "";
	}

	
	public String aggiungiCliente() {
		Cliente c = new Cliente  ();
		c.setCognome(this.cognome);
		c.setNome(this.nome);
		c.setCap(this.cap);
		c.setTelefono(this.telefono);
		c.setComune(this.comune);
		
		clientiRepo.save(c);
		this.nome="";
		this.cognome="";
		this.cap="";
		this.telefono="";
		this.comune="";
		this.cercaTuttiClienti();
		return "";
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

	public List<Cliente> getTuttiClienti() {
		
		return tuttiClienti;
	}

	public void setTuttiClienti(List<Cliente> tuttiClienti) {
		this.tuttiClienti = tuttiClienti;
	}

	public String getCognomeCerca() {
		return cognomeCerca;
	}

	public void setCognomeCerca(String cognomeCerca) {
		this.cognomeCerca = cognomeCerca;
	}

	public Cliente getClienteExample() {
		return clienteExample;
	}

	public void setClienteExample(Cliente clienteExample) {
		this.clienteExample = clienteExample;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
