
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpFrame extends JFrame {

    protected JButton signupButton = new JButton("sign up");
    protected JLabel nameLabel = new JLabel("name");
    protected JLabel uNameLabel = new JLabel("User Name");
    protected JLabel pWordLabel = new JLabel("Password");
    protected final JTextField nameField = new JTextField(20);
    protected final JTextField uNameField = new JTextField(20);
    protected final JPasswordField pWordField = new JPasswordField(20);
    protected JCheckBox showPassword;

    public SignUpFrame(String name) {
        super(name);
        setVisible(true);
        ImageIcon signUpIcon = new ImageIcon("image/final-01.png");
        JLabel signUpImg = new JLabel(signUpIcon);
        showPassword=new JCheckBox("Show Password");
        showPassword.setBounds(131, 342, 110, 20);
        nameLabel.setBounds(114, 195, 80, 20);
        uNameLabel.setBounds(114, 245, 80, 20);
        pWordLabel.setBounds(114, 295, 80, 20);
        nameLabel.setForeground(Color.WHITE);
        uNameLabel.setForeground(Color.WHITE);
        pWordLabel.setForeground(Color.WHITE);
        nameField.setBounds(113, 217, 150, 20);
        uNameField.setBounds(113, 267, 150, 20);
        pWordField.setBounds(113, 317, 150, 20);
        signUpImg.setBounds(10, -35, 350, 315);
        showPassword.setFont(new Font(showPassword.getFont().getName(), showPassword.getFont().getStyle(), 10));
        signupButton.setBounds(137, 368, 100, 30);
        signupButton.setBackground(new Color(158, 196, 216));
        this.add(nameLabel);
        this.add(nameField);
        this.add(uNameLabel);
        this.add(uNameField);
        this.add(pWordLabel);
        this.add(pWordField);
        this.add(signupButton);
        this.add(showPassword);
        this.setBounds(400, 200, 400, 450);
        this.getContentPane().setBackground(new Color(10, 56, 81));
        this.add(signUpImg);
        this.setLayout(null);
        setDefaultCloseOperation(MainFrame.DO_NOTHING_ON_CLOSE);
    }

}
