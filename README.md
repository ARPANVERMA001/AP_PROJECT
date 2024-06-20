# Stick Hero - JavaFX Project

## Description

Stick Hero is a retro arcade game where the player controls a Stick-Hero with an infinitely incrementing stick. The objective is to move from one platform to another using this rotating stick. The game features various bonuses like cherries that increment the score and add to the fun.

## How to Play

1. **Start the Game**: On the Home Screen, click on the Background to start incrementing the length of the stick.
2. **Control the Stick**: Click again to stop the stick from growing.
3. **Collect Bonuses**: Click once more after the hero starts moving to collect randomly generating cherries.
4. **Avoid Obstacles**: Be cautious of colliding into Platform 2.

You can save your game progress, exit the game, and reload it from the Home screen.

## Project Structure

The project utilizes various OOP concepts including Abstract Classes, Polymorphism, Interfaces, JUnit, Design Patterns, Wrapper Classes, Exception Handling, Serialization-Deserialization, and File Writing. The main game loop is executed in the `Main` class.

### Main Homepage
- **Options**: Start a new game or load a pre-saved game.
- **Game Screen**: Save game state, view score, lives, timer, cherries, and play the game.

### JUnit with Multithreading
- Implemented threading to continuously check the game animation conditions every 10 seconds, outputting "true" to the terminal.

### Multithreaded Timer
- A timer tracks the total time the player has played the game.

### Design Patterns
- **Decorator**: Changes the hero's outfits.
- **Singleton**: Ensures only one timer label is created.

## Media

- Background music is included.
- Most images are self-created using Pixel-Art.

## Screenshots

*(Add relevant screenshots here)*

## GitHub Repository

[Stick Hero - JavaFX Project](https://github.com/ARPANVERMA001/AP_PROJECT.git)

## Notes

We have used absolute paths in the `OutfitHero` class, `GamePlayController`, and `Main` class due to interface constraints. Please change these to relative paths on your system or use appropriate absolute paths.

Ensure proper dependencies are installed to run the project.

## Authors

- Aaradhya Verma (2022004) - [aaradhya22004@iiitd.ac.in](mailto:aaradhya22004@iiitd.ac.in)
- Arpan Verma (2022105) - [arpan22105@iiitd.ac.in](mailto:arpan22105@iiitd.ac.in)

## Acknowledgements

- **Fotor AI Generator**: For generating the platform image.
- **Thanks to**: The TAs, TF, and Professor for extending the deadline by 6 hours.
