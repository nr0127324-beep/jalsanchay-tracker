# Jal-Sanchay Tracker

A modern Android application built using **Kotlin** and **Jetpack Compose** for tracking rainwater harvesting and water conservation statistics.

The app helps users calculate harvested rainwater based on rainfall and roof area, monitor tank storage, and maintain daily rainfall records in a clean and minimal UI.

---

# Features

- Add daily rainfall entries
- Calculate harvested rainwater automatically
- Track tank storage capacity
- View recent rainfall records
- Setup roof area and tank capacity
- Simple and user-friendly UI
- Built completely using Jetpack Compose
- Material 3 Design support

---

# Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Android Architecture Components**
- **MVVM Architecture**
- **State Management using Compose**

---

# Project Structure

```text
app/
 ├── data/
 ├── model/
 ├── ui/
 ├── utils/
 ├── viewmodel/
 └── MainActivity.kt
```

---

# Screens

## Dashboard
- Shows total water saved
- Tank storage progress
- Recent rainfall entries

## Entry Screen
- Add rainfall data
- Input validation support

## Setup Screen
- Configure roof area
- Configure tank capacity

---

# Water Harvesting Formula

The app uses the standard rainwater harvesting formula:

```text
Harvested Water (Liters) =
Roof Area (sq.m) × Rainfall (mm) × Runoff Coefficient
```

Default runoff coefficient used:

```text
0.85
```

---

# Requirements

- Android Studio Hedgehog or later
- Minimum SDK: 24
- Kotlin 1.9+
- Gradle 8+

---

# Installation

## 1. Clone Repository

```bash
git clone <your-repository-url>
```

---

## 2. Open Project

Open the project in:

```text
Android Studio
```

---

## 3. Sync Gradle

Wait for Gradle sync to complete.

---

## 4. Run Application

Connect an Android device or start an emulator and click:

```text
Run ▶
```

---

# Build APK

## Debug APK

```bash
./gradlew assembleDebug
```

APK location:

```text
app/build/outputs/apk/debug/
```

---

## Release APK

```bash
./gradlew assembleRelease
```

---

# Main Components

| File | Purpose |
|---|---|
| `DashboardScreen.kt` | Main dashboard UI |
| `EntryScreen.kt` | Rainfall entry screen |
| `SetupScreen.kt` | User setup configuration |
| `CalculationUtils.kt` | Water calculation logic |
| `MainViewModel.kt` | State management |

---

# UI Highlights

- Minimal color palette
- Responsive Compose layouts
- Material 3 cards and buttons
- Clean typography
- Lightweight and beginner-friendly design

---

# Future Improvements

- Firebase integration
- Cloud backup
- Rainfall analytics charts
- Notifications and reminders
- Offline database support
- Multi-language support

---

# Author

Developed using Kotlin and Jetpack Compose for educational and sustainability purposes.