# Use the official Tomcat base image with Alpine
FROM tomcat:9.0-alpine

# Copy the WAR file to the webapps directory of Tomcat
COPY target/BestPractice-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
