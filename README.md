# battleShip-Java
Create a Battleship game using Java
Rules
There is a 10x10 grid representing the ocean
Players take turns placing 5 ships on the grid:
1 Battleship (5 squares)
1 Cruiser (4 squares)
1 Destroyer (3 squares)
1 Submarine (3 squares)
1 Patrol Boat (2 squares)
Ships can be placed horizontally or vertically
Players cannot see the opponent's ship locations
Players take alternate turns guessing grid coordinates
If a guess hits a ship, the square is marked as "Hit"
If a guess misses, it is marked as "Miss"
The game ends when all of one player's ships are sunk
Usage
Compile the Java files: javac *.java
Run the Game class: java Game
Follow the prompts to place your ships and make guesses
The game board will be printed out each turn showing hits, misses, and remaining ships.

Code Overview
Game: Main class to run the game loop and gameplay
Board: Represents the game board and manages ship placement/hits
Player: Abstract player class extended by HumanPlayer and ComputerPlayer
Ship: Represents a ship with location, size, and hit points
