# Logistics Application - Factory Method and Abstract Factory

## Purpose
This Java console application demonstrates the integration of the **Factory Method** and **Abstract Factory** design patterns. It handles cross-platform UI rendering (Windows/macOS) alongside multi-modal logistics transport (Road/Sea).

## Package Structure
- `transport`: Contains `Transport` interface, `Truck`, `Ship`, abstract `Logistics`, `RoadLogistics`, and `SeaLogistics`.
- `ui`: Contains `Button` and `Checkbox` interfaces, concrete UI components for Windows/macOS, `GUIFactory` interface, `WindowsFactory`, and `MacOSFactory`.
- `app`: Contains `DeliveryApplication` client.
- `Main`: Application entry point and startup input configuration.

## Prerequisites
- Java Development Kit (JDK) 17 or higher.

## Build and Run Instructions

### 1. Compile the Application
```bash
javac -d bin src/transport/*.java src/ui/*.java src/app/*.java src/Main.java
