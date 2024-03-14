# Enabling lazy initialization breaks Kafka Listeners

This is a small sample project for the [Enabling lazy initialization breaks Kafka Listeners #2919](https://github.com/spring-cloud/spring-cloud-stream/issues/2919) issue.

## Usage

First, start the dependencies with the Docker Compose file:
```
docker-compose up
```

Then run the Spring Boot application. It will automatically start sending messages into the Kafka queue every second.

## Description of the problem

When the lazy initialization is switched off in the `application.yaml` file:

```yaml
main:
  lazy-initialization: false
```

Then, the Kafka listener is working correctly and receiving messages, the log contains the following output, as expected:

```
Sent message 1
Recieved message 1
Sent message 2
Recieved message 2
Sent message 3
Recieved message 3
```

But when the `lazy-initialization` property is set to `true`, the listener does not reveice any messages, the output log only contains the sent messages:

```
Sent message 1
Sent message 2
Sent message 3
```

In both cases, the listener and producer classes are created, they can be found in the beginning of the log:

```
ExampleListener created
ExampleProducer created
```
