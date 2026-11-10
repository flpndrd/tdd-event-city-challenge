# Desafio — TDD Event City

## 📄 Descrição

Este projeto implementa uma API REST com Spring Boot para cidades e eventos, desenvolvida para fazer passar os testes de integração do projeto base do desafio.

## 🎯 Objetivo do desafio

Implementar as funcionalidades necessárias para que os testes do projeto base passem, seguindo o modelo de domínio proposto.

## 🛠 Tecnologias utilizadas

- Java 25
- Spring Boot 4.1.1
- Spring Data JPA
- Hibernate
- Bean Validation
- Banco de dados H2
- JUnit

## 📐 Modelo de Domínio

- **City**: `cityId`, `name`
- **Event**: `eventId`, `name`, `date`, `url`
- Relacionamento: Event → City (ManyToOne)

No JSON, os ids continuam como `id`, como no contrato do curso.

## 📦 Carga Inicial do Banco de Dados

A aplicação carrega automaticamente 11 cidades e 4 eventos.

## 🔎 Funcionalidades

A API disponibiliza os seguintes endpoints REST:

- GET /cities (todas as cidades, ordenadas pelo nome)
- POST /cities
- DELETE /cities/{cityId}
- PUT /events/{eventId}

## ⚠️ Tratamento de Exceções

Os erros seguem o formato `ProblemDetail` (RFC 9457).

- `400 Bad Request` — cidade inexistente na atualização do evento
- `404 Not Found` — cidade ou evento inexistente
- `409 Conflict` — exclusão de cidade que tem eventos
- `422 Unprocessable Content` — erro de validação, com uma entrada por erro na propriedade `errors` (`fieldName` e `message`)
  - `cityId`: obrigatório na atualização do evento

## 🚀 Como Executar

1. Clonar o repositório
2. Importar o projeto em sua IDE como projeto Maven
3. Executar a classe principal da aplicação (anotada com `@SpringBootApplication`) pela IDE ou via terminal:

```bash
./mvnw spring-boot:run
```

## ✅ Validação

Após executar a aplicação, o banco de dados pode ser acessado via H2 Console para verificação das tabelas e dados inseridos.

- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: sa
- Senha: (vazia)

## 🧪 Testes

Os testes de integração são os do projeto base do desafio e cobrem a listagem, a inserção e a exclusão de cidades e a atualização de eventos:

```bash
./mvnw clean verify
```

## 📌 Exemplos de Requisições

### Listagem de cidades

```http
GET /cities
```

### Inserção de cidade

```http
POST /cities
```

```json
{
  "name": "Recife"
}
```

### Exclusão de cidade

```http
DELETE /cities/5
```

### Atualização de evento

```http
PUT /events/1
```

```json
{
  "name": "Expo XP",
  "date": "2021-05-19",
  "url": "https://expoxp.com.br",
  "cityId": 7
}
```
