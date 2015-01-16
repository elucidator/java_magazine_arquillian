# Java EE - Arquillian

Deze code is begeleidend aan het Artikel "Arquilian 101" in het Java Magazine.

##  Vereisten

* De code is gaat er vanuit dat je JDK 8 en Maven 3 hebt.to run the application.

## Compileren en testen
Zoals in het artikel vermeld wordt er gebruik gemaakt van Profiles.

Het commando `mvn clean verify` zal word alle code gecompileerd en de unit testen worden uitgevoerd.

Het commando `mvn clean verify -P with-integration` worden ook alle integratie testen uitvoeren.
(Let op, bij de eerste run zal de Wildfly distributie gedownload worden, 129MB dus kan even duren.)