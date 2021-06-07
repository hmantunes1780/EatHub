import java.util.HashMap;

public class ModelEatHub {
	
	/*String clients[][] = new String[20][5];
	int lastClient=0;*/
	public class Client{
		public void Client(String tel,String prenom,String adresse) {
			this.NumeroTel=tel;
			this.Nom=prenom;
			this.Adresse=adresse;	
		}
		public void Client(String tel,String prenom,String adresse,String ville) {
			this.NumeroTel=tel;
			this.Nom=prenom;
			this.Adresse=adresse;
			this.ville=ville;	
		}
		public String NumeroTel;
		public String Nom;
		public String Adresse;
		public String ville;
		public String platFavori;
		public String platFavori2;
	}
	HashMap<String, Client>clients = new HashMap<String, Client>();
	public void ajouterClient(String tel, String prenom, String adresse, String ville) {
		Client c = new Client();
		c.NumeroTel=tel;
		c.Nom=prenom;
		c.Adresse=adresse;
		c.ville=ville;	
		clients.put(tel,c);
		/*clients[lastClient][0]=tel;
		clients[lastClient][1]=prenom;
		clients[lastClient][2]=adresse;
		lastClient++;*/

	}	
	public void ajouterClient(String tel, String prenom, String adresse) {
		ajouterClient(tel,prenom,adresse,"");
	}
	

	public void ajouterCommande(int client, String Commande, String heure) {
		
	}
	
	public int trouvClient(String codeClients) {
		//lorsque numéro entré voir si correspond à un client
		return -1;
	}
	
	public void effacerClient(Client c) {
		//enlever info client
		clients.remove(c);
	}
	
	public String donnerToutesCommandes() {
		//montrer commande
		//String s="dfseffdgsef";
		return null;
	}
	
	public String donnerTousClients() {
		/*String sortie="";
		for(String[] ss: clients) {
			for(String s:ss)
				sortie+= s+"\t";
			sortie+="\n";
		}*/
		return null;
	}
}

