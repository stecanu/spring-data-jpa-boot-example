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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.hateoas.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	private String cognomeCerca;

	@Value("${serverRest.url}")
	private String serverUrl;

	@Value("${serverRest.port}")
	private String serverPort;

	private String restEndPointUrl;
	
	private ClientiRepo clientiRepo;
//	private LinkedList<HashMap<String, String>> clienti = new LinkedList<HashMap<String, String>>();
	
	//@JsonProperty("clientes")
	private List<Cliente> tuttiClienti;

	@PostConstruct()
	private void init() {
		
		    clientiRepo= (ClientiRepo) ApplicationContextProvider.getApplicationContext().getBean(ClientiRepo.class);
		restEndPointUrl = "http://" + serverUrl + ":" + serverPort + "/";
	}

	public String cercaTuttiClienti() {

	
	   
	  
		
		//ClientiRepo clientiRepo= (ClientiRepo) ContextLoader.getCurrentWebApplicationContext().getBean(ClientiRepo.class);
		
		tuttiClienti= clientiRepo.findAll();
	//	tuttiClienti = new LinkedList<Cliente>();
		
		//Cliente c = new  Cliente();
		
		//c.setNome("test");
	//	c.setCognome("test1");
		//tuttiClienti.add(c);
		
		return "";
		
		//Map<String, Object> parameters = new HashMap<>();
		//parameters.put("user", 27);
		
		
//		ParameterizedTypeReference<Resources<Cliente>> resourceParameterizedTypeReference =
//		        new ParameterizedTypeReference<Resources<Cliente>>() {};
//
//		        Traverson traverson;
//				try {
//					traverson = new Traverson(new URI(restEndPointUrl), MediaTypes.HAL_JSON);
//					Resources<Cliente> itemResource = traverson.follow("clientes"). toObject(resourceParameterizedTypeReference);
//					
//					tuttiClienti = new LinkedList<Cliente>(itemResource.getContent()) ;
//				} catch (URISyntaxException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
		

		
//		try {
//			traverson = new Traverson(new URI(restEndPointUrl), MediaTypes.HAL_JSON);
//			Object result = traverson.follow("clientes").toObject("$.clientes");
//			setTuttiClienti(Arrays.asList(result));
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		mapper.registerModule(new Jackson2HalModule());
//
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
//		converter.setObjectMapper(mapper);
//
//		RestTemplate template = new RestTemplate(Collections.<HttpMessageConverter<?>> singletonList(converter));
	
			
		//Object[]  result = template.getForObject(restEndPointUrl + "clienti",
			//	Object[].class);
		
		
		  
		//result.getResultList();
		
//		for(Object cliente : objects)
//		{
//			BeanWrapperImpl wrapper = new BeanWrapperImpl(cliente);
//			
//			clienti.put
//			
//		}

	//	return "";
	}

	public String cercaPerCognome() {
		
		
		
		this.tuttiClienti=clientiRepo.findByCognome(this.cognomeCerca);
		this.cognomeCerca="";
		
//		RestTemplate restTemplate = new RestTemplate();
//
//		@SuppressWarnings("unchecked")
//		ResponseEntity<? extends LinkedList<HashMap<String, String>>> responseEntity = restTemplate.getForEntity(
//				restEndPointUrl, (Class<? extends LinkedList<HashMap<String, String>>>) LinkedList.class, this.cognome);

	//	clienti = responseEntity.getBody();

		return "";
	}

	
	public String aggiungiCliente() {
		Cliente c = new Cliente  ();
		c.setCognome(this.cognome);
		c.setNome(this.nome);
		
		clientiRepo.save(c);
		this.nome="";
		this.cognome="";
		this.cercaTuttiClienti();
		return "";
	}
	

	public String addCustomer() {
		Map<String, String> cliente = new HashMap<String, String>();

		cliente.put("nome", this.nome);

		cliente.put("cognome", this.cognome);

		// ClientHttpRequestFactory requestFactory = new
		// HttpComponentsClientHttpRequestFactory(new
		// org.apache.http.impl.client.DefaultHttpClient());
		RestTemplate restTemplate = new RestTemplate();

		restTemplate.postForObject("http://localhost:8080/clienti", cliente, String.class);
		// restTemplate.postForObject("http://localhost:8080/clienti", request,
		// Form.class);
		// Object obj =
		// restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random",
		// Quote.class);

		// Client client = ClientBuilder.newClient();
		// WebTarget target = client.target("http://localhost:8080").path("clienti");

		//
		//
		// target.request(MediaType.APPLICATION_JSON_TYPE)
		// .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE));
		this.nome = "";
		this.cognome = "";

		return "";
	}

	public RestTemplate getRestTemplateWithHalMessageConverter() {
		 RestTemplate restTemplate = new RestTemplate();
		 List<HttpMessageConverter<?>> existingConverters = restTemplate.getMessageConverters();
		 List<HttpMessageConverter<?>> newConverters = new ArrayList<>();
		 newConverters.add(getHalMessageConverter());
		 newConverters.addAll(existingConverters);
		 restTemplate.setMessageConverters(newConverters);
		 return restTemplate;
		}

		private HttpMessageConverter getHalMessageConverter() {
		 ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.registerModule(new Jackson2HalModule());
		 MappingJackson2HttpMessageConverter halConverter = new TypeConstrainedMappingJackson2HttpMessageConverter(ResourceSupport.class);
		 halConverter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON));
		 halConverter.setObjectMapper(objectMapper);
		 return halConverter;
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
}
