rm -rf target
./mvnw clean package -DskipTests

# docker-compose down
# docker rmi quimicar_api:latest
# docker-compose up --build -d
# docker logs --follow quimicar_api
