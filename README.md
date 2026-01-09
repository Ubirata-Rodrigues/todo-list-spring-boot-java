#  Todo List API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Status](https://img.shields.io/badge/Status-Concluído-success)

API REST para gerenciamento de tarefas (Todo List) desenvolvida como desafio de backend. O projeto utiliza **Spring Boot** para criar um sistema CRUD completo, com ordenação de tarefas por prioridade.


---

##  Sobre o Projeto

Este projeto foi construído seguindo as boas práticas de desenvolvimento em camadas (Controller, Service, Repository, Entity). A principal regra de negócio implementada é a ordenação inteligente da lista de tarefas:
1.  **Prioridade:** Da maior para a menor.
2.  **Nome:** Ordem alfabética (em caso de empate na prioridade).

---

##  Tecnologias

* **Java 17**
* **Spring Boot 3**
* **Spring MVC**
* **SpringDoc OpenAPI 3**
* **Spring Data JPA**
* **MySQL** 
* **Maven** 

---

## Práticas adotadas

* **SOLID, DRY, YAGNI, KISS**
* **API REST**
* **Consultas com Spring Data JPA**
* **Injeção de Dependências**
* **Tratamento de respostas de erro**
* **Geração automática do Swagger com a OpenAPI 3**

---

## Pré-requisitos para usar o sistema

Antes de começar, você precisará ter instalado em sua máquina:
* [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
* [Maven](https://maven.apache.org/)
* [MySQL Server](https://dev.mysql.com/downloads/mysql/)

##  Como Executar

* **Clonar repositório git**
* **Construir o projeto:**

```console
$ ./mvnw clean package
```

* **Executar a aplicação:**
```console
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```
A API poderá ser acessada em [localhost:8080](https://localhost:8080). O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui/index.html)

---

##  Endpoints da API



| Método | Rota | Descrição |
|---|---|---|
| **POST** | `/todos` | Cria uma nova tarefa |
| **GET** | `/todos` | Lista todas as tarefas (Ordenadas) |
| **PUT** | `/todos` | Atualiza uma tarefa existente |
| **DELETE** | `/todos/{id}` | Remove uma tarefa pelo ID |


Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io/):

* Criar Tarefa
```console
$ http POST :8080/todos nome="Todo 1" descricao="Desc Todo 1" prioridade=1

[
  {
    "descricao": "Desc Todo 1",
    "id": 1,
    "nome": "Todo 1",
    "prioridade": 1,
    "realizado": false
  }
]
```

* Listar Tarefas

```console
$ http GET :8080/todos

[
  {
    "descricao": "Desc Todo 1",
    "id": 1,
    "nome": "Todo 1",
    "prioridade": 1,
    "realizado": false
  }
]
```

* Atualizar Tarefa

```console
$ http PUT :8080/todos/1 nome="Todo 1 Up" descricao="Desc Todo 1 Up" prioridade=2

[
  {
    "descricao": "Desc Todo 1 Up",
    "id": 1,
    "nome": "Todo 1 Up",
    "prioridade": 2,
    "realizado": false
  }
]
```

* Remover Tarefa

```console
http DELETE :8080/todos/1

[ ]
```
