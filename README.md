# 📘 Plataforma de Feedback Acadêmico

**Tech Challenge – Fase 4**

Projeto desenvolvido para o **Tech Challenge – Fase 4**, com foco em **Cloud Computing, Serverless, Segurança JWT e Deploy de Aplicações em Nuvem**.

---

## 📌 Descrição do Projeto

Este projeto consiste no desenvolvimento de uma **plataforma de feedback acadêmico** que permite aos estudantes avaliarem aulas e aos administradores acompanharem a satisfação dos alunos por meio de **notificações automáticas**, **relatórios periódicos** e **controle de acesso por autenticação JWT**.

A aplicação foi construída utilizando **arquitetura desacoplada**, **mensageria**, **segurança baseada em tokens** e **funções serverless**, garantindo **escalabilidade**, **resiliência** e **facilidade de manutenção**.

---

## 🎯 Objetivo

O sistema tem como objetivos principais:

* Receber feedbacks dos alunos
* Identificar automaticamente feedbacks críticos
* Enviar notificações automáticas para administradores
* Gerar relatórios semanais de feedback
* Executar em ambiente cloud
* Utilizar arquitetura serverless
* Implementar autenticação e autorização via JWT
* Possuir deploy automatizado
* Disponibilizar monitoramento da aplicação

---

## 🏗️ Arquitetura da Solução

A arquitetura segue o padrão de **microsserviços com mensageria**, utilizando **funções serverless** para processamento assíncrono e **JWT para segurança**.

### Fluxo da aplicação:

```
Cliente
  |
  |--> API REST (Quarkus + JWT)
         |
         |--> Banco de Dados MySQL
         |
         |--> RabbitMQ (Exchange + Queue)
                  |
                  |--> Função Serverless de Notificação
                  |
                  |--> Logs e Monitoramento
```

Cada componente possui **responsabilidade única**, garantindo baixo acoplamento e melhor manutenibilidade.

---

## 🛠️ Tecnologias Utilizadas

* Java 17
* Quarkus
* SmallRye JWT (MicroProfile JWT)
* RabbitMQ
* MicroProfile Reactive Messaging
* MySQL
* Docker
* Arquitetura Serverless
* Cloud Computing

---

## 🔐 Segurança com JWT

A aplicação utiliza **JWT (JSON Web Token)** para autenticação e autorização.

### Perfis de Usuário

* **ADMIN** – acesso a relatórios e funcionalidades administrativas
* **STUDENT** – envio de avaliações

### Usuários Criados Automaticamente (Startup)

No início da aplicação, os seguintes usuários são criados automaticamente caso não existam:

| Email                                   | Senha | Role    |
| --------------------------------------- | ----- | ------- |
| [admin@fiap.com](mailto:admin@fiap.com) | 123   | ADMIN   |
| [aluno@fiap.com](mailto:aluno@fiap.com) | 123   | STUDENT |

---

## 🔑 Autenticação

### Endpoint de Login

```
POST /auth/login
```

**Body (JSON):**

```json
{
  "email": "admin@fiap.com",
  "senha": "123"
}
```

✔ Retorna um **JWT** válido.

---

## 🧪 Testes com Postman

### Uso do Token JWT

Para acessar endpoints protegidos, é obrigatório informar o token no **Header**:

```
Authorization: Bearer <SEU_TOKEN_AQUI>
```

⚠️ Atenção:

* Deve existir **um espaço** entre `Bearer` e o token
* Não utilizar query string para enviar o token

---

## 🔒 Endpoints Protegidos

### Relatório Semanal (ADMIN)

```
GET /relatorio/semanal
```

* Requer token JWT
* Requer role **ADMIN**

Anotação utilizada:

```java
@RolesAllowed("ADMIN")
```

---

## ☁️ Serverless

O projeto implementa **duas funções serverless obrigatórias**, conforme solicitado no desafio:

### Função 1 – Avaliação

* Recebe feedbacks via endpoint REST
* Persiste dados no banco de dados
* Publica eventos no RabbitMQ

### Função 2 – Notificação

* Consome mensagens do RabbitMQ
* Identifica feedbacks críticos
* Processa e envia notificações automaticamente

Ambas seguem rigorosamente o **princípio da Responsabilidade Única**.

---

## 🚨 Notificações Automáticas

Quando uma avaliação é considerada **urgente**, o sistema gera automaticamente uma notificação contendo:

* Descrição do feedback
* Indicador de urgência
* Data e hora do envio

As notificações são enviadas de forma **assíncrona**, utilizando **RabbitMQ**.

---

## 📊 Relatório Semanal

O sistema gera relatórios semanais contendo:

* Quantidade de avaliações por dia
* Quantidade de avaliações urgentes e não urgentes
* Média geral das avaliações
* Histórico de feedbacks

Esses dados auxiliam os administradores na **análise da satisfação dos alunos** e na **tomada de decisão**.

---

## 🐇 Configuração do RabbitMQ

**Exchange**

* Nome: `feedback-exchange`
* Tipo: `topic`

**Queue**

* Nome: `feedback-queue`

**Routing Key**

* `feedback.avaliacao`

---

## 📂 Estrutura do Projeto

```
src/main/java
org/fiap
├── avaliacao
│   ├── controller
│   ├── dto
│   ├── entity
│   └── repository
├── seguranca
│   ├── service
│   └── dto
├── notificacao
│   ├── consumer
│   ├── dto
│   └── service
└── relatorio
    ├── controller
    ├── dto
    └── service
```

---

## 🚀 Deploy

O deploy é realizado via **Docker**, garantindo:

* Ambiente padronizado
* Facilidade de execução em nuvem
* Escalabilidade
* Inicialização automática dos serviços

---

## 📈 Monitoramento

A aplicação é monitorada por meio de:

* Logs estruturados do Quarkus
* Console administrativo do RabbitMQ
* Monitoramento de filas, exchanges e mensagens processadas

---

## ✅ Conclusão

O projeto atende **integralmente aos requisitos do Tech Challenge – Fase 4**, incorporando **Cloud Computing**, **Serverless**, **Mensageria**, **Segurança JWT**, **Monitoramento** e **Boas Práticas de Arquitetura**, entregando uma solução **robusta**, **segura**, **escalável** e **preparada para ambiente de produção**.
