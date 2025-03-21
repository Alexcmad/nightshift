# Use the official OpenJDK image
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the application JAR (build this first)
COPY target/nightshift-*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
