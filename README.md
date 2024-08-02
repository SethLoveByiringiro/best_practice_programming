# BestPractice Web Application

This is a simple web application built using Java Servlets, JSP, and Hibernate for database management, with integrated logging using Log4j.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Tomcat 9 or higher
- PostgreSQL 15
- Maven
- IDE (IntelliJ IDEA, Eclipse, etc.)
- Log4j 2

## Project Structure

```
bestpractice/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── bestpractice/
│   │   │               ├── HelloServlet.java
│   │   │               ├── HibernateUtil.java
│   │   │               ├── User.java
│   │   │               └── LogManager.java
│   │   ├── resources/
│   │   │   ├── hibernate.cfg.xml
│   │   │   └── log4j2.xml
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       ├── input.jsp
│   │       ├── success.jsp
│   │       └── index.jsp
├── .gitignore
├── pom.xml
└── README.md
```

## Setting Up the Project

1. **Clone the repository:**

   ```bash
   git clone https://github.com/SethLoveByiringiro/best_practice_programming.git
   cd best_practice_programming
   ```

2. **Set up the PostgreSQL database:**

   - Create a PostgreSQL database named `best`.
   - Create a user with the username `postgres` and password `123`.
   - Grant all privileges on the `best` database to the `postgres` user.

3. **Configure Hibernate:**

   - Edit the `hibernate.cfg.xml` file in the `src/main/resources` directory with your PostgreSQL connection details.

     ```xml
     <!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
     <hibernate-configuration>
         <session-factory>
             <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
             <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/best</property>
             <property name="hibernate.connection.username">postgres</property>
             <property name="hibernate.connection.password">pwd</property>
             <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
             <property name="hibernate.hbm2ddl.auto">update</property>
             <property name="show_sql">true</property>
             <mapping class="com.example.bestpractice.User"/>
         </session-factory>
     </hibernate-configuration>
     ```

4. **Configure Log4j:**

   - Add the `log4j2.xml` configuration file in the `src/main/resources` directory.

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <Configuration status="WARN">
         <Appenders>
             <!-- Console Appender -->
             <Console name="Console" target="SYSTEM_OUT">
                 <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n"/>
             </Console>
             
             <!-- File Appender -->
             <File name="FileAppender" fileName="app.log">
                 <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n"/>
             </File>
         </Appenders>
         <Loggers>
             <Root level="info">
                 <AppenderRef ref="Console"/>
                 <AppenderRef ref="FileAppender"/>
             </Root>
         </Loggers>
     </Configuration>
     ```

5. **Build the project:**

   ```bash
   mvn clean install
   ```

6. **Deploy the project to Tomcat:**

   - Copy the generated WAR file from the `target` directory to the Tomcat `webapps` directory.
   - Start the Tomcat server.

7. **Access the application:**

   Open a web browser and navigate to `http://localhost:8080/bestpractice`.

## Usage

1. **Input Data:**

   - Navigate to `http://localhost:8080/bestpractice`.
   - Click on the "Enter Data" link.
   - Fill in the ID and Name fields and submit the form.

2. **View Success Page:**

   - After submitting the form, you will be redirected to the success page displaying the entered data.

## Logging Implementation

### What is Logging?

Logging is the process of recording events or messages during an application's execution. These logs provide valuable insights for monitoring, debugging, and understanding the application's behavior.

### Why Logging is Important

- **Debugging**: Helps identify and fix issues by providing insights into application behavior.
- **Monitoring**: Allows tracking of application performance and errors.
- **Auditing**: Provides a record of changes and access to data.
- **Maintenance**: Assists in managing and maintaining code quality and stability.

### Understanding Logging Levels

- **TRACE**: Detailed information used for debugging.
- **DEBUG**: Informational events for development and debugging.
- **INFO**: General information about application progress.
- **WARN**: Potentially harmful situations that are not errors but might need attention.
- **ERROR**: Error events that indicate issues in the application.
- **FATAL**: Severe errors that cause application termination.

### Setting Up a Logger in Java

- **Log4j 2** is used for logging. You can initialize a logger in your classes as follows:

  ```java
  import org.apache.logging.log4j.LogManager;
  import org.apache.logging.log4j.Logger;

  public class YourClass {
      private static final Logger LOGGER = LogManager.getLogger(YourClass.class);

      public void someMethod() {
          LOGGER.info("This is an informational message.");
      }
  }
  ```

### Configuring Output Destinations

- **Console**: Logs are printed to the console.
- **File**: Logs are written to a file. Configured in `log4j2.xml` as shown above.
- **Remote Logging Servers**: Can be configured to send logs to remote servers for centralized logging.

### Formatting Log Messages

- The log messages include timestamps, logging levels, and other contextual information, configured in `log4j2.xml` with the `PatternLayout` pattern.

## Contributing

1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License.
