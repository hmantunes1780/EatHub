package serialization;

import serialization.config.ConfigParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import base.ModelEatHub;
import client.ClientManager;
import commande.CommandeManager;

public class SerializationManager {
	private ConfigParser configParser;
	
	public SerializationManager() {
		this.configParser = new ConfigParser("src\\serialization\\config\\config.txt");
		deserialize();
	}
	
	public void deserialize() {
		String clientsPath = (String) configParser.getValue("clientsavepath");
		File clientsFile = new File(clientsPath);
		
		String commandesPath = (String) configParser.getValue("commandesavepath");
		File commandesFile = new File(commandesPath);
		
		try {
			FileInputStream clientsFileIn = new FileInputStream(clientsFile);
			ObjectInputStream clientsIn = new ObjectInputStream(clientsFileIn);
			
			FileInputStream commandesFileIn = new FileInputStream(commandesFile);
			ObjectInputStream commandesIn = new ObjectInputStream(commandesFileIn);
			
			ModelEatHub.setClients((ClientManager) clientsIn.readObject());
			ModelEatHub.setCommandes((CommandeManager) commandesIn.readObject());
		} catch (Exception e) {
			System.err.println("Erreur lors de la deserialization!");
		}
	}
	
	public void saveData() {
		String clientsPath = (String) configParser.getValue("clientsavepath");
		File clientsFile = new File(clientsPath);
		ModelEatHub.clients.serialize(clientsFile);
		
		String commandesPath = (String) configParser.getValue("commandesavepath");
		File commandesFile = new File(commandesPath);
		ModelEatHub.clients.serialize(commandesFile);
	}
}
