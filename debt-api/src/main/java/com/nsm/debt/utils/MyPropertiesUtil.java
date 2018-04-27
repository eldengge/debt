package com.nsm.debt.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyPropertiesUtil {
	public static String getProperty(String pro,String key) throws IOException {
		Properties properties=new Properties();
		InputStream resourceAsStream = MyPropertiesUtil.class.getClassLoader().getResourceAsStream(pro);
		properties.load(resourceAsStream);
		String property=properties.getProperty(key);
		return property;
	}
}
