
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class selectEventFrame extends JFrame {

    protected JButton withdrawButton = new JButton("Withdraw");
    protected JButton depositButton = new JButton("Deposit");
    protected JButton transferButton = new JButton("Transfer amount");
    protected JButton changePWordButton = new JButton("Change password");
    protected JButton showInfoButton = new JButton("Show information");
    protected JButton debtPaymentButton = new JButton("Debt payment");
    protected JButton logoutButton = new JButton("Logout");

    public selectEventFrame(String name) {
        super(name);
        setVisible(true);
        Color buttonsColor = new Color(158, 196, 216);
        ImageIcon logoIcon = new ImageIcon("image/final-01.png");
        JLabel sEventImg = new JLabel(logoIcon);
        withdrawButton.setBackground(buttonsColor);
        depositButton.setBackground(buttonsColor);
        transferButton.setBackground(buttonsColor);
        changePWordButton.setBackground(buttonsColor);
        showInfoButton.setBackground(buttonsColor);
        debtPaymentButton.setBackground(buttonsColor);
        logoutButton.setBackground(buttonsColor);
        withdrawButton.setBounds(35, 240, 138, 30);
        depositButton.setBounds(225, 240, 138, 30);
        transferButton.setBounds(35, 280, 138, 30);
        debtPaymentButton.setBounds(225, 280, 138, 30);
        showInfoButton.setBounds(35, 320, 138, 30);
        changePWordButton.setBounds(225, 320, 138, 30);
        logoutButton.setBounds(145, 360, 110, 35);
        sEventImg.setBounds(10, -35, 350, 315);
        logoutButton.setFont(new Font(logoutButton.getFont().getName(), logoutButton.getFont().getStyle(), 16));
        this.setBounds(400, 200, 400, 450);
        this.getContentPane().setBackground(new Color(10, 56, 81));
        this.add(withdrawButton);
        this.add(depositButton);
        this.add(transferButton);
        this.add(debtPaymentButton);
        this.add(showInfoButton);
        this.add(changePWordButton);
        this.add(logoutButton);
        this.add(sEventImg);
        this.setLayout(null);
        setDefaultCloseOperation(MainFrame.DO_NOTHING_ON_CLOSE);
    }

}
