
![image](https://github.com/rafaelsouzagomes/chess-ioc-practice/assets/41433728/d7fdd7ba-c8e4-477b-a9b6-d955efe01616)

# Chess Backend

## Introduction

This project is a backend service for a chess game, implemented using Java and Spring framework. It aims to reinforce the understanding of key Spring concepts such as Inversion of Control (IoC), Dependency Injection (DI), and Spring Beans.

## Key Concepts

### Inversion of Control (IoC)
Inversion of Control (IoC) is a design principle in software engineering by which the control of objects or portions of a program is transferred to a container or framework. In Spring, IoC is implemented using the IoC container which manages the creation, configuration, and management of beans.

### Dependency Injection (DI)
Dependency Injection (DI) is a design pattern used to implement IoC, where the control of the dependencies of a class is transferred to an external entity. Spring DI can be accomplished via constructor injection, setter injection, or field injection.

### Spring Beans
Spring Beans are the objects that form the backbone of a Spring application. They are managed by the Spring IoC container, which instantiates, configures, and assembles the beans.

## Project Structure

```
chess/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── chess/
│   │   │               ├── config/
│   │   │               ├── controller/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               ├── service/
│   │   │               └── ChessApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── chess/
│                       └── ChessApplicationTests.java
└── pom.xml
```

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- IDE (Eclipse, IntelliJ IDEA, etc.)

### Installation

1. Clone the repository
    ```sh
    git clone https://github.com/yourusername/chess.git
    ```
2. Navigate to the project directory
    ```sh
    cd chess
    ```
3. Build the project using Maven
    ```sh
    mvn clean install
    ```

### Running the Application

1. Navigate to the main application class
    ```sh
    src/main/java/com/example/chess/ChessApplication.java
    ```
2. Run the `ChessApplication` class from your IDE or using the Maven command
    ```sh
    mvn spring-boot:run
    ```

### Usage

The backend exposes RESTful endpoints to interact with the chess game. You can use tools like Postman or cURL to test these endpoints.

### Configuration

The application can be configured using the `application.properties` file located in the `src/main/resources` directory.

## Testing

The project includes unit tests located in the `src/test/java/com/example/chess` directory. To run the tests, use the Maven command:
```sh
mvn test
```


## License

Distributed under the MIT License. See `LICENSE` for more information.

