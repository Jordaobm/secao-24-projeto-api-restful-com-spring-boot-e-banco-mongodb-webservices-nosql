# Use a imagem oficial do Maven para compilar a aplicação
FROM maven:3.8.5-openjdk-22 AS build

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo pom.xml e as dependências do Maven
COPY pom.xml .

# Baixe as dependências do Maven
RUN mvn dependency:go-offline

# Copie todo o conteúdo do projeto para dentro do container
COPY . .

# Compile o projeto e construa o pacote JAR
RUN mvn clean package

# Use uma imagem base para rodar a aplicação
FROM openjdk:22-jdk

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o JAR compilado do estágio de build para o estágio final
COPY --from=build /app/target/seu-artefato.jar /app/seu-artefato.jar

# Defina o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/seu-artefato.jar"]
