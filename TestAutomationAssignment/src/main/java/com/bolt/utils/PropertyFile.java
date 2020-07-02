package com.bolt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	public static String getPropertyValue(String key) {

		String currentDir = System.getProperty("user.dir");
		String filePath = currentDir + File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"config.properties";
		File file = new File(filePath);

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);
	}

}
