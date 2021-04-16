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
* "Adding for X is impossible !" si l'ajout n'a pas pu aboutir




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


Enfin, la fonction getInfos est une fonction qui récupère les informations d'une currency grâce à l'api de Wikipédia et qui retourne les informations concernant la devise passée en paramètre. Elle prend uniquement un paramètre :
* La devise dont nous voulons les informations


Elle retournera :
* Le texte d'informations si tout se passe bien
* Un message d'erreur sinon

### Demonstration du client

~~~ java
public static void main(String[] args) {
	add("Enzo",25);
	getConversion(1, "Euro", "Enzo");

	add("Avishka",32);
	getConversion(1, "Euro", "Avishka");

	update("A",12);

	update("Enzo",20);
	getConversion(1, "Euro", "Enzo");

	getConversion(22.3,"Dollar","Yen");
	getConversion(50, "Euro", "Roupie");
	getConversion(15, "Livre", "Yen");

	getInfos("Dollar");
	getInfos("Roupie");
}
~~~

Afin de vous expliquer notre démonstration, nous allons vous expliquer le test de notre client ligne par ligne :

Ligne 1 : add("Enzo",25);
Cette ligne ajoutera une Currency nommée Enzo avec la valeur 25 aux Currency déjà existantes. "The currency Enzo has been added with the value 25" est le message qui sera affiché si l'ajout a bien été effectué

Ligne 2 : getConversion(1, "Euro", "Enzo");
Cette ligne fera la conversion d'1 Euro en Enzo. Si la ligne précédente a bien été effectuée, le message qui devrait s'afficher est "1 Euro => 25 Enzo"

Ligne 3 : add("Avishka",32);
Cette ligne ajoutera une Currency nommée Avishka avec la valeur 32 aux Currency déjà existantes. "The currency Avishka has been added with the value 32" est le message qui sera affiché si l'ajout a bien été effectué

Ligne 4 : getConversion(1, "Euro", "Avishka");
Cette ligne fera la conversion d'1 Euro en Avishka. Si la ligne précédente a bien été effectuée, le message qui devrait s'afficher est "1 Euro => 32 Avishka"

Ligne 5 : update("A",12);
Cette ligne doit mettre à jour la Currency A avec la valeur 12. Or, la Currency A n'existe pas. Ainsi, un message d'erreur devrait apparaitre : "The update of the currency named A with the value 12 did not achieved !"

Ligne 6 : update("Enzo",20);
Cette ligne doit mettre à jour la Currency Enzo avec la valeur 20. Si la mise à jour s'est bien passée, le message affiché sera "The currency named Enzo has been modified with the value 20"

Ligne 7 : getConversion(1, "Euro", "Enzo");
Cette ligne fera la conversion d'1 Euro en Enzo. Si la ligne précédente a bien été effectuée, le message qui devrait s'afficher est "1 Euro => 20 Enzo"

Ligne 8 : getConversion(22.3,"Dollar","Yen");
Cette ligne fera la conversion de 22.3 Dollar en Yen. Le message qui devrait s'afficher est "22.3 Dollar => 2444.5678 Yen".

Ligne 9 : getConversion(50, "Euro", "Roupie");
Cette ligne fera la conversion de 50 Euro en Roupie. Le message qui devrait s'afficher est "50 Euro => 4442.5 Roupie".

Ligne 10 : getConversion(15, "Livre", "Yen");
Cette ligne fera la conversion de 15 Livre en Yen. Le message qui devrait s'afficher est "15 Livre => 2249.1379310343 Yen".
