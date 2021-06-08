package base;
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
		Client nouveauClient = new Client(tel, prenom, adresse, clients.generateClientID());
		clients.putClient(nouveauClient);
	}	
	
	public void ajouterCommande(Client client, String commande, String heure) {
		Commande nouvelleCommande = new Commande(client, commande, heure, commandes.generateCommandeID());
		commandes.putCommande(nouvelleCommande);
	}
	
	public Client trouvClient(String tel) {
		return clients.getClientByTel(tel);
		
	}
	
	public void effacerClient(String tel) {
		clients.removeClient(clients.getClientByTel(tel).getClientID());
	}
	
	public String donnerToutesCommandes() {
		String s="(999)999-9999\tJean\t8 Young\tPizza\t8h15\n(888)888-8888\tPaul\t9 Young\tCalzone\t8h15";
		return s;
	}
	
	public void effacerCommande(String tel) {
		Commande commande = commandes.getClientCommande(trouvClient(tel));
		commandes.removeCommande(commande.getCommandeID());
	}
	
	public void sauverDonnees() {
		serialManager.saveData();
	}
	
	// Comment temporaire
	/*
	public String donnerTousClients() {
		String sortie="";
		for(String[] ss: clients) {
			for(String s:ss)
				sortie+= s+"\t";
			sortie+="\n";
		}
		return sortie;
	}*/
}
