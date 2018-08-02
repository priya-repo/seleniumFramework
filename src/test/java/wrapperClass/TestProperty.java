package wrapperClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperty {
	
	public static String readTestProperites(String data) {
		String dataValue ="";
		try {
			File f = new File("./testProperty.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			dataValue = prop.getProperty(data); 
			return dataValue;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataValue;
	}

}
