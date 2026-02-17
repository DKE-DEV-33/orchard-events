# OrchardEvents

Minecraft Paper plugin for timed server events.

## Prerequisites
- Java 21
- Gradle (or generate Gradle wrapper)
- Paper 1.21.x server

## Build
```bash
cd "/Users/dallaseaton/Desktop/Codex Projects/orchard-events"
gradle build
```

If `gradle` is not installed:
```bash
brew install gradle
```

## Install On Server
1. Copy jar from `build/libs/` into your Paper server `plugins/` folder.
2. Start/restart the server.

## Commands
- `/event start [seconds]`
- `/event stop`
