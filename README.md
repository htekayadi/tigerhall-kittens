# tigerhall-kittens

The goal of this project is to explore [`GraphQL`](https://graphql.org). For it, we will implement a [`Spring Boot`](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) Web Java applications. It exposes a `GraphQL` endpoint **and** traditional REST API endpoints. `tiger-api` uses [`MySQL`](https://www.mysql.com) as storage.

## Prerequisites

- [`Java 11+`](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [`Docker`](https://www.docker.com/)
- [`Docker-Compose`](https://docs.docker.com/compose/install/)

## Start Environment

- Open a terminal and inside `tigerhall-kittens` root folder run
  ```
  docker-compose up -d
  ```

- Wait a bit until all containers are Up (healthy). You can check their status running
  ```
  docker-compose ps
  ```
  
## Running applications with Maven

Inside `tigerhall-kittens`, run the following Maven commands in different terminals

- **tiger-api**
  ```
  ./mvnw clean spring-boot:run --projects tiger-api \
  -Dspring-boot.run.jvmArguments="-Dspring.datasource.username=tigerhalluser -Dspring.datasource.password=tigerhallpass"
  ```

## Running Applications as Docker containers

### Build Application's Docker Images

- Open a terminal and make sure you are in `tigerhall-kittens` root folder

- In order to build the docker images, run the following script
  ```
  ./build-apps.sh
  ```
      
### Application's environment variables
    
- **tiger-api**

  | Environment Variable   | Description                                                                          |
  | ---------------------- | ------------------------------------------------------------------------------------ |
  | `MYSQL_HOST`           | Specify host of the `MySQL` database to use (default `localhost`)                    |
  | `MYSQL_PORT`           | Specify port of the `MySQL` database to use (default `3306`)                         |

### Start Applications Docker containers

- In a terminal, make sure you are inside `tigerhall-kittens` root folder

- Run following script
  ```
  ./start-apps.sh
  ```

## Application's Link

| Application     | URL Type | URL                                   |
| --------------- | -------- | ------------------------------------- |
| tiger-api       | Swagger  | http://localhost:8080/swagger-ui.html |
| tiger-api       | GraphiQL | http://localhost:8080/graphiql        |

## How to use GraphiQL

- **tiger-api**

  1. In a browser, access http://localhost:8080/graphiql

  1. Create an tiger and return its id
     ```
     mutation {
       createTiger(tigerInput: {name: "Samer Buna", dateOfBirth: "2020-12-31", lastSeen: "2021-05-01T10:11:30", lastSeenCoordinates:"3.162456/28.561538"}) {
         id
         name
       }
     }
     ```

  1. Get all tigers in `tiger-api`.
     ```
     {
       getAllTigers {
         name
         dateOfBirth
         lastSeen
         lastSeenCoordinates
       }
     }
     ```

## Shutdown

- Stop applications

  - If they were started with `Maven`, go to the terminals where they are running and press `Ctrl+C`
  
  - If they were started as a Docker container, inside `tigerhall-kittens` root folder, run the script below
    ```
    ./stop-apps.sh
    ```

- Inside `tigerhall-kittens` root folder, run the following command to stop and remove docker-compose containers, networks and volumes
  ```
  docker-compose down -v
  ```

## Useful links & commands

- **MySQL monitor**
  ```
  docker exec -it mysql mysql -utigerhalluser -ptigerhallpass --database=tigerhallkittensdb
  show tables;
  select * from tigers;
  ```
  > Type `exit` to get out of MySQL monitor

## References

- https://graphql.org/learn
- https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot
- https://www.baeldung.com/spring-graphql
- https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/
