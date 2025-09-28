 package com.HelloBooks.genericlibrary;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author sangavi 
 * This class is generic class which is having generic methods.
 */

public class FileUtility {
	/**
	 * This method is a generic method used to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis =new FileInputStream(ipathconstant.filepath);
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
		
	}

}
