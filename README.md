# Spring Boot Microservices Workshop

A basic project to structure communication among 3 microservices with load balance and service discovery.

**Include:**
- Maven
- H2 Database In memory
- RestTemplate and WebClient Example
- Load Balance
- Service Discovery with Eureka Server
- API MovieDB

# Building the Project

On movie-info-service project, at application.properties change the api.key to your own key.

**Run each project in that order:**
1. discovery-server
2. movie-catalog-service
3. movie-info-service
4. rating-data-service

# Key Concepts
## Fault Tolerance
If there a fault, what is the impact of it in your application? What tolerance your system have to fault?

## Resilience
How many faults the system can tolerate before goes down? The quantity indicates the resilience of the system.

It project was built based on [Spring Boot Microservices Level 1: Communication and Discovery Java Brains](https://www.youtube.com/watch?v=y8IQb4ofjDo&list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas) Tutorial.
