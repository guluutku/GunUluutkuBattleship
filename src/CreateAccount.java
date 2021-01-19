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
    private JTextField pw;
    private JButton btnCreateAccount;

    private String userName;
    private String password;

    public CreateAccount(){

        frame = new JFrame();
        panel = new JPanel();
        lblUserName = new JLabel("User Name: ");
        lblPW1 = new JLabel("Password: ");
        lblPW2 = new JLabel("Repeat Password: ");
        txtUsername = new JTextField();
        pw = new JPasswordField();
        btnCreateAccount = new JButton("Create New Account");

        // labels
        lblUserName.setBounds(10,60, 90,25);
        lblPW1.setBounds(10, 90, 90, 25);
        lblPW2.setBounds(10, 120, 120, 25);

        // text fields
        txtUsername.setBounds(150, 60, 200,25);
        pw.setBounds(150, 90, 200,25);

        //buttons
        btnCreateAccount.setBounds(200, 160, 100, 30);
        btnCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = txtUsername.getText();
                password = pw.getText();

                    //Database connection
                    new DB_Connection().CreateNewPlayer(userName, password);

            }
        });

        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);
        panel.add(lblUserName);
        panel.add(lblPW1);
        panel.add(lblPW2);
        panel.add(txtUsername);
        panel.add(pw);
        panel.add(btnCreateAccount);

        // frame
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setResizable(false);
        frame.setTitle("Create Account");
        frame.pack();

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
