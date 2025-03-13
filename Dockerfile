FROM openjdk:21-jdk-slim
WORKDIR /app

# Copier le JAR de votre application dans le conteneur
COPY target/TPIntergicielRKPVSpring-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8085

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]