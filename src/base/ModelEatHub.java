package base;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

import client.Client;
import client.ClientManager;
import commande.Commande;
import commande.CommandeManager;
import serialization.SerializationManager;

/**
 * Cette classe gère le modèle de données pour Eathub
 * @author shanl
 *
 */
public class ModelEatHub {

	//Variable qui garde les données des clients
	public static ClientManager clients = new ClientManager();
	public static CommandeManager commandes = new CommandeManager();
	public static SerializationManager serialManager;
	
	public ModelEatHub() {
		this.serialManager = new SerializationManager();
	}
	
	public static void setClients(ClientManager clients) {
		for (Client c : clients.getToutClients()) {
			System.out.println(c.getAdresse() + " " + c.getTelephoneNum() + " " + c.getPrenom());
		}
		ModelEatHub.clients = clients;
	}
	
	public static void setCommandes(CommandeManager commandes) {
		ModelEatHub.commandes = commandes;
	}
	
	/**
	 * Méthode pour ajouter un client
	 * @param tel (numéro de téléphone de l'utilisateur)
	 * @param prenom(prénom de l'utilisateur)
	 * @param adresse(adresse de l'utilisateur)
	 */
	public void ajouterClient(String tel, String prenom, String adresse) {
		String absTel = Client.stripTelephoneNum(tel);
		
		if (clients.getClientByAbsTel(absTel) != null) {
			System.out.println("Erreur, ce client existe deja!");
			return;
		}
		
		Client nouveauClient = new Client(tel, prenom, adresse, clients.generateClientID());
		clients.putClient(nouveauClient);
	}	
	
	public void ajouterCommande(Client client, String commande, String heure) {
		Commande nouvelleCommande = new Commande(client, commande, heure, commandes.generateCommandeID());
		commandes.putCommande(nouvelleCommande);
	}
	
	public Client trouvClient(String tel) {
		return clients.getClientByAbsTel(Client.stripTelephoneNum(tel));
		
	}
	
	public void effacerClient(String tel) {
		Client client = clients.getClientByAbsTel(Client.stripTelephoneNum(tel));
		
		if (client == null) {
			System.out.println("Erreur, ce client n'existe pas!");
			return;
		}
		
		clients.removeClient(client.getClientID());
	}
	
	public String donnerToutesCommandes() {
		String toPrint = "";
		for (Commande commande : commandes.getToutCommandes()) {
			String line = "Tel: " + commande.getClient().getTelephoneNum()
					+ "\t Addresse: " + commande.getClient().getAdresse()
					+ "\t Temps: " + commande.getTemps()
					+ "\t Recette: " + commande.getRecette() + "\n";
			toPrint += line;
		}
		if (toPrint.equals("")) {
			return "Aucune commande ajouter...";
		}
		return toPrint;
	}
	
	public void effacerCommande(UUID commandeID) {
		commandes.removeCommande(commandeID);
	}
	
	public HashMap<UUID, Entry<Integer, String>> getClientCommandes(String tel) {
		HashMap<UUID, Entry<Integer, String>> clientCommandes = new HashMap<>();
		Client client = clients.getClientByAbsTel(Client.stripTelephoneNum(tel));
		int i = 1;
		for (Commande commande : commandes.getClientCommandes(client)) {
			String line = i + ". | Temps: " + commande.getTemps()
					+ "\t Recette: " + commande.getRecette() + "\n";
			clientCommandes.put(commande.getCommandeID(), new AbstractMap.SimpleEntry<Integer, String>(i, line));
			i++;
		}
		return clientCommandes;
	}
	
	public void sauverDonnees() {
		serialManager.saveData();
	}
	
	public String donnerTousClients() {
		String toPrint = "";
		for (Client client : clients.getToutClients()) {
			String line = "Tel: " + client.getTelephoneNum()
					+ "\t Prenom: " + client.getPrenom()
					+ "\t Adresse: " + client.getAdresse() + "\n";
			toPrint += line;
		}
		if (toPrint.equals("")) {
			return "Aucun client ajouter...";
		}
		return toPrint;
	}
}
