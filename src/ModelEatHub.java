/**
 * Cette classe g�re le mod�le de donn�es pour Eathub
 * @author shanl
 *
 */
public class ModelEatHub {

	//Variable qui garde les donn�es des clients
	String clients[][] = new String[20][5];
	int lastClient=0;

	/**
	 * M�thode pour ajouter un client
	 * @param tel (num�ro de t�l�phone de l'utilisateur)
	 * @param prenom(pr�nom de l'utilisateur)
	 * @param adresse(adresse de l'utilisateur)
	 */
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
