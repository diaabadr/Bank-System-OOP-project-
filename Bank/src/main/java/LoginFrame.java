
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

    protected final JTextField username = new JTextField(20);
    protected final JPasswordField password = new JPasswordField(20);
    protected JButton loginButton = new JButton("login");
    protected JLabel uNameLabel = new JLabel("user name");
    protected JLabel pWordLabel = new JLabel("password");
    protected JCheckBox showPassword;

    public LoginFrame(String name) {
        super(name);
        setVisible(true);

        ImageIcon loginIcon = new ImageIcon("image/final-01.png");
        JLabel loginImage = new JLabel(loginIcon);
        loginImage.setBounds(10, -35, 350, 315);
        this.add(loginImage);
         showPassword=new JCheckBox("Show Password");
        showPassword.setBounds(131, 325, 110, 20);
        uNameLabel.setBounds(116, 228, 80, 20);
        pWordLabel.setBounds(116, 278, 80, 20);
        uNameLabel.setForeground(Color.white);
        pWordLabel.setForeground(Color.white);
        username.setBounds(115, 250, 150, 20);
        password.setBounds(115, 300, 150, 20);
        loginButton.setBackground(new Color(158, 196, 216));
        loginButton.setBounds(137, 355, 100, 30);
         showPassword.setFont(new Font(showPassword.getFont().getName(), showPassword.getFont().getStyle(), 10));
        this.setBounds(400, 200, 400, 450);
        this.getContentPane().setBackground(new Color(10, 56, 81));
        this.add(uNameLabel);
        this.add(username);
        this.add(pWordLabel);
        this.add(password);
        this.add(showPassword);
        this.add(loginButton);
        this.setLayout(null);
        setDefaultCloseOperation(MainFrame.DO_NOTHING_ON_CLOSE);
    }

}
