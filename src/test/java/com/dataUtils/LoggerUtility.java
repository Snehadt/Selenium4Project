package com.dataUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;

public class LoggerUtility {
    ;
    private LoggerUtility() {
    }

    public static Logger getLogger(Class<?> tClass) {
        Logger logger=null;
        if(logger==null)
         logger =LogManager.getLogger(tClass);
        return logger;
    }


}
