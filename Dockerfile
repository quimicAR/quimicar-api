FROM openjdk:11
COPY . /src
WORKDIR /src
RUN chmod 700 mvnw && rm -rf ./target && ./mvnw clean install package -DskipTests
ARG JAR_FILE=./target/quimicar-api.jar
COPY ${JAR_FILE} quimicar-api.jar
ENTRYPOINT ["java", "-jar", "quimicar-api.jar"]
EXPOSE 8080