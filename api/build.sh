rm -rf target
./mvnw clean package -DskipTests
# cp ./target/quimicar-api-0.0.1-SNAPSHOT.jar ./src/main/docker
# cd src/main/docker
docker-compose down
docker rmi quimicar-api:latest
docker-compose up --build -d
docker logs --follow quimicar-api
