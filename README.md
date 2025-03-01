# RightGuy Backend

This is the backend system for **"The Right Guy"**, a service platform where **requesters** can post jobs and **service providers** can bid for them. The backend is developed using **Spring Boot**.

---

## 📂 Project Structure

```
rightGuyBackend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.rightguy/
│   │   │       ├── controller/              # REST Controllers (UserController)
│   │   │       ├── dtos/                     # Data Transfer Objects (UserRequestDto)
│   │   │       ├── enums/                    # Enums (UserType, Specialization)
│   │   │       ├── model/                    # Entities (User, Job, Bid, ServiceProviderProfile)
│   │   │       ├── repositories/             # JPA Repositories (UserRepository, JobRepository, etc.)
│   │   │       ├── services/                  # Service Interfaces & Implementations
│   │   │       │       ├── bid/                # BidService, BidServiceImpl
│   │   │       │       ├── user/               # UserService, UserServiceImpl
│   │   │       │       ├── job/                # (JobService, JobServiceImpl - to be restored soon)
│   │   │       └── SecurityConfig.java        # Security Configuration
│   └── resources/
│       ├── application.properties            # Database & App Config
│       ├── static/                            # Static resources (if needed)
│       └── templates/                         # Thymeleaf templates (if used)
├── pom.xml                                    # Maven build file
└── README.md                                 # This file
```

---

## ⚙️ Tech Stack

| Technology        | Version |
|------------------|-------|
| Spring Boot     | 3.x |
| MySQL           | Latest |
| JPA/Hibernate   | 3.x |
| Maven           | 3.x |

---

## 🚀 How to Run the Project

### 1. Clone the Repository

```bash
git clone <repository-url>
cd rightGuyBackend
```

---

### 2. Configure Database in `application.properties`

Edit `src/main/resources/application.properties` to set your MySQL details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/rightguydb
spring.datasource.username=root
spring.datasource.password=yourpassword
```

⚠️ **Reminder:** Later, use **environment variables** instead of hardcoding the password.

---

### 3. Run the Application

You can run it using **Maven Wrapper** (recommended):

```bash
./mvnw spring-boot:run    # for Linux/macOS
mvnw.cmd spring-boot:run   # for Windows
```

Or if Maven is already installed globally:

```bash
mvn spring-boot:run
```

---

✅ The application will be available at:  
[http://localhost:8080](http://localhost:8080)

---

### 📜 Notes

- Make sure MySQL is running.
- You can create the database manually before running the app, or add `spring.sql.init` properties if you want the app to create it automatically.
- Security configuration is basic for now — later we’ll add JWT and role-based access.

---

### 🔗 Future Enhancements

- Add Docker Compose for database + backend setup.
- Use environment variables for sensitive data (like passwords).
- Add Swagger for API documentation.
