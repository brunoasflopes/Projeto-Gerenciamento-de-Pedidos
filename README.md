# Aplicação Spring Boot com MySQL e RabbitMQ

Este projeto é uma aplicação Spring Boot que gerencia produtos e pedidos, utilizando MySQL como banco de dados e RabbitMQ para processar mudanças de status de pedidos de forma assíncrona. Este repositório inclui um arquivo `docker-compose.yml` para facilitar a configuração e execução dos serviços necessários.

## Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Estrutura do Projeto

- **Dockerfile**: Arquivo de configuração Docker para a construção da imagem da aplicação Spring Boot.
- **docker-compose.yml**: Arquivo para orquestrar os contêineres Docker (MySQL, RabbitMQ, e a aplicação Spring Boot).
- **src/**: Código-fonte da aplicação Spring Boot.

## Infraestrutura AWS

Implantação na AWS -
1. Criar um Cluster ECS
Acesse o Amazon ECS Console.
Crie um cluster (recomendado: Fargate para gerenciamento automático).
2. Configurar Amazon RDS para MySQL
Acesse o Amazon RDS Console.
Crie uma instância MySQL, configure o acesso e anote as credenciais.
3. Criar um Repositório no Amazon ECR
Acesse o Amazon ECR Console.
Crie um repositório para armazenar a imagem Docker.
4. Criar uma Definição de Tarefa no ECS
No Amazon ECS Console, crie uma definição de tarefa.
Use a imagem do ECR e configure variáveis de ambiente para conectar ao RDS e RabbitMQ.
5. Criar um Serviço no ECS
Crie um serviço no ECS, vinculando-o à definição de tarefa.
Configure o balanceador de carga (Application Load Balancer) se necessário.
6. Configurar o RabbitMQ
Opção 1: Amazon MQ: Crie um broker RabbitMQ no Amazon MQ Console.
Opção 2: ECS: Adicione um serviço RabbitMQ ao seu cluster ECS.
7. Configurar Networking e Segurança
Ajuste os Security Groups para permitir tráfego nas portas necessárias (3306 para MySQL, 5672 para RabbitMQ, 80/443 para ALB).
Verifique as configurações de VPC e subnets.
8. Testar a Aplicação
Obtenha o DNS do Load Balancer e acesse a aplicação no navegador.
Monitore logs e métricas no Amazon CloudWatch.


