import client.Client;
import client.ClientManager;
import commande.Commande;
import commande.CommandeManager;

/**
 * Cette classe gère le modèle de données pour Eathub
 * @author shanl
 *
 */
public class ModelEatHub {

	//Variable qui garde les données des clients
	ClientManager clients = new ClientManager();
	CommandeManager commandes = new CommandeManager();

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
	
	public int trouvClient(String codeClients) {
		return -1;
	}
	
	public void effacerClient(int no) {
	}
	
	public String donnerToutesCommandes() {
		String s="(999)999-9999\tJean\t8 Young\tPizza\t8h15\n(888)888-8888\tPaul\t9 Young\tCalzone\t8h15";
		return s;
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
