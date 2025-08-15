import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {
    private Maze maze;
    private Player player;

    public MazePanel(Maze maze, Player player) {
        this.maze = maze;
        this.player = player;
        setFocusable(true);
        setPreferredSize(new Dimension(maze.getSize() * 40, maze.getSize() * 40));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[][] mazeData = maze.getMaze();
        int size = maze.getSize();

        // Drawing the maze
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (mazeData[i][j] == 1) {
                    g.setColor(Color.BLACK);  // Wall
                } else {
                    g.setColor(Color.WHITE);  // Path
                }
                g.fillRect(j * 40, i * 40, 40, 40);
            }
        }

        // Draw the player
        g.setColor(Color.BLUE);
        g.fillOval(player.getY() * 40 + 10, player.getX() * 40 + 10, 20, 20);

        // Draw the goal
        g.setColor(Color.RED);
        g.fillRect(maze.getGoalY() * 40 + 10, maze.getGoalX() * 40 + 10, 20, 20);
    }
}
