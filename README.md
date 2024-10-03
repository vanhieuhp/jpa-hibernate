## JPA Hibernate

Welcome to my project where I explore and implement **Java Persistence API (JPA)**. This project showcases my learning path and the key concepts I have encountered, along with some practical examples. My goal is to help others who are also starting their journey with JPA by sharing knowledge and experiences.

## Overview

Java Persistence API (JPA) is a specification for managing relational data in Java applications. It simplifies database operations and abstracts away much of the complexity involved in handling data persistence. This project covers various JPA concepts, from the basics to advanced features, including:

- Entities and Entity Mapping
- Relationships (One-to-One, One-to-Many, Many-to-Many)
- JPQL and Criteria API
- Projections and Custom Queries
- Transactions and Entity Lifecycle
- Integration with Spring Data JPA
- Error Handling and Best Practices
- Resolve N+1 Problem
- Performance Tuning
- Caching Strategies
- Auditing and Logging
- Testing with JPA Repositories
- Locking Strategies
- Inheritance Mapping
- JPA with Spring Boot
- Transaction Management

## Project Structure

The project is organized into the following modules:

1. **Basic Entity Mapping**: Introduction to defining entities and mapping them to database tables.
2. **Relationships in JPA**: Demonstrates how to handle different types of relationships between entities (e.g., One-to-One, Many-to-One, Many-to-Many).
3. **JPQL and Native Queries**: Examples of using JPQL for querying data and performing operations.
4. **Projections and DTOs**: Shows how to use projections to fetch specific data from the database.
5. **Transactions and Lifecycle**: Explores how JPA manages entity states and how to work with transactions.

## Key Learnings

Throughout my journey with JPA, I have learned several important lessons:

- **Entity Relationships**: Understanding the importance of mapping relationships properly in JPA and how cascade operations work between entities.
- **Lazy vs Eager Loading**: Balancing between performance and data needs using different fetching strategies.
- **Error Handling**: Dealing with common errors like lazy initialization, transaction management, and persistence exceptions.
- **Projections**: The ability to fetch custom subsets of data using DTOs and interface-based projections.
- **Performance Tuning**: Techniques for optimizing database queries, including batch processing, caching, and query hints.
- **Testing with JPA Repositories**: Writing tests for JPA repositories using in-memory databases and test containers.
- **Integration with Spring Boot**: Leveraging Spring Boot features like auto-configuration, dependency injection, and transaction management.
- **Locking Strategies**: Understanding different locking mechanisms to prevent concurrent access issues.
- **Inheritance Mapping**: Implementing inheritance hierarchies in JPA using various strategies like single table, joined, and table per class.

I encountered challenges, especially with more complex relationships and custom queries, but working through them deepened my understanding of how JPA works under the hood.

## Tools and Technologies

- **Java 21**: As the core programming language.
- **Spring Boot**: For building the project and managing dependencies.
- **Hibernate**: As the JPA provider.
- **PostgreSQL/MySQL**: For production-level persistence.

## My Canva Slide
[Canva Slide](https://www.canva.com/design/DAGSScN4uCM/qsBbqE903xQzzkdiauTiSQ/edit?utm_content=DAGSScN4uCM&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton) 

## References
[medium.com](https://medium.com/jpa-java-persistence-api-guide)
