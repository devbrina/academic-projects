# Employee Management System

## Overview
This project is an Employee Management System implemented in Java with a RESTful web service using JAX-RS. The system allows you to perform CRUD operations (Create, Read, Update, Delete) on employee records, providing endpoints for managing employee information.

## Project Structure
The project is organized into the following main components:

- src: Contains the Java source code for the project.
- WS: Web service classes implementing RESTful endpoints.
- DAO: Data Access Object classes handling database operations.- lib: Contains external libraries. Currently, it includes the Gson library (version 2.8.7) for JSON processing.
- nbproject: Configuration files for the NetBeans IDE.
- web: Placeholder for web-related resources (if applicable).

## Database Configuration
The project uses a Derby database with a table named employee for storing employee information. The database connection details are specified in the ConnectionFactory class.

```java
private static final String URL = "jdbc:derby://localhost:1527/company";
private static final String USER = "app";
private static final String PASSWORD = "app";
```

Please ensure that your Derby database is running and accessible with the provided credentials.

## RESTful Endpoints
The EmployeeWS class in the WS package defines various RESTful endpoints for managing employees. Here are some examples:

* Get all employees:

```
GET /system/rest/employees/all
```
* Get employee by employeeNumber:
```
GET /system/rest/employees/{employeeNumber}
```
* Get supervisors:
```
GET /system/rest/supervisors
```

* Delete employee by employeeNumber:

```
DELETE /system/rest/employees/{employeeNumber}
```

* Add a new employee:
```
POST /system/rest/employees
```

* Update an existing employee:
```
PUT /system/rest/employees
```
## Usage
To use the project, follow these steps:

1. Ensure that your Derby database is up and running.
2. Import the project into your preferred Java IDE (e.g., NetBeans).
3. Configure the project to use the required libraries (e.g., Gson).
4. Run the project.
   
## Dependencies
- Gson library (version 2.8.7): Gson on GitHub

## Contributing
Feel free to contribute to the project by submitting issues or pull requests. Your feedback is highly appreciated!

## License
This project is licensed under the MIT License.
