import java.util.Random;

public class Maze {
    private int size;
    private int[][] maze;
    private int startX, startY;
    private int goalX, goalY;

    public Maze(int size) {
        this.size = size;
        maze = new int[size][size];
        generateMazeWithPath();
    }

    public int getSize() {
        return size;
    }

    public int[][] getMaze() {
        return maze;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getGoalX() {
        return goalX;
    }

    public int getGoalY() {
        return goalY;
    }

    public void setDifficulty(String level) {
        int wallDensity;
        switch (level) {
            case "Easy":
                wallDensity = 20;
                break;
            case "Medium":
                wallDensity = 30;
                break;
            case "Hard":
                wallDensity = 40;
                break;
            default:
                wallDensity = 30;
        }
        generateMazeWithPath(wallDensity);
    }

    // Generate maze with walls and paths
    public void generateMazeWithPath() {
        generateMazeWithPath(30);  // Default difficulty is medium
    }

    public void generateMazeWithPath(int wallDensity) {
        Random rand = new Random();
        
        // Generate the maze with random walls
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (rand.nextInt(100) < wallDensity) {
                    maze[i][j] = 1;  // Wall
                } else {
                    maze[i][j] = 0;  // Path
                }
            }
        }

        // Ensure the start and goal positions are open
        startX = 0;
        startY = 0;
        maze[startX][startY] = 0; // Start position

        goalX = size - 1;
        goalY = size - 1;
        maze[goalX][goalY] = 0; // Goal position

        // Ensure there is a path from start to goal
        createPathBetweenStartAndGoal();

        // Check if the goal is reachable, if not regenerate the maze
        if (!isPathReachable(startX, startY, goalX, goalY)) {
            generateMazeWithPath(wallDensity); // Regenerate the maze if no path is found
        }
    }

    // Depth-first search to create a path
    private void createPathBetweenStartAndGoal() {
        boolean[][] visited = new boolean[size][size];
        dfsForPath(startX, startY, visited);
    }

    // Depth-first search to ensure there's a path from start to goal
    private void dfsForPath(int x, int y, boolean[][] visited) {
        if (x < 0 || x >= size || y < 0 || y >= size || visited[x][y] || maze[x][y] == 1) {
            return; // Invalid or already visited cell
        }

        visited[x][y] = true; // Mark as visited
        maze[x][y] = 0; // Clear path for DFS

        // Try moving in all four directions
        dfsForPath(x - 1, y, visited); // Up
        dfsForPath(x + 1, y, visited); // Down
        dfsForPath(x, y - 1, visited); // Left
        dfsForPath(x, y + 1, visited); // Right
    }

    // Check if there's a valid path from (sx, sy) to (ex, ey) using BFS
    private boolean isPathReachable(int sx, int sy, int ex, int ey) {
        boolean[][] visited = new boolean[size][size];
        visited[sx][sy] = true;
        
        // Queue for BFS
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{sx, sy});
        
        // Directions for movement (Up, Down, Left, Right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == ex && y == ey) {
                return true; // Reached the goal
            }

            // Explore all four directions
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < size && ny >= 0 && ny < size && !visited[nx][ny] && maze[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return false; // No path found
    }

    // Check if a move is valid (inside maze and not a wall)
    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size && maze[x][y] != 1;
    }
}
