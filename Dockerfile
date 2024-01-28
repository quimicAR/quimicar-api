FROM adoptopenjdk:11-jre-hotspot
RUN ./build.sh
ARG JAR_FILE=./target/quimicar-api.jar
COPY ${JAR_FILE} quimicar-api.jar
ENTRYPOINT ["java", "-jar", "quimicar-api.jar"]
EXPOSE 8080