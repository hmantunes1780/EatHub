import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
* @author Errol
*/

public class SeriEatHub {

	public static void chargerFichier(String nomFichier, ModelEatHub model) {  
	    try {
	        File myObj = new File(nomFichier);
	        Scanner myReader = new Scanner(myObj);
          int i=0;
          while(i<clients){
            //ajoute le 1er client
	          String Tel = myReader.nextLine();
	          String Nom = myReader.nextLine();
	          String adresse = myReader.nextLine();
	          model.ajouterClient(Tel, Nom, adresse);
          }
	          /*
            //ajoute le 1er client
	          String Tel = myReader.nextLine();
	          String Nom = myReader.nextLine();
	          String adresse = myReader.nextLine();
	          model.ajouterClient(Tel, Nom, adresse);

	          //ajoute le 2e client
	          Tel = myReader.nextLine();
	          Nom = myReader.nextLine();
	          adresse = myReader.nextLine();
	          model.ajouterClient(Tel, Nom, adresse);
	        */
	        myReader.close();
	      } catch (Exception e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
    }

	public static void sauverFichier(String nomFichier, ModelEatHub model) {
			    try {
	        FileWriter myWriter = new FileWriter(nomFichier);
	        String s = model.donnerTousClients();
	        myWriter.write(s);
	        //myWriter.write();
	        //myWriter.write();

	        myWriter.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (Exception e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
    }



}
