package currency.management.web.resource;
import java.net.*;
import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import currency.management.web.data.*;
import currency.management.web.service.*;

/**
 * @file CurrencyResource.java
 * Classe qui s'occupe de toutes les réponses vers le client concernant les fonctions sur les Currency
 * @author OBEYESEKARA Avishka, CERINI Enzo
 * @version 1.0
 * @date 15/04/2021
 *
 * Classe contenant les réponses faites au client concernant les fonctions associées aux Currency.
 */
@Path("/currency")
public class CurrencyResource {

	CurrencyService service = new CurrencyService();
	ArrayList<Currency> conversionEuro;
	
	
	@Context
	UriInfo uriInfo;
	
	/**
	 * Response addCurrency(String key, double nouvelleMonnaie)
	 * Fonction qui retourne une réponse au client après l'ajout d'une nouvelle Currency
	 * @param key Nom de la nouvelle Currency (Type String)
	 * @param nouvelleMonnaie Valeur de la nouvelle Currency (Type Double)
	 * @return Retourne une réponse positive si la Currency a été créée, une réponse négative sinon 
	 */
	@POST
	@Path("/adding/{key}/{nouvelleMonnaie}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addCurrency(@PathParam("key") String key, @PathParam("nouvelleMonnaie") double nouvelleMonnaie) {
		Currency currency = service.addCurrency(key, nouvelleMonnaie);
		if(currency == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath() + "/" + currency.getName();
		return Response.status(Response.Status.CREATED)
		.entity(currency)
		.contentLocation(uri.resolve(newUri))
		.build();
	}
	
	
	/**
	 * Response conversion(double monnaieEntree, String typeEntree, String typeSortie)
	 * Fonction qui retourne une réponse au client après la conversion
	 * @param monnaieEntree Somme que nous voulons convertir (Type Double)
	 * @param typeEntree Devise que nous voulons convertir (Type String)
	 * @param typeSortie Devise vers laquelle nous voulons convertir (Type String)
	 * @return Retourne une réponse positive si la conversion a été réalisée, une réponse négative sinon 
	 */
	@GET
	@Path("/conversion/{monnaieEntree}/{typeEntree}/{typeSortie}")
	@Produces(MediaType.APPLICATION_XML)
	public Response conversion(@PathParam("monnaieEntree") double monnaieEntree, @PathParam("typeEntree") String typeEntree, @PathParam("typeSortie") String typeSortie) {
		Double monnaie = service.conversion(monnaieEntree, typeEntree, typeSortie);
		if(monnaie == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri())
				.rel("self")
				.type("application/xml")
				.build();
		
		return Response.status(Response.Status.OK)
				.entity(monnaie)
				.links(link)
				.build();
	}

	/**
	 * Response updateCurrency(String name, double newRate)
	 * Fonction qui retourne une réponse au client après la mise à jour d'une Currency
	 * @param name Nom de la Currency que nous voulons changer (Type String)
	 * @param newRate Nouvelle valeur que nous voulons attribuer à la Currency (Type Double)
	 * @return Retourne une réponse positive si la Currency a été mise à jour, une réponse négative sinon 
	 */
	@PUT
	@Path("/update/{name}/{newRate}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateCurrency(@PathParam("name") String name, @PathParam("newRate") double newRate) {
		boolean update = service.updateCurrency(name, newRate);
		if(update == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).build();	
	}
	 
	/**
	 * Response info(String currency)
	 * Fonction qui retourne une réponse au client avec les informations concernant la devise
	 * @param currency Devise dont nous voulons les informations (Type String)
	 * @return Retourne une réponse négative si la Currency n'a pas été trouvée, une réponse positive sinon 
	 */
	@GET
	@Path("/info/{currency}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response info(@PathParam("currency") String currency) {
		String info = service.readWikiApi(currency);
		if(info == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri())
				.rel("self")
				.type("application/xml")
				.build();
		
		return Response.status(Response.Status.OK)
				.entity(info)
				.links(link)
				.build();
	}
	
}
