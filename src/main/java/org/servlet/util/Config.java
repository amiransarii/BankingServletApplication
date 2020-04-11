package org.servlet.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Properties;

/**
 * 
 * @author amiransari
 * this class will handle 
 * the properties file and will return some value
 */
public class Config {
	
	private  Properties prop  = null;
	private Logger logger;
	private String name;// class name error
	
	/**
	 * 
	 * @param configFile properties file
	 * @param name is the class name from 
	 * where this class is called
	 */
	public Config(String configFile, String name) {
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		try {
			prop = new Properties();
			prop.load(classLoader.getResourceAsStream(configFile));
			logger = LogManager.getLogger(name);
		} 
		catch(Exception e) {
			logger.error("Exception ocucred in Config File "+ configFile +" With Exception "+e.getMessage());
		}	
	}
	
	 
	/**
	 * 
	 * @param key pass string value 
	 * @param defvalue pass default value
	 * @return
	 */
	public String getPropertySafely(String key,String defvalue){
		 
		try {
			String val = prop.getProperty(key).trim();
			return val;
		}
		catch(Exception e) {
			logger.error("Exception ocucred With key "+ key +" With Exception "+e.getMessage());
			return defvalue;
		}	
	}
	
	  
	/**
	 * 
	 * @param key pass value
	 * @param defvalue false
	 * @return boolean value
	 */
	 public boolean getPropertySafely(String key,boolean defvalue){
		  	 
		 try {
			 boolean val = Boolean.parseBoolean(prop.getProperty(key).trim());
			 return val;
		 }
		 catch(Exception e) {
			 logger.error("Exception ocucred With key "+ key +" With Exception "+e.getMessage());
			 return defvalue;		 
		 }

	 }
	
	 /**
	  * 
	  * @param key
	  * @param defvalue
	  * @return integer value
	  */
	 public int getPropertySafely(String key,int defvalue){
		 
		 try {
			 int val = Integer.parseInt(prop.getProperty(key).trim());
			 return val;
		 }
		 catch(Exception e) {
			 logger.error("Exception ocucred With key "+ key +" With Exception "+e.getMessage());
			 return defvalue;
		 }	 
	 }

	 /**
	  * 
	  * @param key
	  * @param defvalue
	  * @return long value
	  */
	 public long getPropertySafely(String key,long defvalue){
		 
		 try {
			 int val = Integer.parseInt(prop.getProperty(key).trim());
			 return val;
			 
		 } catch(Exception e) {
			 logger.error("Exception ocucred With key "+ key +" With Exception "+e.getMessage());
			 return defvalue;
		 }		 
	 }
	 
	 
	 
}
