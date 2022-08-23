# item
Simple register/logIn program with Java, Spring, Mysql

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Sources](#sources)

## General info

The 'Item' allows you to register a user. 
Registered user can log in and receive JWT in response.
Authorized user can add items or download items previously added.

## Technologies
* Java 11
* Gradle 7.5
* Springboot 2.7.2
* MySql

## Setup

To run the application you need to download it to IntelliJ or similar environment.
Install the technologies listed above if you don't have them. 
Make sure your build.gradle file has correct dependencies.
The application also requires 'Items' database in MySql. 
Customize your database connection in the file src/../resources/application.properties file.
If everything is configured you can run application.

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












