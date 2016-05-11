package com.chyou.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesUtils
 * 
 * @author Lynch 2014-09-15
 *
 */
public class PropertiesUtils {
	private static final String RESOURCE = "resources.properties";

	public static Properties getProperties() {

		Properties p = new Properties();

		try {
			InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(
					RESOURCE);

			p.load(inputStream);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return p;
	}

}