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







