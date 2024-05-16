# Etapa 1: Compilação
FROM maven:3.8.4-openjdk-22 AS build
WORKDIR /app

# Copia o arquivo pom.xml e os arquivos de código-fonte
COPY pom.xml .
COPY src ./src

# Executa o comando de compilação do Maven para gerar o JAR
RUN mvn clean package

# Etapa 2: Execução
FROM openjdk:22-jre-slim
WORKDIR /app

# Copia o JAR gerado da etapa de compilação para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Define o ponto de entrada para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
