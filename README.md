# User Faker API

API para gerar dados fictícios de usuários utilizando Spring Boot.

## 📋 Funcionalidades
- Gera um único usuário com nome, e-mail e endereço.
- Gera múltiplos usuários com uma única requisição.
- Exporta comandos SQL para inserir os usuários em um banco de dados.

## 🛠 Tecnologias
- Java 21
- Spring Boot 3.4.1
- Java Faker
- Springdoc OpenAPI (Swagger)

## 🚀 Como Executar

1. Clone o repositório:
   ```
   git clone https://github.com/username/user-faker-api.git
   ```
Navegue até o diretório do projeto:

  ```
cd user-faker-api
  ```
Execute o projeto:

  ```
mvn spring-boot:run
  ```
Acesse a API na porta padrão (8080).

🌐 Endpoints
1. Gerar um usuário único
*GET /user*

**Resposta:**

  ```
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "address": "123 Main St, Springfield"
}
  ```
2. Gerar múltiplos usuários
*GET /users?count={number}* Parâmetros:

count (opcional): Número de usuários a serem gerados (padrão: 10).

**Resposta:**

  ```
[
  {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "address": "123 Main St, Springfield"
  },
  {
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "address": "456 Elm St, Gotham"
  }
]
  ```
3. Exportar comandos SQL
*GET /users/export-sql?count={number}&tableName={tableName}* Parâmetros:

count (opcional): Número de usuários a serem gerados (padrão: 10).
tableName (opcional): Nome da tabela onde os dados serão inseridos (padrão: users).

**Resposta:**

  ```
INSERT INTO users (name, email, address) VALUES ('John Doe', 'john.doe@example.com', '123 Main St, Springfield');
INSERT INTO users (name, email, address) VALUES ('Jane Doe', 'jane.doe@example.com', '456 Elm St, Gotham');
  ```
