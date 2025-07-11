<!-- @format -->

# HRMS Project

This is a Human Resource Management System (HRMS) built with a microservices architecture. This project manages employee information, departments, and project assignments.

## Technologies Used

- Java 24
- Spring Boot
- Spring Cloud
- Maven
- Docker
- Render

## Architecture

The project follows a microservices architecture, with the following services:

- **Service Registry (Eureka):** For service discovery.
- **API Gateway (Spring Cloud Gateway):** The single entry point for all client requests.
- **Department Service:** Manages department data.
- **Employee Service:** Manages employee data.
- **Project Assignment Service:** Manages project assignments for employees.

## Getting Started

To get the project up and running locally, you will need to have Java 17 and Docker installed.

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```
2.  **Build the services:**
    Navigate to each service's directory and run the following command:
    ```bash
    ./mvnw clean package
    ```
3.  **Run the services using Docker Compose:**
    ```bash
    docker-compose up -d
    ```

## Deployment

This project is configured for deployment on Render using the `render.yaml` file. The services are deployed as Docker containers.

## Services

- **`api-gateway`:** The API Gateway for the HRMS. It routes requests to the appropriate microservice.
- **`department-service`:** Manages departments in the organization.
- **`employee-service`:** Manages employee information.
- **`project-assignment-service`:** Manages the assignment of employees to projects.
- **`service-registry`:** A Eureka server for service registration and discovery.
