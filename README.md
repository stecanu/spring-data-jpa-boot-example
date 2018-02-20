# Applicazione di esempio Spring Data con Spring boot


### Prerequisiti
    JDK 1.8+
	Maven
	
### Installazione

Scaricare il progetto selezionando il tasto "clone or download"

Per l'utilizzo su db oracle :

 1)scommentare la dipendenza del driver oracle nel pom.xml
  "<!-- Oracle JDBC driver-!>"

 2) commentare quella del dirver h2
  "<!-- H2 driver --> "

 3)nel file application.properties
  commentare le rige da 
  "# H2 settings"
   fino
  #end H2 settings
  e scommentare le righe da 
  # Oracle settings
  fino a
  #end Oracle settings
  
4) lanciare il file addOracleJdbc.bat nella cartella utilizzo

compilare l'applicaizone con il camando mvn clean install dalla cartella contenente il file pom.xml
eseguire il comando java -jar "nome del file jar" nella cartella targer

accedere al link http://localhost:9000/index.jsf







