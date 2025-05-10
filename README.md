# JPA Hibernate Learning Project

A comprehensive demonstration project showcasing Java Persistence API (JPA) and Hibernate features, patterns, and best practices. This repository serves as both a learning resource and a reference implementation for JPA/Hibernate in Spring Boot applications.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Key Concepts](#key-concepts)
- [JPA Annotations Reference](#jpa-annotations-reference)
- [Optimization Techniques](#optimization-techniques)
- [Tools and Technologies](#tools-and-technologies)
- [Additional Resources](#additional-resources)

## 🔍 Overview

Java Persistence API (JPA) is a specification for managing relational data in Java applications. It simplifies database operations and abstracts away much of the complexity involved in handling data persistence. This project demonstrates various JPA concepts, from basic entity mapping to advanced features like caching and performance optimization.

## ✨ Features

- **Entity Mapping**: Basic and complex entity definitions with various annotations
- **Relationships**: Examples of One-to-One, One-to-Many, Many-to-Many relationships
- **Inheritance Mapping**: Different strategies (SINGLE_TABLE, TABLE_PER_CLASS, JOINED)
- **Composite Keys**: Using @EmbeddedId and @IdClass
- **Custom Queries**: JPQL, Criteria API, and Native SQL examples
- **Projections**: Interface-based and class-based projections (DTOs)
- **Caching**: Second-level cache and query cache with Ehcache
- **Validation**: Bean validation with Jakarta Validation API
- **Transactions**: Transaction management and entity lifecycle
- **Performance Optimization**: Techniques to resolve N+1 problems, batch processing
- **Auditing**: Entity lifecycle event listeners
- **Custom Types**: AttributeConverters and custom type mappings

## 🏗️ Project Structure

The project is organized into domain-specific packages, each demonstrating different JPA concepts:

- **book, author, article**: Publishing domain with relationships
- **user, person**: User management with various mapping techniques
- **movies, cinema**: Entertainment domain with complex relationships
- **vehicle, transport**: Transportation domain with inheritance mapping
- **patient, address**: Healthcare domain with embedded entities
- **product, order**: E-commerce domain with composite keys
- **circle, figure, square**: Geometric shapes with inheritance mapping
- And many more examples...

Each domain package typically contains:
- Entity classes
- DTOs (Data Transfer Objects)
- Service interfaces and implementations
- Repository interfaces

## 📋 Prerequisites

- Java 22 or later
- MySQL 8.0 or later
- Gradle 8.0 or later
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/jpa-hibernate.git
cd jpa-hibernate
```

### 2. Set up the database

Create a MySQL database named `jpa`:

```sql
CREATE DATABASE jpa;
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON jpa.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Configure the application

The default configuration in `application.properties` should work if you've set up the database as described above. If you need to customize it, modify:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jpa
spring.datasource.username=admin
spring.datasource.password=admin
```

### 4. Build and run the application

```bash
./gradlew bootRun
```

The application will start on port 8080 with context path `/api/v1/jpa`.

## 🧠 Key Concepts

Throughout this project, you'll encounter several important JPA concepts:

### Entity Relationships
- **@OneToOne**: One-to-one relationships between entities
- **@OneToMany/@ManyToOne**: One-to-many/Many-to-one bidirectional relationships
- **@ManyToMany**: Many-to-many relationships with join tables

### Fetching Strategies
- **Lazy vs. Eager Loading**: Controlling when related entities are loaded
- **Entity Graphs**: Customizing fetch plans for specific use cases

### Inheritance Mapping
- **Single Table**: All classes in a hierarchy mapped to one table
- **Joined Table**: Each class mapped to its own table with joins
- **Table Per Class**: Each concrete class mapped to a separate table

### Caching
- **First-level Cache**: Session-level caching (always enabled)
- **Second-level Cache**: SessionFactory-level caching for entities
- **Query Cache**: Caching query results

## 📝 JPA Annotations Reference

### Entity Mapping
- **@Entity**: Marks a class as an entity
- **@Table**: Specifies the primary table for the entity
- **@Id**: Marks a field as the primary key
- **@GeneratedValue**: Configures the way of increment of the specified column
- **@Column**: Specifies column mapping for a field
- **@Transient**: Marks a field to be excluded from persistence

### Relationship Mapping
- **@OneToOne**: One-to-one relationship
- **@OneToMany**: One-to-many relationship
- **@ManyToOne**: Many-to-one relationship
- **@ManyToMany**: Many-to-many relationship
- **@JoinColumn**: Specifies a foreign key column
- **@JoinTable**: Specifies a join table for a relationship

### Inheritance Mapping
- **@Inheritance**: Specifies the inheritance strategy
- **@MappedSuperclass**: Base class for entities
- **@DiscriminatorColumn**: Specifies the discriminator column for SINGLE_TABLE strategy
- **@DiscriminatorValue**: Specifies the discriminator value for an entity

### Embedded Types
- **@Embeddable**: Marks a class as embeddable
- **@Embedded**: Marks a field as an embedded object
- **@AttributeOverride**: Overrides attributes of an embedded field

### Advanced Mapping
- **@SecondaryTable**: Maps entity to an additional table
- **@ElementCollection**: Maps a collection of basic or embeddable types
- **@MapKey**: Specifies the map key for a Map collection
- **@OrderBy**: Specifies the ordering of a collection
- **@Formula**: Defines a read-only calculated property

## 🚀 Optimization Techniques

### Resolving N+1 Query Problem
- **@EntityGraph**: Defines graph of entities to be fetched in a single query
- **@BatchSize**: Specifies the size of batches for lazy loading
- **@Fetch(FetchMode.SUBSELECT)**: Uses subselects for collection fetching

### Caching Strategies
- **@Cacheable**: Marks an entity as cacheable
- **@Cache**: Configures the caching strategy for an entity

### Performance Tuning
- **@DynamicInsert/@DynamicUpdate**: Generates SQL with only the changed columns
- **Query Hints**: Optimizes query execution

## 🛠️ Tools and Technologies

- **Java 22**: Core programming language
- **Spring Boot 3.3.3**: Application framework
- **Hibernate 6.x**: JPA implementation
- **MySQL**: Database
- **Ehcache**: Caching provider
- **Flyway**: Database migration
- **Lombok**: Reduces boilerplate code
- **Jakarta Validation API**: Bean validation

## 📚 Additional Resources

- [JPA Specification](https://jakarta.ee/specifications/persistence/)
- [Hibernate Documentation](https://hibernate.org/orm/documentation/)
- [Spring Data JPA Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Canva Slide](https://www.canva.com/design/DAGSScN4uCM/qsBbqE903xQzzkdiauTiSQ/edit?utm_content=DAGSScN4uCM&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)
- [Medium JPA Guide](https://medium.com/jpa-java-persistence-api-guide)

---

This project is designed to be both a learning resource and a reference implementation. Feel free to explore the code, run the examples, and use it as a template for your own JPA/Hibernate projects.