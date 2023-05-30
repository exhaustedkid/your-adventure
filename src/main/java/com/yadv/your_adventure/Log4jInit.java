package com.yadv.your_adventure;

import javax.servlet.*;
        import java.io.File;
        import org.apache.log4j.PropertyConfigurator;

public class Log4jInit implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Listened!!!");
//        String homeDir=event.getServletContext().getRealPath("/");

//        File propertiesFile=new File(homeDir,"WEB-INF/log4j.properties");
//        PropertyConfigurator.configure(propertiesFile.toString());
//        File directory = new File (""); // Параметр пуст
//        String courseFile = directory.getAbsolutePath();
//        String courseFile=System.getProperty(
//        System.out.println(courseFile);
//        String prefix = event.getServletContext().getRealPath("/");
//        String filename = event.getServletContext().getInitParameter("init_log4j");
//        if (filename != null) {
//            PropertyConfigurator.configure(prefix + filename);
//        }
    }

    public void contextDestroyed(ServletContextEvent event) {}

}