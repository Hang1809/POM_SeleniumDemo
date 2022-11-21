package com.logigear.common;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void info(Object object) {
        logger.info(object);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void warn(Object object) {
        logger.warn(object);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void error(Object object) {
        logger.error(object);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void debug(Object object) {
        logger.debug(object);
    }
}
