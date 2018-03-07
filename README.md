# TVListingApplication
Spring MVC project with MySQL backend storage

The TV Listing Application is a Spring MVC project that has a MySQL back-end persistence store. 

You are able to perform CRUD operations to the Database via the web UI. 

Before you begin, you will need MySQL workbench in order to use MySQL as your backend repository. You may go to: https://dev.mysql.com/downloads/windows/installer/5.7.html and download the latest version.

After you've established connection to MySQL. You will need to create the table in which you will store your data.

Run the following query:

CREATE TABLE `Tvlistings` (   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,   `title` varchar(20) NOT NULL DEFAULT '',   `description` varchar(20) DEFAULT NULL,   `duration` varchar(20) DEFAULT NULL,   `originalAirDate` varchar(20) DEFAULT NULL,   `rating` varchar(20) DEFAULT NULL,   `keywords` varchar(20) DEFAULT NULL,   PRIMARY KEY (`id`) ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

Refresh your DB schema and you should see a new table named 'tvlistings'.

After importing the project to your IDE, please navigate to webapp.WEB-INF.spring.appServlet. Within this package you will find the servlet-context.xml file.Locate the 'datasource' bean. Within the 'datasource' bean, you will need to set up your jdbc connection URI as well as add in your username and corresponding password. 

Now that your configuration is done, run a Maven install. After the build is complete. You may right-click and run on your Tomcat server. 

http://localhost:8080/[Name of Web Application]/tvshows will take you to your web UI screen. Here you can perform all of the CRUD operations on your MySQL DB table. 

Have Fun!
