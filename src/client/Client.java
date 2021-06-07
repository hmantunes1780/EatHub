package client;

import java.io.Serializable;
import java.util.UUID;

public class Client implements Serializable{
	private String telephoneNum;
	private String prenom;
	private String adresse;
	private UUID clientID;
	
	public Client(String telephoneNum, String prenom, String adresse, UUID clientID) {
		this.telephoneNum = telephoneNum;
		this.prenom = prenom;
		this.adresse = adresse;
		this.clientID = clientID;
	}
	
	public UUID getClientID() {
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
