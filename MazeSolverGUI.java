import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MazeSolverGUI {
    private Maze maze;
    private Solver solver;
    private Player player;
    private MazePanel mazePanel;
    private JLabel timerLabel;
    private Timer timer;
    private int timeElapsed;

    public MazeSolverGUI(int size) {
        this.maze = new Maze(size);
        this.solver = new Solver(maze);
        this.player = new Player(maze);
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Maze Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(maze.getSize() * 40 + 100, maze.getSize() * 40 + 150);

        mazePanel = new MazePanel(maze, player);
        frame.add(mazePanel);

        JPanel controlPanel = new JPanel(new GridLayout(3, 1));

        // Timer Label
        timerLabel = new JLabel("Time: 0s", JLabel.CENTER);
        controlPanel.add(timerLabel);

        // Buttons
        JPanel buttonPanel = new JPanel();
        

        controlPanel.add(buttonPanel);

        // Difficulty Selector
        JPanel difficultyPanel = new JPanel();
        JLabel difficultyLabel = new JLabel("Difficulty:");
        JComboBox<String> difficultySelector = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        difficultySelector.addActionListener(e -> {
            String selection = (String) difficultySelector.getSelectedItem();
            maze.setDifficulty(selection);
            resetGame();  // Call resetGame when difficulty is changed
        });
        difficultyPanel.add(difficultyLabel);
        difficultyPanel.add(difficultySelector);

        controlPanel.add(difficultyPanel);

        frame.add(controlPanel, BorderLayout.SOUTH);

        // KeyListener to move player
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.move(e.getKeyCode());  // Move player based on key press
                mazePanel.repaint();  // Redraw the maze panel
                if (player.hasWon()) {
                    timer.stop();
                    JOptionPane.showMessageDialog(frame, "Congratulations! You solved the maze in " + timeElapsed + " seconds!");
                }
            }
        });

        frame.setFocusable(true);  // Make sure the window can capture key events
        frame.setVisible(true);
        startTimer();
    }

    private void startTimer() {
        timeElapsed = 0;
        timer = new Timer(1000, e -> {
            timeElapsed++;
            timerLabel.setText("Time: " + timeElapsed + "s");
        });
        timer.start();
    }

    private void resetGame() {
        maze.generateMazeWithPath();  // Ensure the maze is solvable
        player.reset();
        mazePanel.repaint();
    }

    public static void main(String[] args) {
        new MazeSolverGUI(10);
    }
}
