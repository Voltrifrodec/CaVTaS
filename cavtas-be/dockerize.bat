docker-compose down
mvn clean install
docker build -t cavtas-be .
docker-compose up