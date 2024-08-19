# Etapa de build
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/gerenciamentodepedidosapp.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]