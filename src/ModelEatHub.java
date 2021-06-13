import java.util.ArrayList;
/**
 * 
 * @author Angelo
 *
 */
public class ModelEatHub {
	
  /*
	String clients[][] = new String[20][3];
	int lastClient=0;
*/
ArrayList<String[]> clients = new ArrayList<String []>();

	public void ajouterClient(String tel, String prenom, String adresse) {
		/*clients[lastClient][0]=tel;
		clients[lastClient][1]=prenom;
		clients[lastClient][2]=adresse;
		lastClient++;*/
    String nouveau [] = new String[5];
nouveau[0]=tel;
nouveau[1]=prenom;
nouveau[2]=adresse;
clients.add(nouveau);
   

	}	

	//String commande[][] = new String[20][5];
	public void ajouterCommande(int client, String Commande, String heure) {
    clients.get(client)[3]=Commande;
		clients.get(client)[4]=heure;
		
}
	
	public int trouvClient(String numTel) {
		for (int i=0; i<clients.size(); i++)
			if (clients.get(i)[0].compareToIgnoreCase(numTel) == 0)
				return i;
			return -1;
	}
	
	public void effacerClient(int numeroClient) {
    //clients.get(tel);
    //clients.clear();
    clients.remove(numeroClient);
	}
	
	public String donnerToutesCommandes() {
		String s="(999)999-9999\tJean\t8 Young\tPizza\t8h15\n(888)888-8888\tPaul\t9 Young\tCalzone\t8h15";
		return s;
	}
	
	public String donnerTousClients() {
		String sortie="";
		for(String[] ss: clients) {
			for(String s:ss)
				sortie+= s+"\t";
			sortie+="\n";
		}
		return sortie;
	}
}
