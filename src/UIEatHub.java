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
			case 1: ajouterClient();afficherClients(); break;
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
		
		System.out.print("Ajouter le telephone\n");
		String tel = sca.nextLine();

		System.out.print("Ajouter le prenom:");
		String prenom = sca.nextLine();

		System.out.print("Ajouter l'addresse:");
		String adr = sca.nextLine();
    sca.nextLine();

		System.out.print("Ajouter la commande");
		String com = sca.nextLine();

		model.ajouterClient(tel, prenom, adr);
	}
	
	static void ajouterCommande() {    // 1.
		System.out.println("Quel est le teléphone du client");
    String client = sca.nextLine();

    System.out.println("Quelle est la commande");
    String commande = sca.nextLine();

    System.out.println("Quelle est l'heur de l'ivraison");
    String heur = sca.nextLine();


    int numeroClient = model.trouvClient(client);
    if (numeroClient!=-1) 
    model.ajouterCommande(numeroClient, commande,heur);
	}
	
	static void effacerClient() {  // 2.
		System.out.print("Quel est le teléphone du client");
			String client = sca.nextLine();		

			int numeroClient = model.trouvClient(client);
      model.effacerClient(numeroClient);

	}
	
	static void effacerCommande() {   // 3. 
		System.out.println("Donner votre numero de telephone:");
		String tel = sca.nextLine();
    int numeroClient = model.trouvClient(tel);
		model.effacerClient(numeroClient);
	}
	
	static void afficherCommandes() {  // 4. 
		System.out.print(model.donnerToutesCommandes());
	}

	
	static void afficherClients() {  // 5. 
		System.out.println(model.donnerTousClients());
	}
	
	
	static void chargerDonnees() {  // 6. 
		SeriEatHub.chargerFichier("FichierEatHub.txt", model);
	}
	
	static void sauverDonnees() {  // 7. 
		SeriEatHub.sauverFichier("FichierEatHub2.txt", model);		
	}
	
}
