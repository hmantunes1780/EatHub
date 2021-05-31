package client;

public class Client {
	private String telephoneNum;
	private String prenom;
	private String adresse;
	private int clientID;
	
	public Client(String telephoneNum, String prenom, String adresse, int clientID) {
		this.telephoneNum = telephoneNum;
		this.prenom = prenom;
		this.adresse = adresse;
		this.clientID = clientID;
	}
	
	public int getClientID() {
		return clientID;
	}
	
	public String getTelephoneNum() {
		return telephoneNum;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
}
