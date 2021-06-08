import java.util.Scanner;

/**
 * @ Cerise Camama
 *
 */
public class UIEatHub {
	static Scanner sca = new Scanner(System.in);  // Create a Scanner object
    static ModelEatHub model = new ModelEatHub(); 

	
	public static void main(String[] args) {
		while(true) {
	
      
			System.out.println("\nVoulez-vous:\n"
					+ "\t1. Ajouter un client\n"
					+ "\t2. Passer une commande\n"
					+ "\t3. Afficher la liste de tous les clients\n"
					+ "\t4. Afficher la liste de toutes les commandes\n"  
					+ "\t5. Effacer une commade\n"
					+ "\t6. Effacer un client\n"
					+ "\t7. Charger un fichier CLient\n"
					+ "\t8. Sauvegarder un fichier client\n"
					+ "\t9. Quitter le programme");

			//suivant la reponse faire des choses differentes
			switch (sca.nextInt()) {
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
		
		
		System.out.print("Ajouter le telephone:");
		String tel = sca.next();
		
        System.out.print("Ajouter l'addresse:");
		sca.nextLine();
		String adr = sca.nextLine();
		
		System.out.print("Ajouter le prenom:");
		String prenom = sca.next();
		
		System.out.print("Ajouter la ville:");
		String ville = sca.next();	
	
		model.ajouterClient(tel, prenom, adr, ville);
	}
	
	static void ajouterCommande() {
		/*System.out.print("Ajouter le telephone");
		String tel = sca.next();
	    
		System.out.print("Numéro de client? ex : 1, 2, 3...");
		int lastClient= sca.nextInt();
		
		 if(ModelEatHub.clients.containsValue(tel)) {
			System.out.print("Ajouter la commande");
			sca.nextLine();
			String com = sca.nextLine();
			ModelEatHub.clients = com;
			
			
			System.out.print("Ajouter l'heure de livraison");
			String liv = sca.next(); 
			ModelEatHub.clients[lastClient][4] = liv;
			model.ajouterCommande(com, liv);
		 }
		else {
				System.err.print("Incorrecte numero de telephone");
		}*/
		
	}
	
	static void effacerClient() {
		/*System.out.print("Quel client doit être effacé ?");
		int lastClient = sca.nextInt();
		
		System.out.print("Ajouter le telephone");
		String tel = sca.next();
		
		
		if(ModelEatHub.clients[lastClient][0].contains(tel)) {
			ModelEatHub.clients[lastClient][0] = null;
		    ModelEatHub.clients[lastClient][1] = null;
		    ModelEatHub.clients[lastClient][2] = null;
		    ModelEatHub.clients[lastClient][3] = null;
		    ModelEatHub.clients[lastClient][4] = null;
		}
		else {
			System.out.println("Pas un client.");

		}*/
	}
	
	static void effacerCommande() {
		/*System.out.println("Quel client?");
		int lastClient  = sca.nextInt();
		
		System.out.print("Quelle commande?");
		sca.nextLine();
		String com = sca.nextLine(); 
		
		if(ModelEatHub.clients[lastClient][3].contains(com)) {
			ModelEatHub.clients[lastClient][3] = null;
		    ModelEatHub.clients[lastClient][4] = null;
		}
		else {
			System.out.println("Pas une commande.");
		}*/
	}
	
	static void afficherCommandes() {
		System.out.print(model.donnerToutesCommandes());
	}

	
	static void afficherClients() {
		System.out.println(model.donnerTousClients());
	}
	
	
	static void chargerDonnees() {
		SeriEatHub.chargerFichier("FichierEatHub.txt", model);
	}
	
	static void sauverDonnees() {
		SeriEatHub.sauverFichier("FichierEatHub2.txt", model);		
	}
	
}