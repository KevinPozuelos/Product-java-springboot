# --- Etapa de build ----
FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# --- Etapa RUNTIME ----
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar product.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "product.jar"]