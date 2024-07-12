# Monthly Task Project

## Description
This project is a Spring Boot backend application for managing monthly tasks. It includes key components such as entities, controllers, services, and a main application class. The project uses an H2 in-memory database for development and testing purposes.



## Requirements
- Java 8 or higher
- Maven 3.6.3 or higher

##Running the Application
To run the application, use the following command:
mvn spring-boot:run

##After starting the application, you can access the H2 database console at `http://localhost:9090/h2-console` and configure it with the JDBC URL `jdbc:h2:mem:test`

##The application exposes REST endpoints for managing monthly tasks. You can interact with these endpoints using tools like Postman or curl.

##Example Endpoints
GET /challenges: Retrieve all challenges
POST /challenges: Create a new challenge
GET /challenges/{id}: Retrieve a challenge by ID
PUT /challenges/{id}: Update a challenge
DELETE /challenges/{id}: Delete a challenge
