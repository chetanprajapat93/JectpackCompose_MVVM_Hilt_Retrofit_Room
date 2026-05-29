# JectpackCompose_MVVM_Hilt_Retrofit_Room

## 📱 Overview

A modern Android application built with **Kotlin**, **Jetpack Compose**, **MVVM Architecture**, **Hilt**, **Retrofit**, and **Room Database**.

This project demonstrates Android development best practices by combining a declarative UI with Jetpack Compose, scalable architecture using MVVM, dependency injection through Hilt, remote API integration using Retrofit, and local data persistence with Room Database.

The project is designed as a reference for developers looking to learn or implement modern Android development patterns.

---

## 🚀 Features

* Jetpack Compose UI
* MVVM Architecture
* Dependency Injection using Hilt
* REST API Integration with Retrofit
* Local Data Persistence using Room Database
* Kotlin Coroutines for asynchronous operations
* State Management with Compose
* Repository Pattern
* Error Handling & Loading States
* Material Design 3 Components
* Clean and Maintainable Code Structure

---

## 🛠 Tech Stack

| Technology      | Purpose                   |
| --------------- | ------------------------- |
| Kotlin          | Programming Language      |
| Jetpack Compose | Modern Android UI Toolkit |
| MVVM            | Architecture Pattern      |
| Hilt            | Dependency Injection      |
| Retrofit        | Network/API Communication |
| Room Database   | Local Storage             |
| Coroutines      | Background Processing     |
| ViewModel       | UI State Management       |
| Material 3      | UI Components & Design    |

---

## 🏗 Architecture

The application follows the **MVVM (Model-View-ViewModel)** architecture.

```text
UI (Jetpack Compose)
        │
        ▼
ViewModel
        │
        ▼
Repository
   ┌───────────┐
   │           │
   ▼           ▼
Retrofit     Room
(API)      (Database)
```

### Layers

#### UI Layer

* Compose Screens
* State Management
* User Interactions

#### ViewModel Layer

* Business Logic
* State Handling
* Data Preparation

#### Repository Layer

* Single Source of Truth
* Coordinates Local and Remote Data

#### Data Layer

* Retrofit APIs
* Room Database
* Data Models

---

## ⚙️ Libraries Used

```gradle
Jetpack Compose
Hilt
Retrofit
Room
Kotlin Coroutines
Lifecycle ViewModel
Navigation Compose
Material3
```

---
## ▶️ Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/JectpackCompose_MVVM_Hilt_Retrofit_Room.git
```

### Open in Android Studio

1. Open Android Studio
2. Select "Open Project"
3. Choose the cloned repository
4. Sync Gradle
5. Run the application

---

## 🎯 Learning Objectives

This project demonstrates:

* Modern Android Development
* Jetpack Compose Fundamentals
* MVVM Architecture
* Dependency Injection with Hilt
* Retrofit API Integration
* Room Database CRUD Operations
* State Management
* Repository Pattern
* Clean Code Principles

---

## 🤝 Contributing

Contributions are welcome.

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push the branch
5. Create a Pull Request

---

## 📄 License

This project is available for learning and educational purposes.

---

## 👨‍💻 Author

**Chetan Prajapat**

Senior Android Developer

* Kotlin
* Jetpack Compose
* MVVM
* Hilt
* Retrofit
* Room Database
* Clean Architecture
