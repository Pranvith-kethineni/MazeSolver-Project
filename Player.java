import java.awt.event.KeyEvent;

public class Player {
    private int x, y;
    private Maze maze;

    public Player(Maze maze) {
        this.maze = maze;
        reset();  // Initialize player at the starting position
    }

    public void move(int keyCode) {
        int nx = x, ny = y;
        switch (keyCode) {
            case KeyEvent.VK_UP:    // Up
                nx--;
                break;
            case KeyEvent.VK_DOWN:  // Down
                nx++;
                break;
            case KeyEvent.VK_LEFT:  // Left
                ny--;
                break;
            case KeyEvent.VK_RIGHT: // Right
                ny++;
                break;
        }
        
        // If the move is valid, update the player's position
        if (maze.isValidMove(nx, ny)) {
            x = nx;
            y = ny;
        }
    }

    // Check if the player has reached the goal
    public boolean hasWon() {
        return x == maze.getGoalX() && y == maze.getGoalY();
    }

    // Reset player to the starting position
    public void reset() {
        x = maze.getStartX();
        y = maze.getStartY();
    }

    // Getters for the player's position
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
