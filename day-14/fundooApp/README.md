# Fundoo Notes App — Day 13

This project implements the supplied Use Case 1–10 guide.

Implemented:

- MySQL/JPA persistence for users, notes, labels, note-label relationships, and reminder lists
- BCrypt registration and login with JWT generation
- JWT `OncePerRequestFilter`, stateless Spring Security, and Redis token-validation caching
- Ownership-scoped note CRUD and IDOR-safe note lookup
- Pin, archive, trash, hard-delete, and state validation
- Per-user soft-deleted labels and many-to-many label assignment
- JPA Specification search by title, state, and label
- Optional JMS reminder producer/consumer
- Optional RabbitMQ topic exchange, collaborator queue, activity queue, and `note.shared` routing

## Run

Set `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, and `JWT_SECRET` in the environment, then run:

```bash
./mvnw spring-boot:run
```

Redis is used when available. Set `JMS_ENABLED=true` and/or `RABBIT_ENABLED=true` only after the corresponding broker is running. The defaults keep those integrations disabled so the REST application can start independently.

## Verify

```bash
./mvnw test
```

The integration tests use an in-memory H2 database and verify JWT issuance, protected endpoints, and duplicate-email handling.
