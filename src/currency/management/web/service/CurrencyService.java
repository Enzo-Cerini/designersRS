package currency.management.web.service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;

import currency.management.web.data.Currency;

/**
 * @file CurrencyService.java
 * Classe qui s'occupe de toutes les opérations concernant les Currency
 * @author OBEYESEKARA Avishka, CERINI Enzo
 * @version 1.0
 *
 * Classe contenant toutes les fonctions associées aux Currency.
 */
public class CurrencyService {
	ArrayList<Currency> conversionEuro;
	
	public CurrencyService() {
		conversionEuro = new ArrayList<Currency>();
		conversionEuro.add(new Currency("Dollar", 1.19));
		conversionEuro.add(new Currency("Livre", 0.87));
		conversionEuro.add(new Currency("Yen", 130.45));
		conversionEuro.add(new Currency("Roupie", 88.85));
	}
	

	/**
	 * Double conversion(double monnaieEntree, String typeEntree, String typeSortie)
	 * Fonction qui convertie une devise en une autre
	 * @param monnaieEntree Somme que nous voulons convertir (Type Double)
	 * @param typeEntree Devise que nous voulons convertir (Type String)
	 * @param typeSortie Devise vers laquelle nous voulons convertir (Type String)
	 * @return Retourne un Double qui sera le résultat de la conversion
	 */
	
	public Double conversion(double monnaieEntree, String typeEntree, String typeSortie) {
		double monnaieSortie = 0;
		
		if(typeSortie.equals("Euro")) {
			for(int i = 0; i<conversionEuro.size(); i++) {
				if(conversionEuro.get(i).getName().equals(typeEntree))  {
					monnaieSortie = monnaieEntree/conversionEuro.get(i).getValue();
				}
			}
		}
		else if(typeEntree.equals("Euro")) {
			for(int i = 0; i<conversionEuro.size(); i++) {
				if(conversionEuro.get(i).getName().equals(typeSortie)) {
					monnaieSortie = monnaieEntree*conversionEuro.get(i).getValue();
				}
			}
		}
		else if(!typeEntree.equals("Euro")) {
			double intermediaireEntree = 0;
			double intermediaireSortie = 0;
			for(int i = 0; i<conversionEuro.size(); i++) {
				if(conversionEuro.get(i).getName().equals(typeEntree)) {
					intermediaireEntree = conversionEuro.get(i).getValue();
				}
				else if(conversionEuro.get(i).getName().equals(typeSortie)) {
					intermediaireSortie = conversionEuro.get(i).getValue();
				}
			}
			
			monnaieSortie = (monnaieEntree/intermediaireEntree)*intermediaireSortie;
			
		}
		return monnaieSortie;
	}

	/**
	 * Currency addCurrency(String key, double nouvelleMonnaie)
	 * Fonction permettant d'ajouter une nouvelle Currency à la liste des Currency déjà existante 
	 * @param key Nom de la nouvelle Currency (Type String)
	 * @param nouvelleMonnaie Valeur de la nouvelle Currency (Type Double)
	 * @return Retourne la nouvelle Currency qui a été créée
	 */
	public Currency addCurrency(String key, double nouvelleMonnaie) {
		Currency currency = new Currency(key, nouvelleMonnaie);
		conversionEuro.add(currency);
		return currency;
	}

	/**
	 * boolean updateCurrency(String name, double newRate)
	 * Fonction qui met à jour une Currency déjà existante
	 * @param name Nom de la Currency que nous voulons changer (Type String)
	 * @param newRate Nouvelle valeur que nous voulons attribuer à la Currency (Type Double)
	 * @return Retourne true si l'opération s'est déroulée avec succès, false sinon
	 */
	public boolean updateCurrency(String name, double newRate) {
		for(int i = 0; i < conversionEuro.size(); i++) {
			if(conversionEuro.get(i).getName().equals(name)) {
				conversionEuro.get(i).setValue(newRate);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * String readWikiApi(String word)
	 * Fonction qui retourne un petit texte d'informations concernant une devise passée en paramètre
	 * @param word Devise dont nous voulons les informations (Type String)
	 * @return Retourne un String avec les informations de la devise
	 */
	public String readWikiApi(String word) {
		try {
			
			if(word.equals("Livre")) {
				word = "Pound_sterling";
			}
			if(word.equals("Roupie")) {
				word = "Indian_rupee";
			}
			
			
			String wikipediaApiJSON = "https://www.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=" + word;
			
		
			//"extract":" the summary of the article
			HttpURLConnection httpcon = (HttpURLConnection) new URL(wikipediaApiJSON).openConnection();
			httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
			
			//Read line by line
			String responseSB = in.lines().collect(Collectors.joining());
			in.close();
			
			//Print the result for us to see
			String result = responseSB.split("extract\":\"")[1];
			
			
			
			int index = result.indexOf("\\n");
			StringBuilder newString = new StringBuilder(result);
			while(index != -1) {
		        newString.setCharAt(index, '\n');
		        newString.deleteCharAt(index+1);
		        index = newString.indexOf("\\n");
			}
			
			index = newString.indexOf("}");

			while(index != -1) {
		        newString.setCharAt(index, '\n');
		        newString.deleteCharAt(index+1);
		        index = newString.indexOf("}");
			}
			
			index = newString.indexOf("\\u");
			while(index != -1) {
				newString.delete(index, index+6);
				index = newString.indexOf("\\u");
			}
			
			index = newString.indexOf(";");
			while(index != -1) {
				newString.deleteCharAt(index);
				index = newString.indexOf("\\u");
			}
			
			return newString.toString();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "";
	}
	
	

}
