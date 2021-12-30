FROM maven:3.6.3-openjdk-16-slim as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build
COPY src /build/src

RUN mvn clean package
COPY target/Java-Backend-${VERSION}.jar target/application.jar

FROM openjdk:16.0.1-jre-slim
WORKDIR /app/

COPY --from=BUILDER /build/target/application.jar /app/
CMD java -jar /app/application.jar