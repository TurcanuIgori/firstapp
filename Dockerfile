FROM tomcat
COPY /target/firstapp-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/firstapp-0.0.1-SNAPSHOT.war
