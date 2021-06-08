
import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    protected JButton loginButton = new JButton("login");
    protected JButton signupButton = new JButton("Sign up");
    protected JButton exitButton = new JButton("Exit");

    public MainFrame(String name) {
        super(name);
        setVisible(true);
        this.setBounds(400, 200, 400, 450);
        this.getContentPane().setBackground(new Color(10, 56, 81));
        ImageIcon mainIcon = new ImageIcon("image/final-01.png");
        JLabel mainImage = new JLabel(mainIcon);
        this.add(mainImage);
        mainImage.setBounds(10, -10, 350, 315);

        loginButton.setBounds(150, 265, 80, 20);
        signupButton.setBounds(150, 305, 80, 20);
        exitButton.setBounds(150, 345, 80, 20);

        loginButton.setBackground(new Color(158, 196, 216));
        signupButton.setBackground(new Color(158, 196, 216));
        exitButton.setBackground(new Color(158, 196, 216));

        this.add(loginButton);
        this.add(signupButton);
        this.add(exitButton);
        setDefaultCloseOperation(MainFrame.DO_NOTHING_ON_CLOSE);
    }

}
