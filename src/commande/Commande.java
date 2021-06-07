package commande;

import java.util.UUID;

import client.Client;

public class Commande {
	private Client client;
	private String recette;
	private String temps;
	private UUID commandeID;
	
	public Commande(Client client, String recette, String temps, UUID commandeID) {
		this.client = client;
		this.recette = recette;
		this.temps = temps;
		this.commandeID = commandeID;
	}
	
	public UUID getCommandeID() {
		return commandeID;
	}
	
	public Client getClient() {
		return client;
	}
	
	public String getRecette() {
		return recette;
	}
	
	public String getTemps() {
		return temps;
	}
}
