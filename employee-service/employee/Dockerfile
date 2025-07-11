# Use OpenJDK 17 (or your preferred version)
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY employee-service/employee/mvnw .
COPY employee-service/employee/.mvn .mvn
COPY employee-service/employee/pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY employee-service/employee/src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (change to match your service port)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/employee-0.0.1-SNAPSHOT.jar"]