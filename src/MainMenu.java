import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblWelcome, lblUserScore;
    private JButton btnStart;

    public MainMenu(int ID, String name, int score){

        frame = new JFrame("Menu");
        panel = new JPanel();
        lblWelcome = new JLabel("Welcome " + name);
        lblUserScore = new JLabel("Your total score: "+ score);
        btnStart = new JButton("Search Game");

        // Labels
        lblWelcome.setBounds(120, 5, 200, 150);
        lblUserScore.setBounds(130, 30, 200, 150);

        // Buttons
        btnStart.setBounds(150, 130, 200, 30);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameBoard(ID, score);
            }
        });

        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);
        panel.add(lblWelcome);
        panel.add(lblUserScore);
        panel.add(btnStart);

        // Frame code
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

}
