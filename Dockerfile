FROM openjdk:10-jre-slim
COPY src /tmp/src/
COPY build.gradle /tmp/
COPY gradlew /tmp/
COPY gradle /tmp/gradle/
WORKDIR /tmp/

EXPOSE 8080

RUN ./gradlew build
RUN ./gradlew bootJar

ENTRYPOINT ["java", "-jar", "./build/libs/spring-boot-in-docker.jar"]