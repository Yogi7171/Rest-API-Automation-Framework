package api.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class Helper {
	
	public static final String commonFilePath="C:\\Users\\chauh\\Java\\ApiAutomation\\lib\\common.properties";
	public static String propertyReader(String key) throws IOException {
		String value = null;
		// InputStream is required while loading into properties
		InputStream input = new FileInputStream(commonFilePath); 
			// Taking help of Properties class from java to read file from .properties
			// configuration
			Properties prop = new Properties();
			// load a properties file
			prop.load(input);
			// getProperty will fetch the value according to the key
			value = prop.getProperty(key);
			return value;
	}
	//create folder for Extent Reporting
	public static void CreateFolder(String path)
	{	//File is a class inside java.io package
		File file =new File(path);
		if(!file.exists())
		{
			file.mkdir();//mkdir is used to create folder
		}else
		System.out.println("Folder already created");
	}
	//Return current time stamp
	public static String Timestamp()
	{
		Date now=new Date();
		String Timestamp = now.toString().replace(":", "-");
		return Timestamp;
	}
}
