# Applicazione di esempio Spring Data con Spring boot


### Prerequisiti
    JDK 1.8+
	 Maven
	 DataBase H2/Oracle
	
### Installazione

Scaricare il progetto selezionando il tasto "clone or download"

Per l'utilizzo su db oracle :

 1) scommentare la dipendenza del driver oracle nel pom.xml
   "<!-- Oracle JDBC driver-!>"


 2) nel file src/resources/application.properties commentare le rige da   "# H2 settings" fino "#end H2 settings" e scommentare le righe da  "#Oracle settings" fino a "#end Oracle settings"
  
 3) lanciare il file addOracleJdbc.bat nella cartella utilizzo

compilare  con il camando mvn clean install dalla cartella contenente il file pom.xml
eseguire il comando java -jar "nome del file jar" nella cartella target

accedere al link http://localhost:9000/index.jsf


### Esercizio 1)

 1 nel package it.capgemini.persistence.repositories creare il repository per l'entita Prodotto,  la classe si deve chiamare :ProdottiRepo
 2 andare nella classe ProdottiMB nel package it.capgemini.example.view  scommentare le righe 25 26 
   e dalla riga alla 94
 3 accedere all'url http://localhost:9000/prodotti.jsf cliccare su catalogo e verificare che sia possibile
   effettuare le operazioni di inserimento cancellazione e modifica

### Esercizio 2)

 1 nel repository creato nell'esercizio precedente creare, con l'utilizzo dell'annotation @Query la funzionalità chiamata queryEsercizio2
   che sia in grado di cercare tutti i prodotti che hanno una descrizione in like con il paramentro fornito con un prezzo minore di un paramentro fornito
   e con qunatità maggiore di un paramentro fornito.
 2 andare nella classe ProdottiMB nel package it.capgemini.example.view  scommentare le righe realtive al metodo esercizio2
 3 accedere all'url http://localhost:9000/prodotti.jsf cliccare su esercizio2 e verificare il funzionamento della query;

### Esercizio 3)

 1 nel repository creato al punto 1 creare, tramite l'utilizzo della tecnica della sintassi, la stessa funzione di ricerca del punto precedente
 2 andare nella classe ProdottiMB nel package it.capgemini.example.view   e inserire la soluzione nel punto
    dove si trova il commento:inserire qui la soluzione dell'esercizio 3, nota: i dati dalla gui arrivano nell'oggetto  "prodottoExample"
 4 accedere all'url http://localhost:9000/prodotti.jsf cliccare su esercizio3 e verificare il funzionamento della query;
 
### Esercizio 4) facoltativo
  
  1 andare nella classe ProdottiMB nel package it.capgemini.example.view   in corrispondenza del commento :"inserire qui la soluzione dell'esercizio 4"
    creare un matcher che trovi tutti i prodotti che hanno la desrizione in like con una stringa di ricerca presente prodottoExample.getDescrizione()  
  2 accedere all'url http://localhost:9000/prodotti.jsf cliccare su esercizio4 e verificare il funzionamento della query;







