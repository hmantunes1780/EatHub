import java.util.HashMap;
import java.util.Scanner;
/**
 * @ Cerise Camama
 *
 */
public class UIEatHub {
	
	static Scanner sca = new Scanner(System.in);  // Create a Scanner object
    static ModelEatHub model = new ModelEatHub(); 
 //-----------------------------------------------------------------Choisissez une option--------------------------------------------------------------
	public static void main(String[] args) {
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

//-----------------------------------------------------------------Ajouter--------------------------------------------------------------	
	public static void ajouterClient() {
		
		
		System.out.print("Ajoutez votre numero de telephone:");
		String tel = sca.next();
		
        System.out.print("Ajoutez l'adresse: ");
		sca.nextLine();
		String adr = sca.nextLine();
		
		System.out.print("Ajoutez votre prenom: ");
		String prenom = sca.next();
		
		System.out.print("Ajoutez votre ville: ");
		String ville = sca.next();	
	
		model.ajouterClient(tel, prenom, adr, ville);
		
	}
	
	static void ajouterCommande() {
		
		System.out.print("Ajoutez le numero de telephone: ");
		String tel = sca.next();
	
		 if(ModelEatHub.clients.containsKey(tel)) {
			System.out.print("Ajoutez la commande: ");
			
			sca.nextLine();
			String com = sca.nextLine();
			
			
			System.out.print("Ajoutez l'heure de livraison: ");
			
			String liv = sca.next(); 
			model.ajouterCommande(com, liv, tel);
		 }
		else {
				System.err.println("Vous n'avez pas encore un compte!(Pensez a en creer un pour une experience plus simple)");
				ajouterClient();
				System.out.println("BRAVO!! VOTRE COMPTE A ETE CREE!!! PASSEZ MAINTENANT VOTRE COMMANDE!\n");
				ajouterCommande();
		}
		
	}
	
//-----------------------------------------------------------------Effacer--------------------------------------------------------------
	static void effacerClient() {

		System.out.print("Ajoutez le numero de telephone assimile au client: ");
		String tel = sca.next();	
        model.trouvClient(tel);
        String tele = tel;
        model.trouvClient(tele);
        
		if(ModelEatHub.clients.containsKey(tel)) {
			ModelEatHub.Client c = model.trouvClient(tel);
			model.effacerClient(c);
			ModelEatHub.commande com = model.trouvCommande(tele);
			model.effacerCommande(com);
		}
		else {
			System.err.println("Pas un client.");

		}
	}
	
	static void effacerCommande() {
		System.out.print("Ajoutez le numero de telephone assimile a la commande: ");
		String tele = sca.next();	
		model.trouvClient(tele);
		if(ModelEatHub.comm.containsKey(tele)) {
			ModelEatHub.commande com = model.trouvCommande(tele);
			model.effacerCommande(com);	
		}
		else {
			System.err.println("Pas une commande.");

		}
	}
	
//-----------------------------------------------------------------Afficher--------------------------------------------------------------
	static void afficherCommandes() {
		System.out.print(model.donnerToutesCommandes());
	}

	
	static void afficherClients() {
		System.out.println(model.donnerTousClients());
	}
	
//-----------------------------------------------------------------Charger---------------------------------------------------------------	
	static void chargerDonnees() {
		SeriEatHub.chargerFichier("FichierEatHub.txt", model);
	}
	
	static void sauverDonnees() {
		SeriEatHub.sauverFichier("FichierEatHub2.txt", model);		
	}
	
}