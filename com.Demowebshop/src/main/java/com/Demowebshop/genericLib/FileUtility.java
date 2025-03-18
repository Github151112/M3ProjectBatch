package com.Demowebshop.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public Properties p = new Properties();

	/*
	 * this method will fetch the data from property file
	 */
	public String getDataFromProperty(String path, String key) {
		try {
			FileInputStream f = new FileInputStream(path);
			p.load(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p.getProperty(key);

	}

}
