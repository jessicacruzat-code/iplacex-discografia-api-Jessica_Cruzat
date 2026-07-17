# ---------- Stage 1 : Compilación ----------
FROM gradle:8.8-jdk21 AS builder

WORKDIR /app

COPY ./buil.gradle .
COPY ./settings.gradle .

RUN gradle build --no-daemon

# ---------- Stage 2 : Ejecución ----------
FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar discografia-1.jar

EXPOSE 443

ENTRYPOINT ["java","-jar","discografia-1.jar"]