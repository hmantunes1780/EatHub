import java.util.Scanner;
import java.util.Random;

//TODO: 

/**
 * 
 * @author adrien
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
			case 1: ajouterClient(); afficherClients(); break;
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
		sca.nextLine();
		System.out.print("Ajouter votre numero de téléphone: ");
		String tel = sca.nextLine();

		System.out.print("Ajouter votre prénom: ");
		String prenom = sca.nextLine();

		System.out.print("Ajouter votre adresse: ");
		String adr = sca.nextLine();
	
		model.ajouterClient(tel, prenom, adr);
System.out.println("Votre nom," + " " + prenom + " " + "a été ajouté dans notre système avec le téléphone" + " " + tel + " " + " et l'adresse" + " " + adr + "." + " " + "Veuillez entrer 2 si vous voulez commander!");
	}

	

	
   static void ajouterCommande() {

		System.out.print("Quel est le téléphone du client");
		String client = sca.next();		
	
		System.out.print("Quel est la commande");
		String commande = sca.next();		

		System.out.print("Quel est l'heure de livraison");
		String heure = sca.next();
		
		int numclient=model.trouvClient(client);
		
		if (numclient!=-1) {
			model.ajouterCommande(numclient, commande, heure);
			System.out.println("Votre commande de" + " " + commande + " " + "sera delivré à" + " " + heure + "!");
		}
	
	}
	
	static void effacerClient() {
		
		System.out.print("Quel est le téléphone du client");
		//int numclient= sca.nextInt();	
		sca.nextLine();
		String numclient= sca.nextLine();
		model.trouvClient(numclient);
		
		int numclient1=model.trouvClient(numclient);
	
		if (numclient1!=-1) {
			model.effacerClient(numclient1);
			System.out.println(numclient1 + " " + "effacé dans notre système!");
		
		} else {
			System.err.println("Pas un client dans notre système");
		}
	}

	
	static void effacerCommande() {
			System.out.print("Quel est le téléphone du client?");
			String tel = sca.next();
	
			int numclient2=model.trouvClient(tel);
				model.effacerCommande(numclient2);
	

	}


	
	
	static void afficherCommandes() {
	if (model.donnerToutesCommandes() == null) {
		System.out.println("Aucune commande dans notre système");
	} else {
		System.out.print(model.donnerToutesCommandes());	
	
	}
	
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
