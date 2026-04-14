# 🐍 Snake Game — Backend API
## 🌐 API Base URL
[https://snakegame-api-fefxc8b8bcguajd0.polandcentral-01.azurewebsites.net](https://snakegame-api-fefxc8b8bcguajd0.polandcentral-01.azurewebsites.net)

## Tech Stack
* Java 17
* Spring Boot 3
* Spring Web (REST API)
* Spring Data JPA / JDBC
* PostgreSQL
* Azure App Service (deployment)
* Maven

## Features
* Score submission API
* Leaderboard retrieval
* Persistent storage (PostgreSQL)
* Sorted high-score system
* CORS enabled for frontend integration
* Deployed on Azure App Service

## 📡 API Endpoints
### Get leaderboard
```http id="p7g1az"
GET /api/scores
```

### Response
```json id="m1x8qk"
[
  {
    "id": 1,
    "playerName": "TestPlayer",
    "score": 120,
    "createdAt": "2026-03-31T23:07:28"
  }
]
```

### Submit score
```http id="c9v2kk"
POST /api/scores
Content-Type: application/json
```

```json id="s3x9dp"
{
  "playerName": "Player1",
  "score": 150
}
```

## Business Logic
* Scores are stored in PostgreSQL
* Leaderboard is sorted by `score DESC`
* Duplicate players allowed (each run = new record)
* Ranking is handled on frontend (not backend)
* API returns raw data for flexibility

## CORS Configuration
Frontend allowed origins:
* [https://snake-game-self-five.vercel.app](https://snake-game-self-five.vercel.app)

## Deployment (Azure)
* Hosted on **Azure App Service (Linux)**
* Runtime: Java 17
* Deployment via **GitHub Actions CI/CD**
* Artifact: Spring Boot fat JAR

## 🛠️ Build & Run Locally
### 1. Build project
```bash id="d8k2as"
mvn clean package
```

### 2. Run locally
```bash id="v4p1qj"
java -jar target/app.jar
```

or
```bash id="r9l0xz"
mvn spring-boot:run
```

## Architecture Overview
```
Frontend (React)
      ↓
REST API (Spring Boot)
      ↓
PostgreSQL (scores storage)
```

## Notes
* No authentication (public demo project)
* Designed for simple cloud deployment demo
* Backend optimized for low-latency leaderboard fetch
* Works with polling-based frontend updates

## License
MIT
