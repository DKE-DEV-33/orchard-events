# OrchardEvents

Minecraft Paper plugin for timed server events.

## Prerequisites
- Java 21
- Gradle
- Paper 1.21.x server

## Build
```bash
cd "/Users/dallaseaton/Desktop/Codex Projects/orchard-events"
gradle clean build
```

If `gradle` is not installed:
```bash
brew install gradle
```

## Current V1 Scope
- Admin command: `/event start [seconds]`
- Admin command: `/event stop`
- Boss bar countdown for online players
- Start/stop broadcast messages

## Install On Server
1. Copy jar from `build/libs/` into your Paper server `plugins/` folder.
2. Start/restart the server.

## Commands
- `/event start [seconds]`
- `/event stop`

## GitHub Push Checklist
```bash
cd "/Users/dallaseaton/Desktop/Codex Projects/orchard-events"
git status
git add .
git commit -m "Initial OrchardEvents plugin scaffold"
git branch -M main
git remote add origin https://github.com/<YOUR_USER>/<YOUR_REPO>.git
git push -u origin main
```

If `origin` already exists:
```bash
git remote set-url origin https://github.com/<YOUR_USER>/<YOUR_REPO>.git
git push -u origin main
```

## License
Proprietary - see `LICENSE`.
