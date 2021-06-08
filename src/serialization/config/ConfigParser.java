package serialization.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigParser {
	private File configFile;
	private ArrayList<ConfigEntry> config;
	
	public ConfigParser(String fileName) {
		this.config = new ArrayList<>();
		this.configFile = new File(fileName);

		try {
			init();
		} catch (FileNotFoundException e) {
			System.err.println("Fichier '" + fileName + "' n'est pas trouver! Les donnees de clients et commande ne pourrait pas etre retrouver!");
		} catch (IOException e) {
			System.err.println("Erreur en lisant le fichier '" + fileName + "'!");
		}
	}
	
	private void init() throws FileNotFoundException, IOException {
		Scanner reader = new Scanner(configFile);
		
		// Passe a travers le fichier config et enleve tout les espaces, tout comment avec # et tout \n
		ArrayList<String> content = new ArrayList<>();

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			StringBuilder lineNoWhitespace = new StringBuilder();
			
			LINE_LOOP: for (char currentChar : line.toCharArray()) {
				if (currentChar == ' ') {
					continue LINE_LOOP;
				}
				lineNoWhitespace.append(currentChar);
			}			
			
			if (lineNoWhitespace.charAt(0) == '#') {
				continue;
			}
			int len = lineNoWhitespace.length();
			if (lineNoWhitespace.charAt(len - 1) == 'n' && lineNoWhitespace.charAt(len - 2) == '\\') {
				lineNoWhitespace.delete(len - 2, len - 1);
			}
			
			content.add(lineNoWhitespace.toString());
		}
		parse(content);
	}
	
	private void parse(ArrayList<String> content) {
		if (content.isEmpty()) {
			return;
		}
		
		for (String line : content) {
			String[] lineSplit = line.split(":");
			for (int i = 0; i < lineSplit.length - 1; i+= 2) {
				ConfigEntry entry = new ConfigEntry(lineSplit[i], lineSplit[i + 1]);
				config.add(entry);
			}
		}
	}
	
	public ArrayList<ConfigEntry> getConfigEntries() {
		return config;
	}
	
	public ConfigEntry getConfigEntry(String key) {
		for (ConfigEntry entry : config) {
			if (entry.getKey().equalsIgnoreCase(key)) return entry;
		}
		return null;
	}
	
	public Object getValue(String key) {
		return getConfigEntry(key).getValue();
	}
}
