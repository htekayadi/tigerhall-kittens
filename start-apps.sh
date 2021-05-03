#!/usr/bin/env bash

echo
echo "Starting tiger-api..."

docker run -d --rm --name tiger-api \
  -p 8080:8080 --network=tigerhall-kittens_default \
  -e MYSQL_HOST=mysql -e SPRING_DATASOURCE_USERNAME=tigerhalluser -e SPRING_DATASOURCE_PASSWORD=tigerhallpass \
  --health-cmd="curl -f http://localhost:8080/actuator/health || exit 1" --health-start-period=40s \
  docker.mycompany.com/tiger-api:1.0.0

echo