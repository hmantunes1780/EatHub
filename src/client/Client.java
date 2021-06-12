package client;

import java.io.Serializable;
import java.util.UUID;

public class Client implements Serializable {
	private String telephoneNum;
	private String absoluteTelephoneNum;
	private String prenom;
	private String adresse;
	private UUID clientID;
	
	public Client(String telephoneNum, String prenom, String adresse, UUID clientID) {
		this.telephoneNum = telephoneNum;
		this.prenom = prenom;
		this.adresse = adresse;
		this.clientID = clientID;
		this.absoluteTelephoneNum = stripTelephoneNum(telephoneNum);
	}
	
	public static String stripTelephoneNum(String tel) {
		String absTelephoneNum = "";
		char[] validNumbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		OUTER_LOOP: for (char currentChar : tel.toCharArray()) {
			for (char validChar : validNumbers) {
				if (currentChar == validChar) {
					absTelephoneNum += currentChar;
					continue OUTER_LOOP;
				}
			}
		}
		return absTelephoneNum;
	}
	
	public UUID getClientID() {
		return clientID;
	}
	
	public String getTelephoneNum() {
		return telephoneNum;
	}
	
	public String getAbsoluteTelephoneNum() {
		return absoluteTelephoneNum;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
}
