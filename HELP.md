🚀 Projeto JMS com Spring Boot e ActiveMQ
Este mini projeto demonstra a implementação de uma arquitetura de mensageria assíncrona utilizando o padrão JMS (Java Message Service). O objetivo principal é permitir a comunicação desacoplada entre diferentes partes de um sistema, garantindo que o processamento de pedidos não bloqueie a experiência do usuário.

🛠️ Tecnologias Utilizadas
Java 17+: Linguagem base.

Spring Boot 4.0.3: Framework para facilitar a configuração e o gerenciamento de componentes (Beans).

JMS (Jakarta Messaging): API padrão para troca de mensagens.

ActiveMQ Classic (Docker): O Message Broker responsável por receber, armazenar e entregar as mensagens.

Maven: Gerenciador de dependências.

🏗️ Arquitetura do Sistema
O projeto segue o modelo Ponto-a-Ponto (Queue), onde cada mensagem enviada para a fila é processada por exatamente um consumidor.

Producer (Produtor): Através de um endpoint REST ou serviço interno, o sistema utiliza o JmsTemplate do Spring para enviar dados para a fila fila.pedidos.

Message Broker (ActiveMQ): Atua como o servidor intermediário, mantendo a mensagem segura em uma fila até que o consumidor esteja pronto.

Consumer (Consumidor): Utiliza a anotação @JmsListener para "escutar" a fila de forma assíncrona. Assim que uma mensagem chega, ela é processada automaticamente em uma thread separada.

🌟 Principais Benefícios Demonstrados
Desacoplamento: O produtor não precisa saber quem é o consumidor ou se ele está online no momento do envio.

Escalabilidade: Se a demanda aumentar, podemos subir várias instâncias do consumidor para ler a mesma fila.

Resiliência: Se o consumidor falhar, a mensagem permanece no ActiveMQ para ser reprocessada mais tarde.

📝 Fluxo de Funcionamento
O Broker é iniciado via Docker na porta 61616.

A aplicação Spring Boot se conecta ao Broker usando as credenciais definidas em application.properties.

Um componente envia uma mensagem de texto (ex: "Pedido #123").

O componente @JmsListener detecta a nova mensagem e imprime: <<< Mensagem recebida da fila: Pedido #123.