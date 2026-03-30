# 📚 Library Management System (Java + JSP + Servlets)

A beginner-friendly **Library Management System** built using Java Servlets, JSP, and MySQL.
This project demonstrates core concepts of backend development, database connectivity, and web application flow.

---

## Features

*  Admin Login Authentication
*  Add New Books
*  Add Users
*  Issue Books
*  Return Books
*  View Books *(UI implemented)*
*  Search Books *(basic structure ready)*

---

## Tech Stack

* **Java (Core + JDBC)**
* **JSP & Servlets**
* **MySQL Database**
* **Apache Tomcat Server**

---

## Project Structure

```
LibraryManagementSystem/
│── src/
│   ├── controller/     (Servlets)
│   ├── service/        (Business Logic)
│   ├── dao/            (Database Access)
│   ├── model/          (Java Classes)
│
│── web/
│   ├── jsp files
│   ├── forms & UI
│
│── WEB-INF/
│   ├── web.xml
```

---

## How to Run

1. Install **Apache Tomcat**
2. Configure database in `DBconnection.java`
3. Import project into IDE
4. Deploy project to Tomcat (`webapps` folder or server)
5. Start server and open:

```
http://localhost:8080/LibraryManagementSystem/login.jsp
```

---

## Note

This project is currently **under development**.
Some features like **View Books and Search functionality** are partially implemented and will be improved in future updates.

---

## Learning Outcomes

* Understanding of **MVC architecture**
* Hands-on with **Servlet lifecycle**
* Database operations using **JDBC**
* Handling real-world issues like deployment, server config, and debugging

---

## Future Improvements

* Improve UI/UX design
* Fix and enhance search functionality
* Add multiple user roles (Admin/User)
* Implement pagination & validations

---

## Author

**Srilekha Gondi**
Aspiring Software Developer 

---

## Final Note

This project reflects my learning journey in Java web development.
Not perfect… but real, evolving, and built with curiosity 
