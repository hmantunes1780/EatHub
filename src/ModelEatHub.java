import java.util.HashMap;

public class ModelEatHub {
	 
	//singleton
	ModelEatHub model= new ModelEatHub();
	ModelEatHub geInstance() {return model;}
	//-----------------------------------------------------------------CLIENT--------------------------------------------------------------
	public class Client{
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
	//-----------------------------------------------------------COMMANDE-----------------------------------------------------------------
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
	//---------------------------------------------------------Hashmap infoclient--------------------------------------------------------
	static HashMap<String, Client>clients = new HashMap<String, Client>();
	public void ajouterClient(String tel, String prenom, String adresse, String ville) {
		Client c = new Client();
		c.NumeroTel=tel;
		c.Nom=prenom;
		c.Adresse=adresse;
		c.ville=ville;	
		clients.put(tel,c);
	}	
	//--------------------------------------------------------Hashmap commande-------------------------------------------------------------
	static HashMap<String, commande> comm = new HashMap<String, commande>();
	public void ajouterCommande(String Commande, String heure,String tele) {
		commande com=new commande();
		com.numtel=tele;
		com.commandeclient=Commande;
		com.heuredecommande=heure;
		comm.put(tele, com);
	}
	//String pour afficher les commandes et clients
	String afficherclient="";
	String affichercommande="";
	//----------------------------------------------------Code pour chaque section de l'app-----------------------------------------------
	public Client trouvClient(String tel) {
		ModelEatHub.Client client = clients.get(tel);
		return client;
	}
	
	public void effacerClient(Client c) {
		ModelEatHub.Client removed = clients.remove(c.NumeroTel);
		System.out.print(removed.NumeroTel);
	}
	public void effacerCommande(commande com) {
		ModelEatHub.commande removed2 = comm.remove(com.numtel);
		System.out.print(removed2.numtel);
	}
	
	public String donnerToutesCommandes() {
        comm.forEach((tele, d) -> {
        	affichercommande+= "Client: (Téléphone: "+tele+")"+"\n"+"Commande: " +d.commandeclient +"\n"+"Heure: "+d.heuredecommande+"\n";
        });
		return affichercommande;
	}
	public String donnerTousClients() {
        clients.forEach((tel, v) -> {
        	afficherclient+= "\n\nClient "+"\nTéléphone: "+ tel+"\n" +"Prénom: "+ v.Nom +"\n" +"Adresse: "+ v.Adresse+"\n" +"Ville: "+v.ville+"\n\n";
        });
		return afficherclient;
	}
}

