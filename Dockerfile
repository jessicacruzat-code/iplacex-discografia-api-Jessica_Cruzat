# ---------- Stage 1 : Compilación ----------
FROM gradle:8.8-jdk21 AS builder

WORKDIR /app

COPY . .

RUN gradle clean build -x test

# ---------- Stage 2 : Ejecución ----------
FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=builder /app/build/libs/discografia-1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]