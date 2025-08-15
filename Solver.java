import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class Solver {
    private Maze maze;
    private boolean[][] visited;

    public Solver(Maze maze) {
        this.maze = maze;
    }

    // Solve the maze with the specified algorithm
    public void solveMaze(String algorithm, MazePanel mazePanel) {
        visited = new boolean[maze.getSize()][maze.getSize()];

        boolean solved = false;
        switch (algorithm) {
            case "BFS":
                solved = bfs(mazePanel);
                break;
            case "DFS":
                solved = dfs(maze.getStartX(), maze.getStartY(), mazePanel);
                break;
            case "A*":
                solved = aStar(mazePanel);
                break;
            default:
                solved = false;
        }

        if (!solved) {
            JOptionPane.showMessageDialog(null, "No solution found!");
        }
    }

    // BFS algorithm implementation (simplified)
    private boolean bfs(MazePanel mazePanel) {
        // Use visited to keep track of visited cells
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(maze.getStartX(), maze.getStartY()));
        visited[maze.getStartX()][maze.getStartY()] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // Check if the goal is reached
            if (current.x == maze.getGoalX() && current.y == maze.getGoalY()) {
                return true;
            }

            // Check all possible directions
            for (Point direction : getDirections()) {
                int nx = current.x + direction.x;
                int ny = current.y + direction.y;

                if (maze.isValidMove(nx, ny) && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }

    // DFS algorithm implementation (simplified)
    private boolean dfs(int x, int y, MazePanel mazePanel) {
        if (x == maze.getGoalX() && y == maze.getGoalY()) {
            return true;
        }

        // Mark current cell as visited
        visited[x][y] = true;

        for (Point direction : getDirections()) {
            int nx = x + direction.x;
            int ny = y + direction.y;

            if (maze.isValidMove(nx, ny) && !visited[nx][ny]) {
                if (dfs(nx, ny, mazePanel)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Placeholder for A* algorithm
    private boolean aStar(MazePanel mazePanel) {
        // Implement A* algorithm (currently a placeholder)
        return false; // Example return value
    }

    // Directions (up, down, left, right)
    private Point[] getDirections() {
        return new Point[] {
            new Point(-1, 0), // Up
            new Point(1, 0),  // Down
            new Point(0, -1), // Left
            new Point(0, 1)   // Right
        };
    }
}
