FROM adoptopenjdk/openjdk11:jre11u-alpine-nightly

RUN mkdir /opt/app

COPY target/*.jar /opt/app/app.jar
CMD ["sh", "-c", "java ${JAVA_OPTS} -jar /opt/app/app.jar"]