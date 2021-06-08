
import java.util.Scanner;
import java.util.Random;




/**
 * 
 * @author adrien
 *
 */
public class UIEatHub {
	

	static Scanner sca = new Scanner(System.in);  // Create a Scanner object
    static ModelEatHub model = new ModelEatHub(); 
	
    String[] nom = new String[15]; //nom des gens qui passent les commandes
    String []nourriture = new String [4]; // commande
    int[] temps = new int [4]; //temps de livraison
    String [] adresses = new String [4]; // adresses des clients
    int [] status = new int [4]; // le status de livraison
    double [] prixTotal = new double [4]; // prix commande

    
    
    String [] nomNourriture = {"TEST1\t","TEST2\t","TEST3\t"};
   double [] prix = {4,5,6};
   
   
    
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


	static void ajouterClient() {
		
		System.out.print("Ajouter votre numéro de téléphone: ");
		String tel = sca.next();

		System.out.print("Ajouter votre prénom: ");
		String prenom = sca.next();

		System.out.print("Ajouter votre adresse: ");
		String adr = sca.next();
	
		model.ajouterClient(tel, prenom, adr);
		System.out.println("Ton adresse est: "  + adr);
		System.out.println("Ton telephone est: "  + tel);
		System.out.println("Ton prenom est: "  + prenom);
	
	}
   
	
   static void ajouterCommande() {

		System.out.print("Quel est le teléphone du client");
		String client = sca.next();		

		System.out.print("Quel est la commande");
		String commande = sca.next();		

		System.out.print("Quel est l'heure de livraison");
		String heure = sca.next();
		
		
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
