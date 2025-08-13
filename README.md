# CARE - Champions Arena Game

A Java-based game application developed. Players take on the role of a Vizier managing a team of champions to face various challenges.

##  Game Overview

CARE (Champions Arena) is a strategy game where players:
- Manage a treasury and recruit champions
- Face different types of challenges (Magic, Fight, Mystery)
- Strategically deploy champions based on their abilities
- Earn rewards for successful challenges

## 🏗️ Project Structure

```
CW4-Java/
├── src/main/java/cwk4/          # Main source code
│   ├── Tournament.java          # Main game implementation
│   ├── Champion.java            # Abstract champion class
│   ├── Wizard.java             # Wizard champion type
│   ├── Warrior.java            # Warrior champion type
│   ├── Dragon.java             # Dragon champion type
│   ├── Vizier.java             # Player class
│   ├── Challenge.java          # Challenge implementation
│   ├── ChallengeType.java      # Challenge type enumeration
│   ├── ChampionState.java      # Champion state enumeration
│   ├── CARE.java               # Main interface
│   ├── GameUI.java             # Command line interface
│   ├── GameGUI.java            # Graphical user interface
│   └── Teamwork.java           # Team member details
├── docs/                       # Documentation
├── archive/                    # Archived files and drafts
└── README.md                   # This file
```

##  Getting Started

### Prerequisites
- Java 17 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code with Java extensions)




## Game Features

### Champion Types
- **Wizards**: Can handle all challenge types, necromancers have higher entry fees
- **Warriors**: Excel at fight challenges only
- **Dragons**: Strong fighters, talking dragons can also handle mystery challenges

### Challenge Types
- **Magic**: Requires magical abilities
- **Fight**: Requires combat skills
- **Mystery**: Requires special problem-solving abilities

### Game Mechanics
- Start with 1000 gold in treasury
- Recruit champions for entry fees
- Challenge outcomes based on skill levels
- Failed challenges can disqualify champions
- Game over when treasury is empty and no champions remain

##  Technical Details

### Key Classes
- `Tournament`: Main game logic implementation
- `Champion`: Abstract base class for all champion types
- `Vizier`: Represents the player and their team
- `Challenge`: Represents game challenges
- `CARE`: Interface defining game contract

### Design Patterns Used
- **Strategy Pattern**: Different champion types with varying abilities
- **State Pattern**: Champion states (Waiting, Entered, Disqualified)
- **Template Method**: Champion class structure

##  Team Members
- **Mohamad Khir-Allah** 
- **Bailey Bellenie**  
- **Paulina Milewska** 
- **Naweed Shah** 



##  Future Enhancements
- Network multiplayer support
- Additional champion types
- More complex challenge mechanics
- Enhanced GUI with animations
- Save/load game functionality (partially implemented)

