
public class ModelEatHub {
	
	String clients[][] = new String[20][5];
	int lastClient=0;

	public void ajouterClient(String tel, String prenom, String adresse) {
		clients[lastClient][0]=tel;
		clients[lastClient][1]=prenom;
		clients[lastClient][2]=adresse;
		lastClient++;

	}	
	
	public void ajouterCommande(int client, String Commande, String heure) {
	}
	
	public int trouvClient(String codeClients) {
		return -1;
	}
	
	public void effacerClient(int no) {
	}
	
	public String donnerToutesCommandes() {
		String s="";
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
