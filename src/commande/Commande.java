package commande;

import client.Client;

public class Commande {
	private Client client;
	private String recette;
	private String temps;
	private int commandeID;
	
	public Commande(Client client, String recette, String temps, int commandeID) {
		this.client = client;
		this.recette = recette;
		this.temps = temps;
		this.commandeID = commandeID;
	}
	
	public int getCommandeID() {
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
