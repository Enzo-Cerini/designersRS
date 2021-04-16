# designersRS
cerini.enzo@gmail.com CERINI Enzo

avishka2007@gmail.com OBEYESEKARA Avishka

## Service RS
### Description du service

Le service RS est constitué de deux packages différents : 
* currency.management.web.data
* currency.management.web.service
* currency.management.web.resource

A travers ces différents package, nous avons différentes classes qui sont implémentée.

Dans le package currency.management.web.data, nous avons créé notre classe de données Currency. Cette classe est associée à la création d'une Currency.



Le package currency.management.web.service implémente la classe CurrencyService. CurrencyService est la classe contenant toutes les fonctions associées aux Currency.


Le package currency.management.web.resource, quant à lui, implémente la classe CurrencyResource. La classe CurrencyResource est la classe contenant les réponses faites au client concernant les fonctions associées aux Currency.


~~~
JAVADOC
~~~

## Description du client

Notre client est implémenté dans notre classe Test.java. La classe Test est la classe permettant de tester à partir du client les fonctions associées aux Currency.

Dans cette classe, différentes fonctions sont implémentée :
* add(String name, double value)
* update(String name, double newRate)
* getConversion(double monnaieEntree, String typeEntree, String typeSortie)
* String getInfos(String currency)


La fonction add prend deux paramètre :
* Le nom de la nouvelle Currency que nous voulons créer
* La valeur que nous voulons lui affecter
