# 🏛️ Java21_Angular19_Ollama_Chatbot

![screenshot](https://raw.githubusercontent.com/sfestacatenate/Laravel_React_Ollama/refs/heads/main/img/chat_test.png)

This project is a full-stack chatbot application built with **Angular 19** (frontend) and **Java 21** (backend). It provides intelligent responses to questions about the **Basilica of Saint Paul Outside the Walls** in Rome, using the **Gemma 3 12B quantized** language model via **Ollama**.

---

## ✨ Project Overview

The chatbot is designed as a localized web application that delivers accurate, contextual answers related to the historical, architectural, and cultural aspects of the Basilica of Saint Paul Outside the Walls. It integrates a client-side multilingual interface and a locally hosted LLM (Large Language Model), ensuring responsiveness and privacy.

---

## 🧰 Technologies Used

| Layer       | Technology                            |
|-------------|----------------------------------------|
| Frontend    | Angular 19                             |
| Localization | `@ngx-translate/core` (client-side i18n) |
| Backend     | Java 21 (RESTful API)                  |
| LLM Engine  | Ollama                                 |
| Language Model | Gemma 3 - 12B quantized              |

---

## 🌐 Localization

The frontend supports **client-side internationalization** using [`@ngx-translate/core`](https://github.com/ngx-translate/core). Translations are stored in static JSON files and can be easily extended to support additional languages.

---

## 🤖 Language Model

The application uses **Gemma 3 (12B quantized)**, a high-performance local large language model, served via [Ollama](https://ollama.com/). This setup ensures that all AI interactions happen locally without external API dependencies.

---

## 🏛️ Domain Focus

The chatbot is specifically trained and configured to handle queries related to the **Basilica of Saint Paul Outside the Walls**, one of Rome's most significant religious and historical landmarks. It is ideal for educational use, cultural exploration, or tourism enhancement.

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).
