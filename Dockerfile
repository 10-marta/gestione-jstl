# syntax=docker/dockerfile:1

FROM tomcat:8-jdk8-corretto
WORKDIR /usr/local/tomcat/webapps
COPY ./target/gestione-jstl.war  .
EXPOSE 8080
CMD ["catalina.sh", "run"]


