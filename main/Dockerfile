FROM openjdk:18-alpine
ARG JAR_FILE=build/libs/main-0.0.1-SNAPSHOT.jar
ENV LANG C.UTF-8
COPY ${JAR_FILE} app.jar
#COPY ayokeystore.pkcs12 ayokeystore.pkcs12
CMD ["java", "-jar", "/app.jar"]