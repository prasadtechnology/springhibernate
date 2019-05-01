package com.test;

import org.apache.log4j.Logger;

/**
 * log level sequence
 * debug
 * info
 * warn
 * error
 * fatal
 * @author root
 *
 */
public class TestLog {

	final static Logger log = Logger.getLogger(TestLog.class);
	
	public static void main(String[] args) {
		log.info("this is testing info");
		log.debug("this is testing debug");
		log.error("this is testing error");
	}

}
