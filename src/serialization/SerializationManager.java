package serialization;

import serialization.config.ConfigParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
			
			ModelEatHub.setClients((ClientManager) clientsIn.readObject());			
			clientsIn.close();
		} catch (IOException e) {
			System.err.println("Erreur lors de la deserialization de ClientManager!");
		} catch (ClassNotFoundException e) {
			System.err.println("Erreur ClientManager ClassNotFound!");
		}
		
		try {
			FileInputStream commandesFileIn = new FileInputStream(commandesFile);
			ObjectInputStream commandesIn = new ObjectInputStream(commandesFileIn);
			
			ModelEatHub.setCommandes((CommandeManager) commandesIn.readObject());
			commandesIn.close();
		} catch (IOException e) {
			System.err.println("Erreur lors de la deserialization de CommandeManager!");
		} catch (ClassNotFoundException e) {
			System.err.println("Erreur CommandeManager ClasseNotFound!");
		}
	}
	
	public void saveData() {
		String clientsPath = (String) configParser.getValue("clientsavepath");
		File clientsFile = new File(clientsPath);
		resetFile(clientsFile);
		
		String commandesPath = (String) configParser.getValue("commandesavepath");
		File commandesFile = new File(commandesPath);
		resetFile(commandesFile);
		
		ModelEatHub.getInstance().clients.serialize(clientsFile);
		ModelEatHub.getInstance().commandes.serialize(commandesFile);
	}
	
	public void resetFile(File file) {
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Erreur lors de la creation du fichier '" + file.getName() + "'");
			e.printStackTrace();
		}
	}
}
