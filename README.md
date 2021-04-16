# designersRS
cerini.enzo@gmail.com CERINI Enzo

avishka2007@gmail.com OBEYESEKARA Avishka

## Service RS
### Description du service

Le service RS est constitué de trois packages différents : 
* currency.management.web.data
* currency.management.web.service
* currency.management.web.resource

A travers ces différents packages, nous avons différentes classes qui sont implémentées.

Dans le package currency.management.web.data, nous avons créé notre classe de données Currency. Cette classe est associée à la création d'une Currency.



Le package currency.management.web.service implémente la classe CurrencyService. CurrencyService est la classe contenant toutes les fonctions associées aux Currency.


Le package currency.management.web.resource, quant à lui, implémente la classe CurrencyResource. La classe CurrencyResource est la classe contenant les réponses faites au client concernant les fonctions associées aux Currency.


~~~
JAVADOC
~~~

## Description du client

Notre client est implémenté dans notre classe Test.java. La classe Test est la classe permettant de tester à partir du client les fonctions associées aux Currency.

Dans cette classe, différentes fonctions sont implémentées :
* add(String name, double value)
* update(String name, double newRate)
* getConversion(double monnaieEntree, String typeEntree, String typeSortie)
* String getInfos(String currency)


La fonction add permet d'ajouter une nouvelle Currency à la liste des Currency déjà existante. Cette fonction add prend deux paramètres :
* Le nom de la nouvelle Currency que nous voulons créer
* La valeur que nous voulons lui affecter

Elle retournera :
* "The currency X has been added with the value Y" si l'ajout a bien été fait
* "Adding for "+ name +" is impossible !" si l'ajout n'a pas pu aboutir




La fonction update permet de mettre à jour une Currency déjà existante. Elle prend, elle aussi, deux paramètres :
* Le nom de la Currency déjà existante que nous voulons modifier
* La nouvelle valeur que nous voulons lui attribuer

Cette fonction retournera :
* "The currency named X has been modified with the value Y" si la mise à jour à pu être faite
* "The update of the currency named X with the value Y did not achieved !" si la mise à jour n'a pas pu être faite


La fonction getConversion convertie une devise en une autre. GetConversion, quant à elle, prend trois paramètres :
* Le somme que nous voulons convertir
* La devise que nous voulons convertir
* La devise vers laquelle nous voulons convertir

Elle retournera :
* "monnaieEntree typeEntree => monnaieSortie typeSortie" si la conversion a pu aboutir
* "The conversion was not successful !" si la conversion n'a pas pu aboutir


Enfin, la fonction getInfos est une fonction qui retourne les informations concernant une devise passée en paramètre. Elle prend uniquement un paramètre :
* La devise dont nous voulons les informations


Elle retournera :
* Le texte d'informations si tout se passe bien
* Un message d'erreur sinon
