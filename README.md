# University Management Web App

This repository contains a Spring Boot web application alongside the original NetBeans Java Swing application.

## Project structure

```text
University-Management/
├── Dockerfile                         # Multi-stage Docker build for the web app
├── pom.xml                            # Maven dependencies and build configuration
├── render.yaml                        # Render deployment configuration
├── README.md
├── nbproject/                         # NetBeans project configuration (legacy desktop app)
├── build/                             # NetBeans build output (legacy desktop app)
└── src/
    ├── main/                          # Spring Boot web application
    │   ├── java/com/university/management/
    │   │   ├── UniversityManagementApplication.java  # Spring Boot entry point
    │   │   ├── controller/
    │   │   │   └── AppController.java               # Login and management routes
    │   │   ├── model/
    │   │   │   ├── LoginForm.java
    │   │   │   ├── Student.java
    │   │   │   └── Teacher.java
    │   │   └── service/
    │   │       └── UniversityService.java            # Application data and operations
    │   └── resources/
    │       ├── application.properties
    │       ├── static/css/style.css                  # Web app styles
    │       └── templates/
    │           ├── dashboard.html
    │           ├── login.html
    │           ├── students.html
    │           └── teachers.html
    └── university/management/       # Original Java Swing application and icons
```

## Web app features

- Admin login page
- Dashboard with student and teacher counts
- Student and teacher listing and add forms
- Docker and Render deployment configuration

> The web app currently uses in-memory sample data. Records do not persist across restarts, and this prototype is not yet connected to a production database.

## Run locally

Requirements: JDK 17+ and Maven 3.9+.

```bash
mvn spring-boot:run
```

Then open [http://localhost:8080](http://localhost:8080).

Demo login:

```text
Username: admin
Password: admin123
```

This demo login is for local evaluation only. Configure secure authentication before exposing the app publicly.

## Build and run with Docker

```bash
docker build -t university-management .
docker run --rm -p 8080:8080 university-management
```

## Deploy to Render

1. Import this GitHub repository into Render as a Blueprint.
2. Render will read `render.yaml` and build the app using the `Dockerfile`.
3. After the deploy succeeds, open the service URL provided by Render.

## Original desktop app

The original NetBeans Swing app is under `src/university/management`. It is separate from the Spring Boot app in `src/main/java` and can be opened as a NetBeans project.
