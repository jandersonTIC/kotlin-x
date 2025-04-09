# kotlin-x

## Requisitos

- Java 11
- Gradle

## Dependências

Para apenas baixar as dependências, rode o comando:

```bash
./gradlew dependencies
```

Para limpar o cache de dependências e baixar novamente, rode o comando:

```bash
./gradlew clean build --refresh-dependencies
```

## Rodar o projeto

```bash
# Instala o gradlew no projeto. Requer o gradle instalado globalmente.
gradle wrapper

# Roda o projeto
./gradlew bootRun
```

## Health Check

```bash
curl http://localhost:8080/health
```


