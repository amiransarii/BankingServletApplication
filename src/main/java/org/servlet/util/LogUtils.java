
package org.servlet.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.servlet.demo.TestConfigLogFile;
/**
 * 
 * @author amiransari
 *created at 11/04/2020
 *this class log the details of the class
 *when debug and disable it during production
 *so it will not tak much space
 */
public class LogUtils {
	
	private Logger logger;
	private  boolean isInfo = false;
	private  boolean isDebug = false;
	private  boolean isWarn = false;
	private boolean isCaching = false;
	private boolean  isError = false;
	
	// constructor
	 public LogUtils(String tag) {
		//load the global class
		 logger = LogManager.getLogger(tag);
		
		 if(Debug.isDebug) //if true the only debug properties will be loaded
			 loadGlobal();
				
	 }
	 
	  //log the info
	 public void info(String message) {
		  if(isInfo) 
			  logger.info(message);
		  
	 }
	
	 
	 //log debug
	 public void debug(String message) {
		  if(isDebug)
			  logger.debug(message);	 
	 }
	 
	  //log warn
	 public void warn(String message) {
		 if(isWarn)
			 logger.warn(message);
	 }
	 
	 //log caching
	 public void catching(Exception e) {
		  if(isCaching)
			  logger.catching(e);
	 }
	 
	 //log error
	 public void error(String message) {
		 if(isError)
			 logger.error(message);
	 }
	 
	 
	  public boolean isDebugEnabled() {
		  return logger.isDebugEnabled();
	  }
	
	  
	  private void loadGlobal() {
		  Debug.loadConfig("debug.properties",TestConfigLogFile.class.getSimpleName());
		  isInfo = Debug.appInfo;
		  isDebug = Debug.appDebug;
		  isWarn  = Debug.appWarn;
		  isError = Debug.appError;
		  isCaching = Debug.appCatching;
		 
	  }
}
