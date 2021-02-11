## Jar to WAR conversion

To deploy the Spring Boot application into Tomcat, we need to make the following changes

### pom.xml changes

* Most importantly, add the `packaging` element as `war`, which otherwise gets defaulted to a JAR

    ```
        <packaging>war</packaging> 
    ```

* Mark the embedded Tomcat Server as `provided`

    ```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
    ```

### Main class

    The application Main class should extend as follows.

    `public class RestServiceApplication extends SpringBootServletInitializer`