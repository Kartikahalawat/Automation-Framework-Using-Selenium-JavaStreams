# Selenium Java Streams Automation Framework

A Java-based Selenium automation framework demonstrating **web UI automation, reusable test components, Page Object Model, TestNG, and Java Stream API** for writing clean, maintainable, and scalable automation code.

The project focuses on applying **Java programming concepts and functional-style Stream operations** within Selenium automation to improve test-data handling, validation, filtering, and collection processing.

---

## 🚀 Overview

This project demonstrates how **Selenium WebDriver + Java + TestNG + Java Streams** can be combined to build structured and maintainable UI automation.

The framework is designed around reusable automation components rather than writing independent Selenium scripts for every scenario.

### Key Objectives

* Build reusable Selenium WebDriver automation
* Apply **Page Object Model (POM)** principles
* Use **Java Streams** for collection and test-data processing
* Implement maintainable test automation components
* Practice Selenium element identification and browser interactions
* Organize automation code using Maven
* Apply Java OOP and functional programming concepts in test automation

---

## 🛠️ Technology Stack

| Technology             | Purpose                                         |
| ---------------------- | ----------------------------------------------- |
| **Java**               | Programming language                            |
| **Selenium WebDriver** | Web UI automation                               |
| **TestNG**             | Test execution and assertions                   |
| **Java Streams**       | Collection processing and functional operations |
| **Maven**              | Build and dependency management                 |
| **Git/GitHub**         | Version control and source management           |

---

## ✨ Key Features

### 🔹 Selenium Web Automation

* Browser automation using Selenium WebDriver
* Web element identification and interaction
* Handling common web UI operations
* Automated validation of web application behavior

### 🔹 Page Object Model

The framework separates:

* Page-level locators
* Page-level actions
* Test execution logic

This improves **maintainability, readability, and reusability** as the automation suite grows.

### 🔹 Java Streams

Java Stream API is used to work with collections and automation data using operations such as:

* `filter()`
* `map()`
* `sorted()`
* `collect()`
* `forEach()`
* `findFirst()`
* `anyMatch()`
* `allMatch()`

Example:

```java
List<String> productNames = products.stream()
        .map(WebElement::getText)
        .filter(name -> !name.isEmpty())
        .collect(Collectors.toList());
```

This demonstrates how Java functional programming can simplify data extraction and validation in Selenium tests.

### 🔹 Reusable Automation Components

Common Selenium operations are organized into reusable components to reduce duplicate automation code and make test cases easier to maintain.

### 🔹 Maven-Based Project

Maven is used for:

* Dependency management
* Project build
* Test execution
* Standard project structure

---

## 📂 Project Structure

```text
Automation-Framework-Using-Selenium-JavaStreams
│
├── src
│   └── main
│       └── java
│           └── ...
│
├── pom.xml
├── .gitignore
└── README.md
```

The framework can be extended with additional layers such as:

```text
src
├── main
│   └── java
│       ├── pages
│       ├── utilities
│       └── base
│
└── test
    └── java
        └── tests
```

---

## ⚙️ Prerequisites

Before running the project, make sure you have:

* **Java JDK 8+**
* **Maven**
* **Git**
* A supported browser such as Chrome
* Internet connectivity for Maven dependency resolution

Verify the installations:

```bash
java -version
mvn -version
git --version
```

---

## 🔧 Setup

### 1. Clone the repository

```bash
git clone https://github.com/Kartikahalawat/Automation-Framework-Using-Selenium-JavaStreams.git
```

### 2. Navigate to the project

```bash
cd Automation-Framework-Using-Selenium-JavaStreams
```

### 3. Install dependencies

```bash
mvn clean install
```

### 4. Execute tests

```bash
mvn test
```

---

## 🧪 Automation Approach

The framework follows a layered approach where automation responsibilities are separated into logical components.

```text
Test Case
    │
    ▼
Page Object
    │
    ▼
Selenium WebDriver
    │
    ▼
Web Application
```

Java Streams are used wherever collection processing or data transformation is required.

For example:

```text
WebElements
     │
     ▼
Extract Text
     │
     ▼
Java Stream
     │
 ┌───┼───────────────┐
 ▼   ▼               ▼
filter()  map()   sorted()
     │
     ▼
Validation / Assertion
```

---

## 📌 Concepts Demonstrated

### Selenium

* WebDriver
* WebElements
* Locators
* Browser interactions
* Element collections
* UI validations

### Java

* Object-Oriented Programming
* Collections
* Generics
* Lambda Expressions
* Functional Interfaces
* Stream API
* Method References

### Test Automation

* Page Object Model
* Reusable components
* Test organization
* Assertions
* Maintainable automation design

---

## 🎯 Why Java Streams in Selenium?

Selenium frequently returns collections of `WebElement` objects—for example, product lists, table rows, menu items, search results, or links.

Instead of processing these collections using traditional loops, Java Streams can make the operations more expressive and easier to compose.

Example:

```java
List<String> prices = priceElements.stream()
        .map(WebElement::getText)
        .filter(price -> !price.isBlank())
        .collect(Collectors.toList());
```

This approach is particularly useful when automation requires:

* Filtering UI elements
* Extracting text
* Transforming test data
* Sorting results
* Searching collections
* Performing collection-based validations

---

## 📈 Future Enhancements

The framework can be extended with additional enterprise automation capabilities:

* [ ] Cross-browser execution
* [ ] Parallel test execution
* [ ] Explicit wait utilities
* [ ] Configuration management
* [ ] Screenshot capture on failure
* [ ] Logging with Log4j/SLF4J
* [ ] Extent/Allure reporting
* [ ] Data-driven testing
* [ ] CI/CD integration with Jenkins or GitHub Actions
* [ ] Dockerized test execution
* [ ] Selenium Grid / remote execution

---

## 📚 Learning Focus

This project was built to strengthen practical understanding of:

**Selenium WebDriver + Java + TestNG + Java Streams + Automation Framework Design**

The primary focus is not only on automating browser interactions, but also on writing **clean, reusable, and maintainable Java automation code**.

---

## 👨‍💻 Author

**Kartik Ahalawat**

SDET | Quality Engineering & Test Automation | Java | Selenium | Playwright | API Testing

GitHub:
https://github.com/Kartikahalawat

---

## 📄 License

This project is intended for **learning, experimentation, and portfolio demonstration**.
