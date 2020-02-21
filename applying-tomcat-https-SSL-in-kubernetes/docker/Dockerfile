FROM tomcat:8.5.34-jre8-alpine
ARG WAR_FILE
COPY ${WAR_FILE} /usr/local/tomcat/app.war
RUN cd /usr/local/tomcat && \
    rm -rf webapps/* && \
    mkdir -p webapps/ROOT && \
    unzip app.war -d webapps/ROOT > /dev/null && \
    rm /usr/local/tomcat/app.war
WORKDIR  /usr/local/tomcat/bin
ENV JPDA_ADDRESS 8000
CMD ["catalina.sh", "jpda", "run"]