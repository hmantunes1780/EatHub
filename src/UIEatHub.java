import java.util.Scanner;


public class UIEatHub {
	static Scanner sca = new Scanner(System.in);  // Create a Scanner object
    static ModelEatHub model = new ModelEatHub(); 
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("\nVoulez-vous:\n"
					+ "\t1. Ajouter un client\n"
					+ "\t2. Passer une commade\n"
					+ "\t3. Afficher la liste de tous les clients\n"
					+ "\t4. Afficher la liste de toutes les commandes\n"
					+ "\t5. Effacer une commade\n"
					+ "\t6. Effacer un client\n"
					+ "\t7. Charger un fichier CLient\n"
					+ "\t8. Sauvegarder un fichier client\n"
					+ "\t9. Quitter le programme");

			//suivant la reponse faire des choses differentes
			switch (sca.nextInt()) {
			case 1: ajouterClient(); //afficherClients(); break;
			case 2: ajouterCommande(); //break;
			case 3: afficherClients(); //break;
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
		
		System.out.print("Ajouter le t�l�phone");
		String tel = sca.next();

		System.out.print("Ajouter le pr�nom:");
		String prenom = sca.next();

		System.out.print("Ajouter l'addresse:");
		String adr = sca.next();

		System.out.print("Ajouter la commande");
		String com = sca.next();

		model.ajouterClient(tel, prenom, adr);
	}
	
	static void ajouterCommande() {
		
	}
	
	static void effacerClient() {
		
	}
	
	static void effacerCommande() {
		
	}
	
	static void afficherCommandes() {
		
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
