package allUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Utilities {


	
	public static String findPropAttrVal(String filePath,String attribut) throws IOException
	{
		String val = "";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		
		prop.load(fis);
		
		val = prop.getProperty(attribut);
		
		return val;
	}
}
