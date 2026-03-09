# 🚀 JMS Training Project - Spring Boot & ActiveMQ

Este projeto é um guia prático para entender a comunicação assíncrona entre sistemas utilizando **JMS (Java Message Service)** e o broker **ActiveMQ Classic**.

O objetivo é demonstrar como um sistema pode enviar mensagens para uma fila (Queue) de forma desacoplada, garantindo que o processamento de dados ocorra em segundo plano.



## 🛠️ Tecnologias e Ferramentas
* **Java 17**
* **Spring Boot 3.x / 4.x**
* **ActiveMQ Classic 5.19+** (via Docker)
* **Maven**

## 🏗️ Estrutura do Projeto
O projeto demonstra o fluxo **Ponto-a-Ponto (P2P)**:
1. **Producer (`PedidoPublisher`)**: Envia mensagens de texto/JSON para o broker.
2. **Broker (ActiveMQ)**: Servidor intermediário que armazena as mensagens.
3. **Consumer (`PedidoReceiver`)**: Escuta a fila assincronamente via `@JmsListener`.

## 🚀 Como Iniciar o Broker (ActiveMQ)

Execute o comando abaixo para subir o servidor com a porta de dados (`61616`) e o console web (`8161`):

```bash
docker run -d -p 8161:8161 -p 61616:61616 apache/activemq-classic:5.19.2
