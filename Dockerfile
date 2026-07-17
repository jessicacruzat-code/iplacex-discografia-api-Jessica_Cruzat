# ---------- Stage 1 : Compilación ----------
FROM gradle:8.8-jdk21 AS builder

WORKDIR /app

COPY build.gradle settings.gradle ./

COPY src ./src

RUN gradle bootJar --no-daemon

# ---------- Stage 2 : Ejecución ----------
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar discografia-1.jar

EXPOSE 443

ENTRYPOINT ["java","-jar","discografia-1.jar"]