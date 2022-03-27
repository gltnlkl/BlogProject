# Blog Project Backend
Blog Project Spring Boot REST API's

## Tools and Technologies

### Technologies:
- Java 8+
- Spring Boot
- Spring MVC
- Spring Data JPA ( Hibernate)
- Spring Security
- JWT
- Tomcat

### IDE:
- Intellij IDEA

### Database:

- MySQL database

### Tools:
 
- Swagger - API documentation
- Postman - Test REST API
- Maven - Build Tool

### Deployment on Production:
- AWS

## To do
MySql  -->  create database myblog;

## What is inside
- REST API's Design for Blog Application
- Building CRUD REST API's for Post Resource
- Pagination and Sorting Support
- Building CRUD REST API's for Comment Resource
- Using ModelMapper-Map Entity to DTO and Vice Versa
- Exception Handling in Spring Boot App
- Spring Boot REST API Validation
- Securing REST API's
- Log in / Sign in and Register / Sign up REST API's
- JWT ( Json Web Tokens) - Securing REST API's with JWT
- Versioning REST API's
- Swagger REST API Documentation
- Deploying Spring Boot Blog App on AWS Cloud

## Entity relations in database
###### one to many
 ![](https://github.com/gltnlkl/BlogProject/blob/master/src/main/java/com/gulukal/blogspringtrestapi/utils/image/one%20to%20many%20bi-direct..jpg)
 
###### many to many
 ![](https://github.com/gltnlkl/BlogProject/blob/master/src/main/java/com/gulukal/blogspringtrestapi/utils/image/many%20to%20many.jpg)
 
## The way to Versioning Blog App REST APIs
- Versioning through URI Path
One way to version a REST API is to include the version number in the URI path.
#### Examples:
1. http://www.example.com/api/1/products 
2. http://www.example.com/api/v1/products
- Versioning through query parameters
Another option for versioning a REST API is to include the version number as a query parameter.
#### Examples:
1. http://www.example.com/api/products?version=1 
2. http://www.example.com/api/products?version=2
- Versioning through custom headers
#### Examples:
1. http://www.example.com/api/1/products 
2. http://www.example.com/api/v1/products
- Versioning through content negotiation
REST APIs can also be versioned by providing custom headers with the version number included as an attribute. The main difference between this approach and the two previous ones is that it doesn’t clutter the URI with versioning information.
#### Examples:
1. http://localhost:8080/api/products headers=[X-API-VERSION=1]
2. http://localhost:8080/api/products headers=[X-API-VERSION=2]

