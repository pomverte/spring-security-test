# Testing Spring Security

This is a proof of concept just to see how spring security works.

The user database is in memory and in an ldif file.

The ldif file is read by an embedded LDAP server.

I've set up the Sring's switch user functionnality.

## Compile
It's a maven3 project so just run
```
mvn clean package
```
The project is set to compile with Java 1.7.

It will generate a WAR file in the `target` folder : `spring-security-test-*.war`

## Deploy
* Just drop the in a servlet container supporting Servlet 3.x (I'm using Apache Tomcat 7.0.28)
* The go to http://localhost:8080/spring-security-test/
