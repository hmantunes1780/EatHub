package base;
import java.util.Scanner;

import client.Client;


public class UIEatHub {
	public static Scanner sca;  // Create a Scanner object
    static ModelEatHub model;
	
	public static void main(String[] args) {
		model = new ModelEatHub();
		sca = new Scanner(System.in);
		while(true) {
			System.out.println("\nVoulez-vous:\n"
					+ "\t1. Ajouter un client\n"
					+ "\t2. Passer une commande\n"
					+ "\t3. Afficher la liste de tous les clients\n"
					+ "\t4. Afficher la liste de toutes les commandes\n"
					+ "\t5. Effacer une commande\n"
					+ "\t6. Effacer un client\n"
					+ "\t7. Charger un fichier CLient\n"
					+ "\t8. Sauvegarder un fichier client\n"
					+ "\t9. Quitter le programme");

			//suivant la reponse faire des choses differentes
		//	if(!sca.hasNextInt())sca.reset(); 
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
			default: return;
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
	}
	
	static void ajouterCommande() {
	System.out.println("Est-ce que vous êtes un client?");
	String existantClient = sca.nextLine();
	if(existantClient == "oui") {
		System.out.println("Quel est votre numéro de téléphone?");
		String TelClientExist = sca.nextLine();
		Client client = model.trouvClient(TelClientExist);
	}else {
		ajouterClient();
	}
	System.out.println("Quelle est votre commande?");
	String commande = sca.nextLine();
	}
	
	static void effacerClient() {
		System.out.println("Donne numero de telephone");
		String tel = sca.nextLine();
		
		model.effacerClient(tel);
	}
	
	static void effacerCommande() {
		System.out.println("Donnez votre numéro de telephone");
		String tel = sca.nextLine();
	}
	
	static void afficherCommandes() {
		
	}

	
	static void afficherClients() {
		for (Client c : ModelEatHub.clients.getToutClients()) {
			System.out.println(c.getPrenom() + " addr: " + c.getAdresse() + " tel: " + c.getTelephoneNum());
		}
		// Comment temporaire
		//System.out.println(model.donnerTousClients());
	}
	
	
	static void chargerDonnees() {                     
		SeriEatHub.chargerFichier("FichierEatHub.txt", model);
	}
	
	static void sauverDonnees() {
		model.sauverDonnees();
	}
	
}
