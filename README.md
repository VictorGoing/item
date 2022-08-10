# item
Simple register/logIn program with Java, Spring, Mysql

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
The item lets you register a user. 
As a registered user, you can log in after which you will receive a JsonWebToken(JWT).
Having JWT, you can add Items or download all the previously added ones. 

## Technologies
* Java 11
* Gradle 7.5
* Springboot 2.7.2
* MySql

## Setup

To run the application download it to an environment like IntelliJ or similar.
Install the technology you have if you don't have it. 
Make sure the dependencies in the build.gradle file match.
The application requires an "items" database in MySql. 
Customize your database in the src/../resources/application.properties file.
If everything agrees, run ItemApplication.

## Endpoints
### POST: register 
``` http://localhost:8080/v1/users/register ```

requires request body in JSON:
```
{
    "login":"loginExample",
    "password":"passwordExample"
}
```

### POST: log in 
``` http://localhost:8080/v1/users/logIn ``` 

requires request body in JSON:
```
{
    "userLogin":"loginExample",
    "userPassword":"passwordExample"
}
```
response JsonWebToken

### POST: add item
``` http://localhost:8080/v1/items/ ```

requires request header:

Key: Authorization, Value: "Bearer  agasdvadfbvsdffbadfbadfbadfbadfbadfbdfabsaddsbxcz23e32rsdv"  <-(Example JsonWebToken)

requires request body in JSON:
```
{
    "name":"nameExample"
}
```

### GET: get user items
``` http://localhost:8080/v1/items/ ```

requires request header:

Key: Authorization, Value: "Bearer  agasdvadfbvsdffbadfbadfbadfbadfbadfbdfabsaddsbxcz23e32rsdv"  <-(Example JsonWebToken)

response:
```
[
    {
        "id": 8,
        "owner": 7,
        "name": "item1"
    },
    {
        "id": 9,
        "owner": 7,
        "name": "item2"
    }
]
```
## Sources
I learned with:
(https://github.com/team-learn-programming-yourself/jwt-youtube/blob/d372f2efc71bbddb9e80c36a00eaaaf155359590/src/main/java/com/youtube/jwt/service/JwtService.java#L54)












