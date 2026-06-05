# Estágio 1: Compilação (o Render usa o Maven para gerar o .jar)
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Estágio 2: Execução (o Render usa apenas o arquivo compilado)
FROM openjdk:21-jdk-slim
COPY --from=build /target/sistema_filmes-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]