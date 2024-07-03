# BestPractice Web Application

This is a simple web application built using Java Servlets, JSP, and Hibernate for database management.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Tomcat 9 or higher
- PostgreSQL 15
- Maven
- IDE (IntelliJ IDEA, Eclipse, etc.)

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
│   │   │               └── User.java
│   │   ├── resources/
│   │   │   └── hibernate.cfg.xml
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
   git clone https://github.com/yourusername/bestpractice.git
   cd bestpractice
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

4. **Build the project:**

   ```bash
   mvn clean install
   ```

5. **Deploy the project to Tomcat:**

   - Copy the generated WAR file from the `target` directory to the Tomcat `webapps` directory.
   - Start the Tomcat server.

6. **Access the application:**

   Open a web browser and navigate to `http://localhost:8080/bestpractice`.

## Usage

1. **Input Data:**

   - Navigate to `http://localhost:8080/bestpractice`.
   - Click on the "Enter Data" link.
   - Fill in the ID and Name fields and submit the form.

2. **View Success Page:**

   - After submitting the form, you will be redirected to the success page displaying the entered data.

## Technologies Used

- Java Servlets
- JSP
- Hibernate
- PostgreSQL
- Apache Tomcat
- Maven

## Contributing

1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License.

---
