# Use the official Maven image to build the application
FROM maven:3.8.4-openjdk-11 as builder

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use the official OpenJDK image for the runtime
FROM openjdk:11-jre-slim

# Set the working directory in the runtime container
WORKDIR /app

# Copy the built application from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
