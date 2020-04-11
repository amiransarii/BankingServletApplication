package org.servlet.util;

/**
 * this class will handle only debug operation
 */
public class Debug {

	public static final boolean isDebug = true; // if this is true then can load debug properties file

	public static boolean appInfo = false;
	public static boolean appDebug = false;
	public static boolean appWarn = false;
	public static boolean appError = false;
	public static boolean appCatching = false;

	// load config class
	public static void loadConfig(String configfile, String name) {

		try {
			Config cfg = new Config(configfile, name);
			appInfo = cfg.getPropertySafely("app_info", appInfo);
			appDebug = cfg.getPropertySafely("app_debug", appDebug);
			appWarn = cfg.getPropertySafely("app_warn", appWarn);
			appError = cfg.getPropertySafely("app_error", appError);
			appCatching = cfg.getPropertySafely("app_catching", appCatching);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
