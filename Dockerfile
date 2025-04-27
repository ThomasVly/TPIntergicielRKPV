# Build
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copier uniquement le fichier pom.xml pour télécharger les dépendances
COPY pom.xml .

# Télécharger les dépendances
RUN mvn dependency:go-offline

# Copier le reste du code source
COPY src ./src

# Compiler l'application
RUN mvn clean package -DskipTests

# Run
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copier le JAR de votre application dans le conteneur
COPY target/TPIntergicielRKPVSpring-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8085

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]