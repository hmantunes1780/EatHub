import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeriEatHub {

	public static void chargerFichier(String nomFichier, ModelEatHub model) {
	    try {
	        File myObj = new File(nomFichier);
	        Scanner myReader = new Scanner(myObj);
	                
	          //ajoute le 1er client
	          String Tel = myReader.nextLine();
	          String Nom = myReader.nextLine();
	          String adresse = myReader.nextLine();
	          model.ajouterClient(Tel, Nom, adresse, "Mississauga");

	          //ajoute le 2e client
	          Tel = myReader.nextLine();
	          Nom = myReader.nextLine();
	          adresse = myReader.nextLine();
	          model.ajouterClient(Tel, Nom, adresse, "Mississauga");
	          
	        myReader.close();
	      } catch (Exception e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
    }

	public static void sauverFichier(String nomFichier, ModelEatHub model) {
		
    }



}
