# CARE Game Design Documentation

## Architecture Overview

The CARE (Champions Arena) game follows an object-oriented design with clear separation of concerns:

```
Tournament (Main Game Logic)
├── Vizier (Player)
│   └── ArrayList<Champion> (Team)
├── ArrayList<Champion> (Reserve)
└── ArrayList<Challenge> (Challenges)
```

## Class Hierarchy

### Champion Classes
```
Champion (Abstract)
├── Wizard
├── Warrior
└── Dragon
```

### Core Components
- **Tournament**: Implements the CARE interface, manages game state
- **Vizier**: Represents the player, manages treasury and team
- **Challenge**: Represents game challenges with different types

## Design Patterns

### 1. Strategy Pattern
Different champion types implement varying abilities:
- Wizards can handle all challenge types
- Warriors excel only at fight challenges  
- Dragons are strong fighters, with talking dragons handling mysteries

### 2. State Pattern
Champions have different states:
- WAITING (in reserve)
- ENTERED (active in team)
- DISQUALIFIED (failed challenges)

### 3. Template Method
The Champion abstract class provides a template for all champion implementations.

## Key Interfaces

### CARE Interface
Defines the contract for the game implementation:
- Champion management
- Challenge handling
- Treasury operations
- File I/O operations

## Game Rules

### Treasury Management
- Start with 1000 gold
- Pay entry fees to recruit champions
- Earn rewards for successful challenges
- Lose money for failed challenges

### Challenge Resolution
1. Select available champion for challenge type
2. Compare champion skill vs challenge requirement
3. Award/deduct money based on outcome
4. Update champion state if necessary

### Victory/Defeat Conditions
- **Defeat**: Treasury ≤ 0 AND no champions available to retire
- **Victory**: Successfully complete all desired challenges
