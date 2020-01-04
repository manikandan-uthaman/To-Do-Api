FROM tomcat:8.5.50-jdk8

COPY ./todo-war/target/to-do.war /usr/local/tomcat/webapps/

COPY ./config/. /usr/local/tomcat/

EXPOSE 8080

CMD ["catalina.sh", "run"]