# Elevator Rest Service

The Elevator rest service is responsible for handling fictional buildings elevator operations. This is done through providing RESTFUL endpoints for a user to interact with. A user is allowed to do CRUD operations on Users,Buildings and Elevators.

## Getting started locally

1. Clone Repo
2. Run commands in root folder
  ..* mvn clean package 
  ..* java -jar *jar name*
3. See below image for endpoints or go to: http://localhost:8080/swagger-ui.html#/
4. Create MySQL Database with script provided
5. Ensure application.properties datasources are configured to look at newly created DB

![image](https://user-images.githubusercontent.com/14452921/117916557-4fba6980-b2df-11eb-9541-326d4702af2f.png)

### Prerequisites

1. Java 8
2. Maven
3. MySQL

### Running the tests

1. Run command in root folder
  ..* mvn surefire-report:report
2. This will create a report in {$projectDirectory}/Target/Site/
3. It is named: surefire-report.html and will look like the below image

![Screenshot_17](https://user-images.githubusercontent.com/14452921/117924161-36b8b500-b2ed-11eb-92dd-99dc383bffba.png)


## Getting Started on the cloud

1. Access @ http://ec2-52-212-142-164.eu-west-1.compute.amazonaws.com:8080/
2. Endpoints can be seen here @ http://ec2-52-212-142-164.eu-west-1.compute.amazonaws.com:8080/swagger-ui.html#/

Tools/Frameworks Used
⋅⋅* Spring Boot
  ⋅⋅* Main application
⋅⋅* Maven 
  ⋅⋅* Building,Dependency Management,JAR
⋅⋅* JPA-Hibernate
  ⋅⋅* Database orm
⋅⋅* SpotBug
  ⋅⋅* Bug Analysis
⋅⋅* Swagger
  ⋅⋅* describing RESTful APIs expressed using JSON
⋅⋅* MySQL
  ⋅⋅* Relational database management system
⋅⋅* AWS EC2
  ⋅⋅* Hosting applicaiton
⋅⋅* AWS
  ⋅⋅* Hosting MySQL instance
⋅⋅* Mockito + Junit
  ⋅⋅* Testing
⋅⋅* Eclipse
  ⋅⋅* Test Coverage Stats
