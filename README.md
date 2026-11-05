# University Management Web App

This repository now includes a deploy-ready Spring Boot web application built on top of the original Java Swing project.

## What was added

- Spring Boot web app
- Login page with admin credentials
- Dashboard with student and teacher counts
- Student and teacher management screens
- Docker support
- Render deployment config

## Run locally

```bash
./mvnw spring-boot:run
```

Then open:

```text
http://localhost:8080
```

Default login:

```text
Username: admin
Password: admin123
```

## Deploy to Render

1. Push this repository to GitHub.
2. Import it into Render.
3. Render will use `render.yaml` and `Dockerfile` automatically.
4. The app will run on port 8080.

## Legacy project

The original NetBeans Swing application remains in the `src/university/management` directory. The new web application is a deployable version built in `src/main/java`.

## Important note

The original project stores database credentials in source code. For a production deployment, move all secrets to environment variables and never commit them to the repository.
