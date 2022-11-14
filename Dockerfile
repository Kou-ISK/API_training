
FROM openjdk:jdk-alpine
VOLUME /tmp
RUN mkdir /app
WORKDIR /app
ENV JAVA_OPTS=""
ENV JAR_TARGET "API_training-0.0.1-SNAPSHOT.jar"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar build/libs/API_training-0.0.1-SNAPSHOT.jar" ]

FROM mariadb:latest
COPY ./init.sql /docker-entrypoint-initdb.d/
VOLUME [ "/var/lib/mysql" ]