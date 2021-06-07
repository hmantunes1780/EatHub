package client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ClientManager implements Serializable {
	// Table d'hachage qui map les IDs de clients au objets de client
	private HashMap<UUID, Client> clients = new HashMap<>();
	
	public ClientManager() {
		loadSavedClients();
	}
	
	// Dans le future, cette methode va chercher les clients serializer
	private void loadSavedClients() {
		
	}
	
	public UUID generateClientID() {
		return UUID.randomUUID();
	}
	
	public void putClient(Client toAdd) {
		clients.put(toAdd.getClientID(), toAdd);
	}
	
	public void removeClient(UUID clientID) {
		clients.remove(clientID);
	}
	
	public Client getClient(UUID clientID) {
		return clients.get(clientID);
	}
	
	public ArrayList<Client> getToutClients() {
		ArrayList<Client> toutClients = new ArrayList<>();
		for (Client client : clients.values()) {
			toutClients.add(client);
		}
		return toutClients;
	}
	
	// ATTENTION: Si le client n'est pas trouver, null va etre retourner
	public Client getClientByTel(String telephoneNum) {
		for (Client currentClient : clients.values()) {
			if (telephoneNum.equalsIgnoreCase(currentClient.getTelephoneNum())) {
				return currentClient;
			}
		}
		return null;
	}
}
