package com.recruitment.logger;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class MainLogger {
    private final Logger logger;

    public MainLogger(Logger logger) {
        this.logger = logger;
    }

    public static MainLogger getLogger(Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        return new MainLogger(logger);
    }

    private Object[] filterValues(Object... argArray) {
        return Arrays.stream(argArray).map(a -> a).toArray();
    }

    public String getName() {
        return logger.getName();
    }

    public void trace(String format, Object... args) {
        if (logger.isTraceEnabled()) {
            logger.trace(format, filterValues(args));
        }
    }

    public void trace(Marker marker, String format, Object... args) {
        if (logger.isTraceEnabled(marker)) {
            logger.trace(marker, format, filterValues(args));
        }
    }

    public void debug(Marker marker, String format, Object... args) {
        if (logger.isDebugEnabled(marker)) {
            logger.debug(marker, format, filterValues(args));
        }
    }


    public void debug(String format, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, filterValues(args));
        }
    }


    public void info(String format, Object... args) {
        if (logger.isInfoEnabled()) {
            logger.info(format, filterValues(args));
        }
    }

    public void info(Marker marker, String format, Object... args) {
        if (logger.isInfoEnabled(marker)) {
            logger.info(marker, format, filterValues(args));
        }
    }


    public void warn(String format, Object... args) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, filterValues(args));
        }
    }

    public void warn(Marker marker, String format, Object... args) {
        if (logger.isWarnEnabled(marker)) {
            logger.warn(marker, format, filterValues(args));
        }
    }


    public void error(String format, Object... args) {
        if (logger.isErrorEnabled()) {
            logger.error(format, filterValues(args));
        }
    }

    public void error(Marker marker, String format, Object... args) {
        if (logger.isErrorEnabled(marker)) {
            logger.error(marker, format, filterValues(args));
        }
    }
}
