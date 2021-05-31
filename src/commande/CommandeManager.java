package commande;

import java.util.HashMap;

public class CommandeManager {
	// Table d'hachage qui map les IDs des commandes au objets de commande
	private HashMap<Integer, Commande> commandes = new HashMap<>();

	public CommandeManager() {
		loadSavedCommande();
	}

	// Dans le future, cette methode va chercher les commandes serializer
	private void loadSavedCommande() {

	}

	public int generateCommandeID() {
		return commandes.keySet().size();
	}

	public void putCommande(Commande toAdd) {
		commandes.put(toAdd.getCommandeID(), toAdd);
	}

	public void removeCommande(int commandeID) {
		commandes.remove(commandeID);
	}

	public Commande getCommande(int commandeID) {
		return commandes.get(commandeID);
	}
}
