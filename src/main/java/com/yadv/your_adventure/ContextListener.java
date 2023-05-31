package com.yadv.your_adventure;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;

@WebListener("application context listener")
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        PropertyConfigurator.configure("/home/zolokinos/your-adventure/src/main/webapp/WEB-INF/log4j.properties");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    }
}