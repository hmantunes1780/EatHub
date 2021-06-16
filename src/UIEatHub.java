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
					+ "\t2. Passer une commande\n"
					+ "\t3. Afficher la liste de tous les clients\n"
					+ "\t4. Afficher la liste de toutes les commandes\n"  
					+ "\t5. Effacer une commande\n"
					+ "\t6. Effacer un client\n"
					+ "\t7. Charger un fichier Client\n"
					+ "\t8. Sauvegarder un fichier client\n"
					+ "\t9. Quitter le programme");

			//suivant la reponse faire des choses differentes
			switch (sca.nextInt()) {
			case 1: ajouterClient();  break;
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

		  System.out.println("------------MENU------------");
		  System.out.println("1. Burger");
		  System.out.println("2. Salade");
		  System.out.println("3. Poutine");
		  System.out.println("4. Pizza");
		  System.out.println("5. Lasagne");
		  System.out.println("------------MENU------------");
		  System.out.println("Veuillez faire votre choix!");
		  int commande = sca.nextInt();
		  double prix = 0;
		  
		  switch (commande) {
		  case 1:
			  prix = 15.0;
			  sca.nextLine();
			  System.out.println("Veuillez entrer votre numéro de téléphone:");
			  String client = sca.nextLine();
			  System.out.println("Veuillez entrer l'heure de livraison (heure):");
			  int heure = sca.nextInt();
		 while (heure < 9 || heure>20) {
			 System.out.println("Le temps que vous avez entrer ne peut pas être plus bas que 9 heure du matin ou plus haut que 8 heure du soir");
			 heure = sca.nextInt();
		 }
		 
		 int numclient=model.trouvClient(client);
			
			if (numclient!=-1) {
				model.ajouterCommande(numclient, commande, heure); 
			}
		  
		 System.out.println("Votre commande est passé dans notre système!");
		 System.out.println("Vous avez commandé: Burger!");
		 System.out.println("L'heure de livraison:" + " " + heure + "h");
		 System.out.println("Prix du burger:" + " " + prix + "$");
		 break;
		  
		  case 2:
			  prix = 10.0;
			  sca.nextLine();
			  System.out.println("Veuillez entrer votre numéro de téléphone:");
			  String client1 = sca.nextLine();
			  System.out.println("Veuillez entrer l'heure de livraison (heure):");
			  int heure1 = sca.nextInt();
		 while (heure1 < 9 || heure1>20) {
			 System.out.println("Le temps que vous avez entrer ne peut pas être plus bas que 9 heure du matin ou plus haut que 8 heure du soir");
			 heure1 = sca.nextInt();
		 }
		 
		 int numclient1=model.trouvClient(client1);
			
			if (numclient1!=-1) {
				model.ajouterCommande(numclient1, commande, heure1); 
			}
		  
		 System.out.println("Votre commande est passé dans notre système!");
		 System.out.println("Vous avez commandé: Salade!");
		 System.out.println("L'heure de livraison:" + " " + heure1 + "h");
		 System.out.println("Prix du burger:" + " " + prix + "$");	  
		 break;
		  
		  case 3:
			  prix = 7.0;
			  sca.nextLine();
			  System.out.println("Veuillez entrer votre numéro de téléphone:");
			  String client2 = sca.nextLine();
			  System.out.println("Veuillez entrer l'heure de livraison (heure):");
			  int heure2 = sca.nextInt();
		 while (heure2 < 9 || heure2>20) {
			 System.out.println("Le temps que vous avez entrer ne peut pas être plus bas que 9 heure du matin ou plus haut que 8 heure du soir");
			 heure2 = sca.nextInt();
		 }
		 
		 int numclient2=model.trouvClient(client2);
			
			if (numclient2!=-1) {
				model.ajouterCommande(numclient2, commande, heure2); 
			}
			
		  
		 System.out.println("Votre commande est passé dans notre système!");
		 System.out.println("Vous avez commandé: Poutine!");
		 System.out.println("L'heure de livraison:" + " " + heure2 + "h");
		 System.out.println("Prix du burger:" + " " + prix + "$");	  
		 break;
		  
		  
		  case 4:
			  prix = 12.0;
			  sca.nextLine();
			  System.out.println("Veuillez entrer votre numéro de téléphone:");
			  String client3 = sca.nextLine();
			  System.out.println("Veuillez entrer l'heure de livraison (heure):");
			  int heure3 = sca.nextInt();
		 while (heure3 < 9 || heure3>20) {
			 System.out.println("Le temps que vous avez entrer ne peut pas être plus bas que 9 heure du matin ou plus haut que 8 heure du soir");
			 heure3 = sca.nextInt();
		 }
		 
		 int numclient3=model.trouvClient(client3);
			
			if (numclient3!=-1) {
				model.ajouterCommande(numclient3, commande, heure3); 
			}
		  
		 System.out.println("Votre commande est passé dans notre système!");
		 System.out.println("Vous avez commandé: Pizza!");
		 System.out.println("L'heure de livraison:" + " " + heure3 + "h");
		 System.out.println("Prix du burger:" + " " + prix + "$");	   
		  break;
		  
		  
		  case 5:
			  prix = 5.0;
			  sca.nextLine();
			  System.out.println("Veuillez entrer votre numéro de téléphone:");
			  String client4 = sca.nextLine();
			  System.out.println("Veuillez entrer l'heure de livraison (heure):");
			  int heure4 = sca.nextInt();
		 while (heure4 < 9 || heure4>20) {
			 System.out.println("Le temps que vous avez entrer ne peut pas être plus bas que 9 heure du matin ou plus haut que 8 heure du soir");
			 heure4 = sca.nextInt();
		 }
		 
		 int numclient4=model.trouvClient(client4);
			
			if (numclient4!=-1) {
				model.ajouterCommande(numclient4, commande, heure4); 
			}
		  
		 System.out.println("Votre commande est passé dans notre système!");
		 System.out.println("Vous avez commandé: Lasagne!");
		 System.out.println("L'heure de livraison:" + " " + heure4 + "h");
		 System.out.println("Prix du burger:" + " " + prix + "$");	  
		 break;
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  } // end of switch
		  
		  
		   
	
		  
		  
		  
		  
		  
		   
		   
		   
}


	

	
  
	
	static void effacerClient() {
		
		System.out.print("Quel est le téléphone du client?");
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
			model.trouvClient(tel);
			int numclient2=model.trouvClient(tel);
				model.effacerCommande(numclient2);
	
				
	/*	System.out.println("Voulez-vous effacer votre nom dans notre système? Si oui, inserez votre nom!");
		String prenom = sca.next();
				
		if (prenom == model.donnerTousClients()) {
			model.effacerClient(numclient2);
		} */

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
