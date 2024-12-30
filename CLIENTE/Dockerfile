# Usar uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo .jar para dentro do container
COPY target/CLIENTE-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta do microserviço
EXPOSE 8081

# Comando para executar o microserviço
ENTRYPOINT ["java", "-jar", "app.jar"]
