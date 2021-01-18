import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Login frame
public class LogIn extends  JFrame{

    private JFrame frame;
    private JPanel panel;
    private JButton btnLogIn, btnCreate;
    private JLabel lblUserName, lblPassword;
    private JTextField txtUserName, passwordField;

    private String username;
    private String password;

    public LogIn(String title){

        super(title);

        frame = new JFrame();
        panel = new JPanel();
        btnLogIn = new JButton("Log-in");
        btnCreate = new JButton("Create Account");
        lblUserName = new JLabel("Username: ");
        lblPassword = new JLabel("Password: ");
        txtUserName = new JTextField();
        passwordField = new JTextField();

        //labels
        lblUserName.setBounds(10,60, 70,25);
        lblPassword.setBounds(10, 90, 70, 25);

        // Text and password fields
        txtUserName.setBounds(80, 60, 200,25);
        passwordField.setBounds(80, 90, 200,25);

        //Buttons
        btnLogIn.setBounds(200, 130, 100, 30);
        btnCreate.setBounds(30, 130, 100, 30);

        //Create account button action listener
        btnCreate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new CreateAccount();
                }
            }
        );

        // Login button action listener
        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = txtUserName.getText();
                password = passwordField.getText();
                // TODO: username ve password girmeyince hata versin
                if(username == null || password == null){
                    JOptionPane.showMessageDialog(frame,"Please Write Correct Username and Password");
                }
                else {
                    new DB_Connection().LoginDB(username, password);
                }
            }
        });

        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);
        panel.add(lblUserName);
        panel.add(lblPassword);
        panel.add(txtUserName);
        panel.add(passwordField);
        panel.add(btnLogIn);
        panel.add(btnCreate);

        //Frame
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.pack();

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

}
