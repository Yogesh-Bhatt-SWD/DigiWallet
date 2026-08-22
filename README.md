# 💳 Digital Wallet & Transaction System

A backend-focused **Digital Wallet & Transaction Management System** built with Java and Spring Boot.

The goal of this project is not just to implement CRUD operations, but to practice real-world backend concepts such as **business rule validation, transactional consistency, atomic money transfers, transaction history, idempotency, limits, reversals, and database design**.

> 🚧 **Project Status:** In Development  
> 🎯 **Goal:** Build and complete the core system in 2–3 days with daily Git commits.

---

## 📌 Project Objective

The system simulates a digital wallet platform where users can:

- Maintain money in their wallets
- Deposit money
- Withdraw money
- Transfer money to other users
- View transaction history
- Filter transactions
- Reverse successful transactions

The project also includes administrative functionality for managing users, wallets, and transaction statistics.

The primary focus is on maintaining **correct financial state** even when operations fail or requests are repeated.

---

## 🛠️ Tech Stack

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Maven**
- **REST APIs**
- **Postman**
- **Git & GitHub**

---

## 👤 User Management

Each user has:

- Name
- Email
- Phone
- Status

User statuses:

```text
ACTIVE
BLOCKED
