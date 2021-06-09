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
	public class commande{
		public void commande(String Commande,String heure) {
			this.commandeclient=Commande;
			this.heuredecommande=heure;		
		}
		public String commandeclient;
		public String heuredecommande;
		}
	static HashMap<String, Client>clients = new HashMap<String, Client>();
	public void ajouterClient(String tel, String prenom, String adresse, String ville) {
		Client c = new Client();
		c.NumeroTel=tel;
		c.Nom=prenom;
		c.Adresse=adresse;
		c.ville=ville;	
		clients.put(tel,c);
	}	
	static HashMap<String, commande> comm = new HashMap<String, commande>();
	public void ajouterCommande(String Commande, String heure) {
		commande com=new commande();
		com.commandeclient=Commande;
		com.heuredecommande=heure;
		comm.put(Commande, com);
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
	String z="";
	public String donnerToutesCommandes() {
		z="";
        clients.forEach((tel, v) -> {
            z+= "Client: "+" (Prénom: "+v.Nom+" Téléphone:  "+ tel+") "+"\n";
        });
        comm.forEach((Commande, d) -> {
            z+= "Commande: " +Commande +"\n"+d.heuredecommande+"\n";
        });
		return z;
	}
	String s = ""; 
	public String donnerTousClients() {
		s="";
        clients.forEach((tel, v) -> {
            s+= "\n\nClient "+"\nTéléphone: "+ tel+"\n" +"Prénom: "+ v.Nom +"\n" +"Adresse: "+ v.Adresse+"\n" +"Ville: "+v.ville+"\n\n";
        });
		return s;
	}
}

