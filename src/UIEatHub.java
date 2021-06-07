
import java.util.Scanner;

/**
 * 
 * @author test
 *
 */
public class UIEatHub {
	static Scanner sca = new Scanner(System.in);  // Create a Scanner object
    static ModelEatHub model = new ModelEatHub(); 
	
	public static void main(String[] args) {
		while(true) {

			//sca.nextLine();
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
 // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	
	static void ajouterClient() {
		
		System.out.print("Ajouter le telephone");
		String tel = sca.nextLine();

		System.out.print("Ajouter le prenom:");
		String prenom = sca.nextLine();

		System.out.print("Ajouter l'addresse:");
		String adr = sca.nextLine();
		sca.nextLine();

		model.ajouterClient(tel, prenom, adr);
	}
	
	static void ajouterCommande() {

		System.out.print("Quel est le teléphone du client");
		String client = sca.nextLine();		

		System.out.print("Quel est la commande");
		String commande = sca.nextLine();		

		System.out.print("Quel est l'heure de livraison");
		String heure = sca.nextLine();
		sca.nextLine();
		
		int numclient=model.trouvClient(client);
		if (numclient!=-1) model.ajouterCommande(numclient, commande, heure);
	}
	
	static void effacerClient() {
		System.out.print("Quel est le teléphone du client");
		String client = sca.next();		
		int numclient=model.trouvClient(client);
		if (numclient!=-1) model.effacerClient(numclient);
	}
	
	static void effacerCommande() {
			System.out.print("Quel est le teléphone du client");
			String client = sca.nextLine();		
			int numclient=model.trouvClient(client);
			if (numclient!=-1) model.effacerCommande(numclient);
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
