package base;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

import client.Client;


public class UIEatHub {
	public static Scanner sca;  // Create a Scanner object
    static ModelEatHub model;
	
	public static void main(String[] args) {
		model = ModelEatHub.getInstance();
		sca = new Scanner(System.in);
		while(true) {
			System.out.println("\nVoulez-vous:\n"
					+ "\t1. Ajouter un client\n"
					+ "\t2. Passer une commande\n"
					+ "\t3. Afficher la liste de tous les clients\n"
					+ "\t4. Afficher la liste de toutes les commandes\n"
					+ "\t5. Effacer une commande\n"
					+ "\t6. Effacer un client\n"
					+ "\t7. Charger un fichier Client\n"
					+ "\t8. Sauvegarder un fichier client\n"
					+ "\t9. Quitter le programme");

			//suivant la reponse faire des choses differentes
			int input = 0;
			try {
				input = Integer.valueOf(sca.nextLine());
			} catch (Exception e) {
				System.out.println("Entre un numero de 1 a 9!");
				continue;
			}
			
			switch (input) {
			case 1: ajouterClient(); break;
			case 2: ajouterCommande(); break;
			case 3: afficherClients(); break;
			case 4: afficherCommandes(); break;
			case 5: effacerCommande(); break;
			case 6: effacerClient(); break;
			case 7: chargerDonnees(); break;
			case 8: sauverDonnees(); break;
			default: 
				sauverDonnees();
				return;
			}
		}
	}

	static void ajouterClient() {
		System.out.println("Ajouter le telephone:");
		String tel = sca.nextLine();

		System.out.println("Ajouter le prenom:");
		String prenom = sca.nextLine();

		System.out.println("Ajouter l'addresse:");
		String adr = sca.nextLine();

		model.ajouterClient(tel, prenom, adr);
		System.out.println("Client '" + prenom + "' ajouter!");
	}
	
	static void ajouterCommande() {
		System.out.println("Est-ce que vous êtes un client? (O/N)");
		String existantClient = sca.nextLine();
		Client client = null;
		if(existantClient.equalsIgnoreCase("O")) {
			System.out.println("Quel est votre numéro de téléphone?");
			String TelClientExist = sca.nextLine();
			client = model.trouvClient(TelClientExist);
		} else {
			ajouterClient();
			ajouterCommande();
		}
		System.out.println("Quelle est votre commande?");
		String commande = sca.nextLine();
		
		System.out.println("Pour quelle temps?");
		String temps = sca.nextLine();
		
		model.ajouterCommande(client, commande, temps);
		System.out.println("Commande '" + commande + "' ajouter pour " + temps + "!");
	}
	
	static void effacerClient() {
		System.out.println("Donne numero de telephone");
		String tel = sca.nextLine();
		
		model.effacerClient(tel);
		System.out.println("Client effacer!");
	}
	
	static void effacerCommande() {
		System.out.println("Donnez votre numéro de telephone");
		String tel = sca.nextLine();
		
		HashMap<UUID, Entry<Integer, String>> commandes = model.getClientCommandes(tel);
		if (commandes.isEmpty()) {
			System.out.println("Aucune commande pour ce client...");
			return;
		}
		System.out.println("Quelle commande voulez vous effacer?");
		for (Entry<Integer, String> entry : commandes.values()) {
			System.out.println(entry.getValue());
		}
		int index = -1;
		while (true) {
			try {
				index = Integer.valueOf(sca.nextLine());
				if (index > commandes.size() || index < 1) {
					System.out.println("Aucune commande trouver! Essaie encore.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Cela n'est pas un numero! Essaie encore.");
			}
		}
		
		for (UUID key : commandes.keySet()) {
			Entry<Integer, String> entry = commandes.get(key);
			
			if (entry.getKey() == index) {
				model.effacerCommande(key);
				System.out.println("Commande effacer!");
				break;
			}
		}
	}
	
	static void afficherCommandes() {
		System.out.println(model.donnerToutesCommandes());
	}

	
	static void afficherClients() {
		System.out.println(model.donnerTousClients());
	}
	
	
	static void chargerDonnees() {                     
		System.out.println("Quel est leur numero de telephone?");
		String tel = sca.nextLine();
		
		Client client = model.trouvClient(tel);
		if (client == null) {
			System.out.println("Aucun client trouver...");
			return;
		}
		System.out.println(ModelEatHub.printClient(client));
	}
	
	static void sauverDonnees() {
		model.sauverDonnees();
		System.out.println("Donnees sauveguarder!");
	}
	
}
