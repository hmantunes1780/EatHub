package serialization.config;

public class ConfigEntry {
	private String key;
	private Object value;
	
	public ConfigEntry(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public Object getValue() {
		return value;
	}
}
