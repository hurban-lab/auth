# Auth Service
Authentication and Authorization Service

[![Build](https://github.com/hurban-lab/auth/actions/workflows/build.yaml/badge.svg)](https://github.com/hurban-lab/auth/actions/actions?query=workflow%3Atest)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=hurban-lab_auth&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=hurban-lab_auth)

## Pre requisites
Install
- Java +17
- Docker

## How to run locally
### Build the project:
```shell
./mvnw clean package
```

### Run via Java command line:
```shell
java -jar target/auth-0.0.1-SNAPSHOT.jar
```

Or

### Build & Run docker container:
```shell
docker build -t hurban-lab/auth .
```

```shell
docker run -d -p 8080:8080 hurban-lab/auth:latest
```

### Try it out
```
curl -X GET "http://localhost:8080/auth/hello" -H "accept: application/json"
```
