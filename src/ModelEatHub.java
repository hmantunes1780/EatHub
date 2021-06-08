import java.util.HashMap;

public class ModelEatHub {
	
	//singleton
	public class Client{
		ModelEatHub model= new ModelEatHub();
		ModelEatHub geInstance() {return model;}
		
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
	}
	static HashMap<String, Client>clients = new HashMap<String, Client>();
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

	public void ajouterCommande(int client, String Commande, String heure) {
		
	}
	
	public int trouvClient(Client c,String tel) {
		if(c.NumeroTel.matches(tel)) {
		ModelEatHub.Client client = clients.get(c);
		}
		return -1;
	}
	
	public void effacerClient(Client c) {
		//enlever info client
		ModelEatHub.Client remove = clients.remove(c);
	}
	
	public String donnerToutesCommandes() {
		for(String i: clients.keySet()) {
			int x=0;
			x+=1;		
			System.out.println("Client"+x+" \n"+i+"\n"+"\n"+"\n");
		}
		return null;
	}
	String s = ""; 
	public String donnerTousClients() {
		s="";
        clients.forEach((tel, v) -> {
            s+= "Client "+"\nTéléphone: "+ tel+"\n" +"Prénom: "+ v.Nom +"\n" +"Adresse: "+ v.Adresse+"\n" +"Ville: "+v.ville+"\n\n";
        });
		return s;
	}
}

