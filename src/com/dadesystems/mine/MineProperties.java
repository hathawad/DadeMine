package com.dadesystems.mine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MineProperties {
	private static Properties prop = new Properties();

	static {

		try {
			// load a properties file
			prop.load(ClassLoader.getSystemClassLoader().getResourceAsStream(
					"mine.properties"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getQueryRunnerClass() {
		return prop.getProperty("queryRunner.class");
	}
	
	public static String getResultWriterdelimeter() {
		return prop.getProperty("resultWriter.delimeter");
	}
	
	public static String getResultWriterOutputFileName() {
		return prop.getProperty("resultWriter.outputFileName");
	}
	
	public static String getOdbcQueryRunnerOdbcString() {
		return prop.getProperty("odbcQueryRunner.odbcString");
	}
	
	public static String[] getOdbcQueryRunnerColumnOrder() {
		 return prop.getProperty("odbcQueryRunner.columnOrder").split(",");
	}
	
	public static String getQueryRunnerQueryFile() {
		return prop.getProperty("queryRunner.queryFile");
	}
	
	
	
		

	
}
