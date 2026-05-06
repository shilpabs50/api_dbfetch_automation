package utils;

import java.util.ResourceBundle;

public class ConfigManager {
	
	
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
	
	
	public static String get(String key) {		
		return resourceBundle.getString(key);		
	}
	
	

}
