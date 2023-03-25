FROM maven AS MAVEN_BUILD

MAINTAINER tokhir.soliev@gmail.com

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn clean package

FROM altairbob/jdk-17-sshd

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/*.jar /app/notes-service.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/notes-service.jar"]