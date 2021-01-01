import javax.swing.*;
import java.awt.*;

public class MainMenu {

    private JFrame frame;
    private JPanel panel;
    private JLabel lbl;

    public MainMenu(){
        frame = new JFrame("Menu");
        panel = new JPanel();

        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
