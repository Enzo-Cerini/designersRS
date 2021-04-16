package currency.management.web.data;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @file Currency.java
 * Classe qui permet de créer l'objet Currency
 * @author OBEYESEKARA Avishka, CERINI Enzo
 * @version 1.0
 *
 * Classe associée à la création d'une Currency.
 *
 */
@XmlRootElement
public class Currency {
	private String name;
	private double value;
	
	public Currency() {}
	
	/**
	 * Currency constructeur
	 * @param name Nom de la Currency (Type String)
	 * @param value Valeur de la Currency (Type Double)
	 */
	public Currency(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * String getName()
	 * Fonction qui retourne le nom de la Currency
	 * @return Le nom de la Currency
	 */
	public String getName() {
		return name;
	}

	/**
	 * void setName(String name)
	 * Fonction qui met à jour le nom de la Currency
	 * @param name Nouveau nom de la Currency (Type String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * double getValue()
	 * Fonction qui retourne la valeur de la Currency
	 * @return La valeur de la Currency
	 */
	public double getValue() {
		return value;
	}

	/**
	 * void setValue(double value)
	 * Fonction qui met à jour la valeur de la Currency
	 * @param value Nouvelle valeur de la Currency (Type Double)
	 */
	
	public void setValue(double value) {
		this.value = value;
	}
	
	 /**
     * String toString()
     * Fonction qui retourne un String
     * @return Retourne un String
     */
	@Override
	public String toString() {
		return "name : " + name + " Value : " + value;
	}
}
	


