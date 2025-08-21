# MazeSolver-Project
### Author
- **Name:** K. Pranvith Chowdary
- **Roll No:** SE22UCSE133

***

## Overview

The Maze Solver Project is a graphical application that allows users to generate and solve random mazes using classic algorithms. Users can interactively solve mazes or let the program demonstrate solutions using **Breadth-First Search (BFS)** and **Depth-First Search (DFS)**. The project includes features to adjust maze difficulty, track completion time, and visualize maze traversal.

***
click here to access the game: https://github.com/Pranvith-kethineni/MazeSolver-Project/blob/main/MazeSolverGUI.jar
***
## Features

- **Maze Generation:** Randomly generates mazes with guaranteed solvable paths.
- **Player Control:** Move through the maze using arrow keys.
- **Timer:** Tracks how long the user takes to solve the maze.
- **Algorithmic Solving:** Solve the maze using BFS and DFS via dedicated buttons.
- **Difficulty Modes:** Select between Easy, Medium, and Hard for different challenge levels.
- **Dynamic GUI:** Maze grid, player position (blue), and goal (red) visualized and resized dynamically.
- **Interactive Pop-Ups:** Receive notifications when the goal is reached.

***

## Technologies Used

- **Java:** Core programming language for the project.
- **Swing:** GUI framework used for interactive panels, buttons, and labels.
- **Java Collections Framework:** Utilized for BFS (Queue, LinkedList).
- **Point Class:** Represents positions within the maze.

***

## Installation

1. **Prerequisite:** Make sure you have **Java JDK 8** or higher installed.
2. **Clone the Repository:**  
   ```bash
   git clone https://github.com/yourusername/mazesolverproject.git
   ```
3. **Compile the Code:**
   ```bash
   javac MazeSolverGUI.java
   ```
4. **Run the Application:**
   ```bash
   java MazeSolverGUI
   ```

***

## Usage

1. **Start the Application:** A window appears with the maze, player, and goal.
2. **Move the Player:** Use arrow keys to navigate the maze.
3. **Solve Automatically:** Click "Solve with BFS" or "Solve with DFS" to see the algorithmically solved path.
   - **BFS:** Finds the shortest path.
   - **DFS:** Explores the maze depth-first.
   - **A\*:** (Coming soon) Will use heuristics for optimal paths.
4. **Track Time:** Timer displays the time taken to solve the maze and congratulates the player upon completion.
5. **Change Difficulty:** Use the "Difficulty" dropdown to regenerate and adjust maze complexity.

***

## Code Structure

| Class                | Responsibilities                                                                 |
|----------------------|----------------------------------------------------------------------------------|
| **Maze**             | Generates maze grid, places walls, ensures solvable path, validates moves.        |
| **Solver**           | Implements BFS and DFS for maze solving.                                          |
| **Player**           | Tracks player position, manages movement, win state.                              |
| **MazePanel**        | Renders maze, draws player and goal, updates UI.                                  |
| **MazeSolverGUI**    | Main GUI, interface management, algorithm control buttons, timer, difficulty.     |

***

## Future Improvements

- Implement **A\*** algorithm for heuristic-based solving.
- Enhance visuals (e.g. highlight solution path).
- Additional gameplay and interface enhancements.

***

## License

This project is open-source. 
