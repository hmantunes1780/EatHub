package commande;

import java.util.HashMap;
import java.util.UUID;

import client.Client;

public class CommandeManager {
	// Table d'hachage qui map les IDs des commandes au objets de commande
	private HashMap<UUID, Commande> commandes = new HashMap<>();

	public CommandeManager() {
		loadSavedCommande();
	}

	// Dans le future, cette methode va chercher les commandes serializer
	private void loadSavedCommande() {

	}

	public UUID generateCommandeID() {
		return UUID.randomUUID();
	}

	public void putCommande(Commande toAdd) {
		commandes.put(toAdd.getCommandeID(), toAdd);
	}

	public void removeCommande(UUID commandeID) {
		commandes.remove(commandeID);
	}
	
	public Commande getClientCommande(Client client) {
		for (Commande commande : commandes.values()) {
			if (commande.getClient().getTelephoneNum().equalsIgnoreCase(client.getTelephoneNum())) {
				return commande;
			}
		}
		return null;
	}

	public Commande getCommande(UUID commandeID) {
		return commandes.get(commandeID);
	}
}
