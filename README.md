# Your Adventure

- [Description](#description)
- [Technologies](#technologies)
- [Integration](#integration)

## Description

Your Adventure is WEB-application, which allows you to draw different maps.

You will be given some tools to make the process of creating more enjoyable.
For example, one of the key features of our map editor is the ***Texture Drawing***.
You can simply select any texture you have on your device and then
with the click of the mouse button you can place it on canvas.

Not mentioning the very basic drawing tools such as ***pencil*** and ***eraser***.

Apart from that user also can:
- Save the map on device;
- Save the map on server (authorised users only);
- Open an existing map from device.

When user saves map on server, it appears in the public feed, where all other users can see
your map and get some inspiration.

If you don't want to create your own account, you can simply sign in as a ***Guest*** and still
be able to draw maps and save them on your device.

![Map editor interface](https://github.com/exhaustedkid/your-adventure/blob/dev/Resources/Screenshots/interface.png)


## Technologies

- Agile-development;
- Server-part is written in Java;
- Server work is done through servlets with the support of tomcat9;
- Database management system - postgreSQL;
- Client-part is written in JavaScript. Also were used: JSP, JSTL, CSS;
- Database is written in postgreSQL;
- Everything is being logged via log4j;
- Service part tested via JUnit5.


## Integration

To run project you need
- install [Apache Tomcat version 9.0](https://tomcat.apache.org/download-90.cgi)
- configure file [config.properties](https://github.com/exhaustedkid/your-adventure/blob/dev/src/main/resources/config.properties)(use db.database_name of already existing database)
- download dependencies using Maven in [pom.xml](https://github.com/exhaustedkid/your-adventure/blob/dev/pom.xml)
- run file BeginJDBC to create server tables -- change filename, and testjdbc file --
- edit configuration like this ![configurations](https://github.com/exhaustedkid/your-adventure/blob/dev/Resources/Screenshots/configuration.png)
- set tomcat path ![tomcat_path](https://github.com/exhaustedkid/your-adventure/blob/dev/Resources/Screenshots/tomcat_path.png)
- run project
