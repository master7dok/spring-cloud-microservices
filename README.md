# spring-cloud-microservices
README

Java Spring Hibernate Postgres Microservice Application with Config-Service, Registry, Account-Service, Bill-Service, Deposit-Service, Gateway, Notification-Service

This application is designed to provide a microservice architecture that can be run locally using Docker. The services include:

Config-Service: Service for storing configuration data
Registry: Service discovery using Eureka
Account-Service: Service for managing user accounts
Bill-Service: Service for managing bills
Deposit-Service: Service for managing deposits
Gateway: API gateway to route requests to the appropriate service
Notification-Service: Service for sending SMTP emails
Prerequisites:

Java 8 or later
Docker
Docker-compose
At least 6 GB of RAM
To run the application, follow these steps:

Clone the repository to your local machine
Change the IP address in config-service/src/main/resources/application.properties to your local IP address in the database connection URL.
Change the postgresql.conf file to listen to your local IP address instead of localhost, and also change the pg_hba.conf file to allow access from your IP address.
Create the following databases with the credentials postgres and password postgres: account-service-database, bill-service-database, and deposit-service-database.
Navigate to the root directory of the project and run docker-compose up --build. This will start all the services.
Wait for all the services to start and for the Docker logs to indicate that they are ready.
Access the services using the following URLs:
Config-Service: http://localhost:8888
Registry: http://localhost:8761
Account-Service: http://localhost:8081
Bill-Service: http://localhost:8082
Deposit-Service: http://localhost:8083
Gateway: http://localhost:8080
Notification-Service: http://localhost:8084
Note: The services can also be run individually by navigating to the respective service directory and running docker build -t <name> . to build the Docker image, and then running docker run -p <port>:<port> <name> to run the container.

For more information, please refer to the documentation in the respective service directories.
