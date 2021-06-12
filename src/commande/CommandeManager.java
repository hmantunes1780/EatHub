package commande;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import client.Client;

public class CommandeManager implements Serializable {
	// Table d'hachage qui map les IDs des commandes au objets de commande
	private HashMap<UUID, Commande> commandes = new HashMap<>();

	public UUID generateCommandeID() {
		return UUID.randomUUID();
	}

	public void putCommande(Commande toAdd) {
		commandes.put(toAdd.getCommandeID(), toAdd);
	}

	public void removeCommande(UUID commandeID) {
		commandes.remove(commandeID);
	}
	
	public ArrayList<Commande> getClientCommandes(Client client) {
		ArrayList<Commande> clientCommandes = new ArrayList<>();
		for (Commande commande : commandes.values()) {
			if (commande.getClient().getAbsoluteTelephoneNum().equals(client.getAbsoluteTelephoneNum())) {
				clientCommandes.add(commande);
			}
		}
		return clientCommandes;
	}

	public Commande getCommande(UUID commandeID) {
		return commandes.get(commandeID);
	}
	
	public ArrayList<Commande> getToutCommandes() {
		ArrayList<Commande> toutCommandes = new ArrayList<>();
		for (Commande commande : commandes.values()) {
			toutCommandes.add(commande);
		}
		return toutCommandes;
	}
	
	public void serialize(File file) {
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(this);
		} catch (Exception e) {
			System.err.println("Erreur lors de la serialization de CommandeManager!");
		}
	}
}
