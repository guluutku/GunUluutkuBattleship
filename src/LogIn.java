import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn {

    private JFrame frame;
    private JPanel panel;
    private JButton btnLogIn, btnCreate;
    private JLabel lblUserName, lblPassword;
    private JTextField txtUserName;
    private JPasswordField passwordField;

    public LogIn(){
        frame = new JFrame();
        panel = new JPanel();
        btnLogIn = new JButton("Gir");
        btnCreate = new JButton("Create Account");
        lblUserName = new JLabel("Username: ");
        lblPassword = new JLabel("Password: ");
        txtUserName = new JTextField();
        passwordField = new JPasswordField();

        lblUserName.setBounds(10,60, 70,25);
        lblPassword.setBounds(10, 90, 70, 25);

        txtUserName.setBounds(80, 60, 200,25);
        passwordField.setBounds(80, 90, 200,25);

        btnLogIn.setBounds(30, 130, 90, 30);
        btnCreate.setBounds(200, 130, 100, 30);

        btnCreate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new CreateAccount();
                }
            }
        );

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);
        panel.add(lblUserName);
        panel.add(lblPassword);
        panel.add(txtUserName);
        panel.add(passwordField);
        panel.add(btnLogIn);
        panel.add(btnCreate);

        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Log-in");
        frame.pack();

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

}
