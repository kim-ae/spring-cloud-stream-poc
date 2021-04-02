# Requirements
* Java 11
* Kafka or RabbitMQ

# Messages generated with routing factors
The idea of this example is to show how to implement for kafka and rabbitmq (using SCSt) the idea of routing keys and how a producer could create messages and route to the right consumer.

## RabbitMQ
RabbitMQ already has built in way to do this routing through its topic exchange routing the messages to the right queue.

## Kafka
Kafka does not have this built in, probably there is a way to do it transparent, but I didn't found yet. So the idea is to use the capabilities from scst in conjunction with StreamBridge to achieve this behavios.


# How to use it
## RabbitMQ docker
```bash
docker run --rm -it --name rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management -d
```
## Kafka
Use [this](https://docs.confluent.io/platform/current/quickstart/ce-docker-quickstart.html) docker-compose from confluent in order to get simpler setup.

## Configuration
In order to change from kafka setup to rabbit setup just change the `spring.active.profiles` to kafka or rabbitmq.