package com.esshva.utility;

import org.apache.log4j.Logger;

public class Log {

	// Initialize Log4j logs

	// private static Logger Log = Logger.getLogger(Log.class.getName());//
	private static final Logger log = Logger.getLogger(Log.class);
	
	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite

	public static void startTestCase(String sTestCaseName) {

		log.info(" Esshva : -------------------------------"
				+ sTestCaseName + "---------------------------------:");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String sTestCaseName) {

		log.info(" Esshva : -------------------------------"
				+ "-End Test Case-" + "---------------------------------:");

	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {

		log.info(" Esshva Portal " + message);

	}

	public static void warn(String message) {

		log.warn(" Esshva Portal " + message);

	}

	public static void error(String message) {

		log.error(" Esshva Portal " + message);

	}

	public static void fatal(String message) {

		log.fatal(" Esshva Portal " + message);

	}

	public static void debug(String message) {

		log.debug(" Esshva Portal " + message);

	}

}