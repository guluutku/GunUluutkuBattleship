import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creation of account frame
public class CreateAccount {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblUserName, lblPW1, lblPW2;
    private JTextField txtUsername;
    private JPasswordField pw1, pw2;
    private JButton btnCreateAccount;

    private String userName;
    private char[] password1, password2;

    public CreateAccount(){

        frame = new JFrame();
        panel = new JPanel();
        lblUserName = new JLabel("User Name: ");
        lblPW1 = new JLabel("Password: ");
        lblPW2 = new JLabel("Repeat Password: ");
        txtUsername = new JTextField();
        pw1 = new JPasswordField();
        pw2 = new JPasswordField();
        btnCreateAccount = new JButton("Create New Account");

        lblUserName.setBounds(10,60, 90,25);
        lblPW1.setBounds(10, 90, 90, 25);
        lblPW2.setBounds(10, 120, 120, 25);


        txtUsername.setBounds(150, 60, 200,25);
        pw1.setBounds(150, 90, 200,25);
        pw2.setBounds(150, 120, 200, 25);

        btnCreateAccount.setBounds(200, 160, 100, 30);
        btnCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = txtUsername.getText();
                password1 = pw1.getPassword();
                password2 = pw2.getPassword();

                    //Database connection
                    new DB_Connection().CreateNewPlayer(userName, password1);

            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);
        panel.add(lblUserName);
        panel.add(lblPW1);
        panel.add(lblPW2);
        panel.add(txtUsername);
        panel.add(pw1);
        panel.add(pw2);
        panel.add(btnCreateAccount);

        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setResizable(false);
        frame.setTitle("Create Account");
        frame.pack();

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
