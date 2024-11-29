>>> Spring Security Role-Based Authentication and Authorization
>  Project Overview
 - This project demonstrates the implementation of role-based authentication and authorization using Spring Security.
 - It consists of two roles: USER and ADMIN, each having specific access rights to various endpoints and functionalities.

> Features
-Role-based access control.
-Secure login/logout mechanisms.
-Authorization for specific endpoints based on roles.
-User and role management through a database.
-Spring Security configuration for dynamic role handling.

> Tech Stack
-Backend: Spring Boot, Spring Security
-Database: MySQL (or any preferred relational database)
-Build Tool: Maven
-Language: Java

>>> End Points

| Endpoint        | Role Access  | Description                                   |
|-----------------|--------------|-----------------------------------------------|
| `/save`         | All          | Endpoint for user registration.                |
| `/update`       | All          | Endpoint for user Updation.                   |
| `/delete/{id}`  | ADMIN        | Accessible by ADMIN roles.                    |
| `/find/{id}`    | USER         | Accessible only by USER role.                |
| `/findall`      | ADMIN        | Accessible by ADMIN roles.
| `/login`        | All          | Publically Available endpoint 



>>> Setup Instructions
1.Clone the repository:
>> git clone https://github.com/naveen93900/Spring_Security.git
2.Navigate to the project directory:
>> cd security
3.Build the project:
>> mvn clean install
4.Run the application:
>> mvn spring-boot:run
5.Access the application at: http://localhost:8080

>>> Configuration
>> Database Configuration
> Update the application.properties file to configure the database settings:
spring.datasource.url=jdbc:mysql://localhost:3306/spring_security?createDatabaseIfNotExist=true
spring.datasource.username=****
spring.datasource.password=****
spring.jpa.hibernate.ddl-auto=update

>>> User Roles
>Predefined users and roles are configured in the database.

>>> Project Structure

src/
├── main/
│   ├── java/
│   │   └── com.example.project/
│   │       ├── config/         # Spring Security configuration
│   │       ├── controller/     # REST controllers
│   │       ├── entity/         # Entity classes
│   │       ├── repository/     # Repository interfaces
│   │       └── dto/            # Data Transfer Objects
│   └── resources/
│       ├── application.properties # Configuration properties      


>>> For any questions or feedback, please reach out at  mvnaveen1947@gmail.com.





