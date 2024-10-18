FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} tarea-isof.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "tarea-isof.jar"]

# ir a la terminal y luego ejecutar :
# 1. cd backend
# 2. mvn clean package (crear archivo jar)
# 3. docker build -t automotora-container .
# 4. docker run -p 8080:8080 -d automotora-container