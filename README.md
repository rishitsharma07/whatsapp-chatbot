# WhatsApp Chatbot Backend

This is a simple WhatsApp chatbot backend simulation I built using Java and Spring Boot. The idea was to create a REST API that mimics how a WhatsApp webhook works — you send it a message, it replies back based on what you said.

## What it does

You hit the `/webhook` endpoint with a POST request containing a JSON body (simulating a WhatsApp message), and the app processes it and sends back a reply. All messages are logged to both the console and a log file.

Supported messages:
- **Hi / Hello** → replies with `Hello!`
- **Bye / Goodbye** → replies with `Goodbye!`
- **Help** → replies with `Available commands: Hi, Bye, Help`
- Anything else → replies with `Sorry, I didn't understand that. Type 'Help' for available commands.`

## Tech used

- Java 17
- Spring Boot 3.5.14
- Maven
- Lombok
- SLF4J + Logback for logging
- Docker (for deployment)
- Render (free hosting)

## Project structure

```
src/main/java/com/chatbot/whatsapp_chatbot/
├── controller/
│   └── WebhookController.java
├── model/
│   └── WhatsappMessage.java
├── service/
│   └── ChatbotService.java
└── WhatsappChatbotApplication.java
```

I kept it simple — the controller just receives the request and passes it to the service. All the actual logic and logging lives in the service layer.

## How to run it locally

Clone the repo and run:

```bash
mvn spring-boot:run
```

Then test it with Postman or curl:

```bash
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"from": "Rishit", "message": "Hi"}'
```

You should get back `Hello!`

## Live URL

I deployed it on Render using Docker:

👉 https://whatsapp-chatbot-7854.onrender.com/webhook

Since it's on the free tier, it might take about 50 seconds to wake up if it hasn't been used in a while — just send the request and wait a bit.

## Logging

Every incoming message and reply gets logged automatically. You can check `chatbot.log` in the project root to see all the logs.