package utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {

    private static final String CONFIG_FILE = "testconfig.properties";
    private static Properties prop = new Properties();

    static {
        loadConfig();
    }

    private static void loadConfig() {
        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            prop.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }

    public static boolean getBooleanProperty(String propertyName) {
        return Boolean.parseBoolean(prop.getProperty(propertyName));
    }
	
//	private Properties properties;
//	
//	public ConfigurationManager() {
//		properties = new Properties();
//		try {
//			FileInputStream fis = new FileInputStream("testconfig.properties");
//			properties.load(fis);
//		}
//		catch(IOException e){
//			e.printStackTrace();
//		}
//	}
//	
//	public String getProperty(String key) {
//		
//	}
}
