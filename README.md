Sure Samarth! Here's the **full README.md content** in copyable `.md` format. Just paste this into your `README.md` file:

````markdown
# 🧠 Habit Tracker App

A full-stack habit tracker application built using **Spring Boot** (Java backend) and **React.js** (frontend). The app allows users to track daily habits with fields like name, description, email, and habit date.

---

## 🚀 Tech Stack

**Frontend**:  
- React.js  
- Axios  
- HTML5 + CSS3  

**Backend**:  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- PostgreSQL  
- Swagger (OpenAPI)  
- DTO + Mapper pattern  
- Exception Handling  
- RESTful API design  

**Others**:  
- Docker  
- Java 21  
- Validation with Jakarta  
- UUID-based identifiers  

---

## 📦 Project Structure

```bash
habit-tracker/
├── habit-backend/       # Spring Boot Application
│   └── src/
│       ├── controller/
│       ├── service/
│       ├── model/
│       ├── dto/
│       ├── exception/
│       └── mapper/
└── habit-frontend/      # React App
    └── src/
        ├── api/
        ├── components/
        └── App.js
````

---

## 🐳 Run with Docker

> Ensure Docker is installed and running.

### 🐋 Build & Run

```bash
docker-compose up --build
```

Access frontend at:
[http://localhost:3000](http://localhost:3000)

Access Swagger docs at:
[http://localhost:4000/swagger-ui/index.html](http://localhost:4000/swagger-ui/index.html)

---

##  Run Backend Locally (Without Docker)

1. Navigate to the backend directory:

   ```bash
   cd habit-backend
   ```

2. Set up PostgreSQL locally, and update `application.properties`.

3. Run the app:

   ```bash
   ./mvnw spring-boot:run
   ```

---

##  Run Frontend Locally

1. Navigate to the frontend folder:

   ```bash
   cd habit-frontend
   ```

2. Install dependencies:

   ```bash
   npm install
   ```

3. Start the dev server:

   ```bash
   npm start
   ```

---

##  API Documentation

Once backend is running, access the Swagger docs:

```
http://localhost:4000/swagger-ui/index.html
```

---

##  Example API Endpoints

* `GET /habits` → fetch all habits
* `POST /habits` → create a habit
* `PUT /habits/{id}` → update a habit
* `DELETE /habits/{id}` → delete a habit

All requests and responses use DTOs (`HabitRequestDTO`, `HabitResponseDTO`) for clean separation between layers.

---

## 🛡 Authentication (Future Scope)

Currently, all habits are public. A future enhancement will allow users to:

* Register/Login
* View only their own habits
* Secure endpoints with JWT

---

##  What You’ll Learn

* Clean separation of concerns (DTO, Entity, Mapper)
* Global exception handling in Spring Boot
* Containerization with Docker
* Integration of frontend and backend
* How RESTful APIs power React UIs

---

## 🙌 Author

**Samarth Tikotkar**
[GitHub](https://github.com/someear9h) • [LinkedIn](https://www.linkedin.com/in/samarth-tikotkar-7532b0328/)
📧 [tikotkarsamarth@gmail.com](mailto:tikotkarsamarth@gmail.com)

```

---

✅ You can now paste this into `habit-backend/README.md` or `habit-tracker/README.md`. Let me know if you want the Dockerfile, `.dockerignore`, or `docker-compose.yml` to go with this too.
```
