package com.spring;


import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author ilebedyuk
 */
public class Aspect {
    private Logger logger;

    public void addAppender(){
        logger = Logger.getRootLogger();
        logger.setLevel(Level.INFO);
        PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");
        logger.addAppender(new ConsoleAppender(layout));
    }
    public void before(){
        logger.info("Before method...");
    }
    public void after(){
        logger.info("After method...");
    }
    public void afterReturning(){
        logger.info("After returning...");
    }
    public void afterThrowing(){
        logger.info("After throwing...");
    }

    public void around(ProceedingJoinPoint joinPoint){ //добавление этого аргумента обязательно!
        try {
            before();
            joinPoint.proceed(); //запускаем наш joinpoint
            after();
            afterReturning();
        } catch (Throwable throwable) {
            afterThrowing();
        }
    }
}
