# Use OpenJDK 17 (or your preferred version)
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY department-service/departmentservice/mvnw .
COPY department-service/departmentservice/.mvn .mvn
COPY department-service/departmentservice/pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY department-service/departmentservice/src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (change to match your service port)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/departmentservice-0.0.1-SNAPSHOT.jar"]