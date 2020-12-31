import javax.swing.*;
import java.awt.*;

public class CreateAccount {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblUserName, lblPW1, lblPW2;

    public CreateAccount(){
        frame = new JFrame();
        panel = new JPanel();
        lblUserName = new JLabel("User Name: ");
        lblPW1 = new JLabel("Password: ");
        lblPW2 = new JLabel("Repeat Password: ");



        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setResizable(false);
        frame.setTitle("Create Account");
        frame.pack();

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
