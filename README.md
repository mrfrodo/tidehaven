# Tidehaven

In the restless seas of Tidehaven, where hidden islands whisper of old secrets, a lone captain’s courage may shape the fate of all that lies beyond the horizon.

### Entities

* Game – Manages the game state, map, player, and main loop.
* Player – Holds stats like health, resources, items, location. Only one player.
* Ship – Represents the player’s ship, can hold items.
* Island – Locations that the player can visit; each island has events.
* Event – Story events, choices, consequences.

### Value objects

* Event – Story events, choices, consequences.
---

### Aggregate roots
* Game -> Player, Ship, Island

---
### Aggregates
* Game, Player, Ship, Islan

---

### Database
* H2 stores game state
---
### Architecture and design
* Using DDD domain driven design to model core buisness logic and domain entities
* Using hexagonal architecture using ports and adapter
* Core package com.frodo.tidehaven
* Using java and spring boot framework with spring data jdbc

* Using java records where appropriate for value object and other immutable constructs
* 
* 



          ┌──────────────────────────┐
          │        Application       │
          │     (Use Cases)         │
          └──────────┬──────────────┘
                     │
      ┌──────────────┼──────────────┐
      │              │              │
┌─────▼─────┐  ┌────▼─────┐  ┌─────▼─────┐
│   Domain   │  │   Ports  │  │ Adapters  │
│ (Entities) │  │(Interfaces)│ │ DB, REST │
└────────────┘  └──────────┘  └───────────┘