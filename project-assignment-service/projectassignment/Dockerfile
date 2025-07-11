# Use OpenJDK 17 (or your preferred version)
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY project-assignment-service/projectassignment/mvn .
COPY project-assignment-service/projectassignment/.mvn .mvn
COPY project-assignment-service/projectassignment/pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY project-assignment-service/projectassignment/src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (change to match your service port)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/projectassignment-0.0.1-SNAPSHOT.jar"]