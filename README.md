
![image](https://github.com/rafaelsouzagomes/chess-ioc-practice/assets/41433728/d7fdd7ba-c8e4-477b-a9b6-d955efe01616)


# Chess REST API

Welcome to the Chess REST API project! This project serves as a robust example of how to implement an API for managing chess games, focusing on key principles such as Inversion of Control (IoC), Dependency Injection, and the use of Spring Beans within the Spring framework.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture and Design Patterns](#architecture-and-design-patterns)
- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project was developed to explore and demonstrate advanced concepts in the Spring framework, such as IoC, Dependency Injection, and the use of Spring Beans. The application provides a RESTful API for managing chess games, allowing users to create, update, and query the state of games.

## Features

- Create new chess games
- Make moves in existing games
- Query the state of the board
- Validate moves according to chess rules
- Persistent storage of game states

## Architecture and Design Patterns

### Inversion of Control (IoC) and Dependency Injection

The project utilizes Spring's IoC container to manage the lifecycle and dependencies of the application components. Dependency Injection (DI) is achieved through constructor injection, ensuring that components are loosely coupled and easier to test.

### Service Layer

The `services` package contains the core business logic of the application. Each service is designed to handle specific responsibilities, promoting separation of concerns and making the codebase more maintainable.

### Spring Beans

Spring Beans are used to define and manage the application's components. Beans are configured using annotations, such as `@Service`, `@Component`, and `@Repository`, to enable Spring to automatically detect and manage them.

### Design Patterns

- **Singleton**: Ensuring a single instance of service classes throughout the application.
- **Factory**: Creating instances of chess pieces and other game-related entities.
- **Strategy**: Implementing different move validation algorithms for different chess pieces.
- **Observer**: Notifying interested parties about changes in the game state.

## Project Structure

