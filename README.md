# 📘 Plataforma de Feedback Acadêmico

**Tech Challenge – Fase 4**

Projeto desenvolvido para o **Tech Challenge – Fase 4**, com foco em **Cloud Computing, Serverless e Deploy de Aplicações em Nuvem**.

---

## 📌 Descrição do Projeto

Este projeto consiste no desenvolvimento de uma **plataforma de feedback acadêmico** que permite aos estudantes avaliarem aulas e aos administradores acompanharem a satisfação dos alunos por meio de **notificações automáticas** e **relatórios periódicos**.

A aplicação foi construída utilizando **arquitetura desacoplada**, **mensageria** e **funções serverless**, garantindo **escalabilidade**, **resiliência** e **facilidade de manutenção**.

---

## 🎯 Objetivo

O sistema tem como objetivos principais:

* Receber feedbacks dos alunos
* Identificar automaticamente feedbacks críticos
* Enviar notificações automáticas para administradores
* Gerar relatórios semanais de feedback
* Executar em ambiente cloud
* Utilizar arquitetura serverless
* Possuir deploy automatizado
* Disponibilizar monitoramento da aplicação

---

## 🏗️ Arquitetura da Solução

A arquitetura segue o padrão de **microsserviços com mensageria**, utilizando **funções serverless** para processamento assíncrono.

### Fluxo da aplicação:

```
Cliente
  |
  |--> API REST (Quarkus)
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
* RabbitMQ
* MicroProfile Reactive Messaging
* MySQL
* Docker
* Arquitetura Serverless
* Cloud Computing

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

## 🔐 Segurança e Governança

* Uso de variáveis de ambiente para credenciais
* Isolamento de produtores e consumidores
* Controle de acesso à mensageria
* Configuração de filas e exchanges no RabbitMQ

---

## 📈 Monitoramento

A aplicação é monitorada por meio de:

* Logs estruturados do Quarkus
* Console administrativo do RabbitMQ
* Monitoramento de filas, exchanges e mensagens processadas

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
|   ├── entity
│   ├── repository
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

## 🎥 Vídeo de Demonstração

O vídeo de entrega apresenta:

* A aplicação em execução
* Envio de avaliações
* Processamento de mensagens no RabbitMQ
* Execução das funções serverless
* Configurações do ambiente em cloud

---

## ✅ Conclusão

O projeto atende **integralmente aos requisitos do Tech Challenge – Fase 4**, utilizando **Cloud Computing**, **Serverless**, **Mensageria**, **Monitoramento** e **Boas Práticas de Arquitetura**, entregando uma solução **robusta**, **escalável** e **preparada para ambiente de produção**.

