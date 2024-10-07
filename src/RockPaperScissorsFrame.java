import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RockPaperScissorsFrame extends JFrame {
    // Declare the components of the frame
    JButton rockButton, paperButton, scissorsButton, quitButton;
    JPanel mainPanel, playPanel, statsPanel, resultPanel;
    JLabel titleLabel, playerWinsLabel, computerWinsLabel, tiesLabel, totalLabel;
    ImageIcon titleIcon, rockIcon, paperIcon, scissorsIcon, quitIcon;
    JTextField playerWinsField, computerWinsField, tiesField, totalField;
    JTextArea resultArea;
    JScrollPane resultScrollPane;
    int playerWins, computerWins, ties, total;
    Color backgroundColor = new Color(158, 194, 220);

    // Constructor to set up the frame
    RockPaperScissorsFrame() {
        // Set the properties of the frame
        setTitle("Rock Paper Scissors Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));
        // Create panels to hold the components

        createStatsPanel();
        mainPanel.add(statsPanel);

        createResultPanel();
        mainPanel.add(resultPanel);

        createPlayPanel();
        mainPanel.add(playPanel);

        add(mainPanel);
        setVisible(true); //this has to be the last line of the constructor so that all components are added before the frame is displayed

    }


    //methods to create the panels
    private void createPlayPanel() {
        playPanel = new JPanel();
        playPanel.setLayout(new GridLayout(1, 4));
        playPanel.setBorder(new TitledBorder(new EtchedBorder(), "Play Games"));
        playPanel.setBackground(backgroundColor);

        // Create an instance of JButton to add to the frame
        rockButton = new JButton("Rock");
        rockButton.addActionListener((ActionEvent event) -> {
            if (getComputerMove() == 0) {
                resultArea.append("Rock vs Rock: It's a tie!\n");
                ties++;
                tiesField.setText(Integer.toString(ties));

            } else if (getComputerMove() == 1) {
                resultArea.append("Rock vs Paper: Computer wins!\n");
                computerWins++;
                computerWinsField.setText(Integer.toString(computerWins));
            } else {
                resultArea.append("Rock vs Scissors: Player wins!\n");
                playerWins++;
                playerWinsField.setText(Integer.toString(playerWins));
            }
            total++;
            totalField.setText(Integer.toString(total));
        });
        paperButton = new JButton("Paper");
        paperButton.addActionListener((ActionEvent event) -> {
            if (getComputerMove() == 0) {
                resultArea.append("Paper vs Rock: Player wins!\n");
                playerWins++;
                playerWinsField.setText(Integer.toString(playerWins));
            } else if (getComputerMove() == 1) {
                resultArea.append("Paper vs Paper: It's a tie!\n");
                ties++;
                tiesField.setText(Integer.toString(ties));
            } else {
                resultArea.append("Paper vs Scissors: Computer wins!\n");
                computerWins++;
                computerWinsField.setText(Integer.toString(computerWins));
            }
            total++;
            totalField.setText(Integer.toString(total));
        });
        scissorsButton = new JButton("Scissors");
        scissorsButton.addActionListener((ActionEvent event) -> {
            if (getComputerMove() == 0) {
                resultArea.append("Scissors vs Rock: Computer wins!\n");
                computerWins++;
                computerWinsField.setText(Integer.toString(computerWins));
            } else if (getComputerMove() == 1) {
                resultArea.append("Scissors vs Paper: Player wins!\n");
                playerWins++;
                playerWinsField.setText(Integer.toString(playerWins));
            } else {
                resultArea.append("Scissors vs Scissors: It's a tie!\n");
                ties++;
                tiesField.setText(Integer.toString(ties));
            }
            total++;
            totalField.setText(Integer.toString(total));
        });
        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        rockIcon = new ImageIcon("src/Rock.png");
        paperIcon = new ImageIcon("src/Paper.png");
        scissorsIcon = new ImageIcon("src/Scissors.png");
        quitIcon = new ImageIcon("src/Quit.png");

        rockButton.setIcon(rockIcon);
        paperButton.setIcon(paperIcon);
        scissorsButton.setIcon(scissorsIcon);
        quitButton.setIcon(quitIcon);

        playPanel.add(rockButton);
        playPanel.add(paperButton);
        playPanel.add(scissorsButton);
        playPanel.add(quitButton);
    }

    private int getComputerMove() {
        int computerMove = (int) (Math.random() * 3);
        return computerMove;
    }


    private void createStatsPanel() {
        statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(2, 3));
        statsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
        statsPanel.setBackground(backgroundColor);

        // Create an instance of JLabel to add to the frame
        playerWinsLabel = new JLabel("Player Wins");
        computerWinsLabel = new JLabel("Computer Wins");
        tiesLabel = new JLabel("Ties");
        totalLabel = new JLabel("Total Games");


        // Create an instance of JTextField to add to the frame
        playerWinsField = new JTextField();
        computerWinsField = new JTextField();
        tiesField = new JTextField();
        totalField = new JTextField();

        statsPanel.add(playerWinsLabel);
        statsPanel.add(computerWinsLabel);
        statsPanel.add(tiesLabel);
        statsPanel.add(totalLabel);
        statsPanel.add(playerWinsField);
        statsPanel.add(computerWinsField);
        statsPanel.add(tiesField);
        statsPanel.add(totalField);

    }

    private void createResultPanel() {
        resultPanel = new JPanel();
        resultPanel.setBorder(new TitledBorder(new EtchedBorder(), "Results"));
        resultPanel.setBackground(backgroundColor);
        resultArea = new JTextArea(13, 60);
        resultScrollPane = new JScrollPane(resultArea);


        resultArea.setEditable(false);
        resultPanel.add(resultScrollPane);
    }

}
