# 📝 Todo List API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Status](https://img.shields.io/badge/Status-Concluído-success)

API REST para gerenciamento de tarefas (Todo List) desenvolvida como desafio de backend. O projeto utiliza **Spring Boot** para criar um sistema CRUD completo, com ordenação de tarefas por prioridade.

## 📋 Índice

* [Sobre o Projeto](#-sobre-o-projeto)
* [Tecnologias](#-tecnologias)
* [Começando](#-começando)
* [Configuração do Banco](#-configuração-do-banco)
* [Endpoints da API](#-endpoints-da-api)
* [Contribuição](#-contribuição)
* [Licença](#-licença)

---

## 💻 Sobre o Projeto

Este projeto foi construído seguindo as boas práticas de desenvolvimento em camadas (Controller, Service, Repository, Entity). A principal regra de negócio implementada é a ordenação inteligente da lista de tarefas:
1.  **Prioridade:** Da maior para a menor.
2.  **Nome:** Ordem alfabética (em caso de empate na prioridade).

---

## 🛠 Tecnologias

* **Java 17**
* **Spring Boot 3** (Web, Data JPA, DevTools)
* **MySQL** (Banco de dados relacional)
* **Maven** (Gerenciamento de dependências)

---

## 🚀 Começando

### Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:
* [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
* [Maven](https://maven.apache.org/)
* [MySQL Server](https://dev.mysql.com/downloads/mysql/)


---

## 🔌 Endpoints da API

A API estará rodando em `http://localhost:8080`. 

| Método | Rota | Descrição |
|---|---|---|
| **POST** | `/todos` | Cria uma nova tarefa |
| **GET** | `/todos` | Lista todas as tarefas (Ordenadas) |
| **PUT** | `/todos` | Atualiza uma tarefa existente |
| **DELETE** | `/todos/{id}` | Remove uma tarefa pelo ID |

### Exemplo de Payload (JSON)

Para criar (`POST`) ou atualizar (`PUT`) uma tarefa:

```json
{
  "nome": "Estudar Java",
  "descricao": "Aprofundar conhecimentos em Spring Boot",
  "realizado": false,
  "prioridade": 3
}