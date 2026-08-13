# Design Decisions

## PostgreSQL

Use PostgreSQL as the relational database because it provides strong SQL capabilities and is a good production-grade database to learn deeply. The trade-off is more infrastructure than a lightweight embedded database.

## Spring JDBC

Use Spring JDBC with `JdbcTemplate` instead of JPA/Hibernate to keep SQL and database interactions explicit and simple. The trade-off is writing more SQL manually.

## Neon

Use Neon as the development PostgreSQL database instead of running PostgreSQL locally to minimize resource usage on the development machine. The trade-off is requiring an internet connection and depending on an external service.
