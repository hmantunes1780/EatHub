/**
 * 
 * @author alec
 *
 */
public class ModelEatHub {

	String clients[][] = new String[20][5];
	int lastClient = 0;

	public void ajouterClient(String tel, String prenom, String adresse) {
		clients[lastClient][0] = tel;
		clients[lastClient][1] = prenom;
		clients[lastClient][2] = adresse;
		lastClient++;
	}

	public void ajouterCommande(int client, String Commande, String heure) {
		clients[client][3] = Commande;
		clients[client][4] = heure;
	}

	public int trouvClient(String codeClients) {
		for (int i = 0; i < lastClient; i++)
			if (clients[i][0].compareToIgnoreCase(codeClients) == 0)
				return i;
		return -1;
	}

	public void effacerClient(int no) {
		clients[no] = clients[lastClient--];
	}

	public void effacerCommande(int no) {
		clients[no][3] = null;
		clients[no][4] = null;
	}

	public String donnerToutesCommandes() {
		String sortie = "";
		for (int i = 0; i < lastClient; i++) {
			for (String s : clients[i])
				sortie += s + "\t";
			sortie += "\n";
		}
		return sortie;
	}

	public String donnerTousClients() {
		String sortie="";
		for(int i = 0; i < lastClient; i++) {
			sortie+=clients[i][0]+clients[i][1]+clients[i][2]+"\n"; 	
			}
		return sortie;
		
	}
}