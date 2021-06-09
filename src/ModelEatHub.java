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
		public void commande(String Commande,String heure, String tele) {
			this.commandeclient=Commande;
			this.heuredecommande=heure;
			this.numtel=tele;
		}
		public String commandeclient;
		public String heuredecommande;
		public String numtel;
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
	public void ajouterCommande(String Commande, String heure,String tele) {
		commande com=new commande();
		com.numtel=tele;
		com.commandeclient=Commande;
		com.heuredecommande=heure;
		comm.put(tele, com);
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
	String y="";
	public String donnerToutesCommandes() {
        comm.forEach((tele, d) -> {
            y+= "Client: (Téléphone: "+tele+"\n"+"Commande: " +d.commandeclient +"\n"+"Heure: "+d.heuredecommande+"\n";
        });
		return y;
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

