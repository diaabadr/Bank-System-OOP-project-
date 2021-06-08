import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GUI {

    Color buttonsColor = new Color(158, 196, 216);
    Color framesColor = new Color(10, 56, 81);
    BankSystem bankSystem = new BankSystem();

    public GUI() {
        final MainFrame mainFrame = new MainFrame("Bank System");

        ActionListener loginAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final LoginFrame loginFrame = new LoginFrame("Login");
                ActionListener loginAction2 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        if (bankSystem.openAccount(loginFrame.username.getText(), loginFrame.password.getText(),
                                loginFrame)) {
                            loginFrame.dispose();
                            new SelectEvent(bankSystem);
                        }
                    }
                };
                loginFrame.loginButton.addActionListener(loginAction2);
                loginFrame.showPassword.addActionListener(ae -> {
                    loginFrame.showPassword = (JCheckBox) ae.getSource();
                    loginFrame.password.setEchoChar(loginFrame.showPassword.isSelected() ? '\u0000'
                            : (Character) UIManager.get("PasswordField.echoChar"));
                });
                WindowAdapter wa3 = new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        loginFrame.dispose();
                    }
                };

                loginFrame.addWindowListener(wa3);
            }
        };

        ActionListener signupAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final SignUpFrame signUpFrame = new SignUpFrame("Sign Up");

                ActionListener signupAction = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        AccountData ac = new AccountData();
                        if (!ac.CheckuserName(signUpFrame.uNameField.getText())) {

                            if (!(bankSystem.addAccount(signUpFrame.nameField.getText(),
                                    signUpFrame.uNameField.getText(), signUpFrame.pWordField.getText(), signUpFrame))) {
                                double balancetest = moneyExceptions(signUpFrame);
                                if (balancetest != 0) {
                                    bankSystem.getMainAccount().setBalance(balancetest);
                                    signUpFrame.dispose();
                                    ac.create(bankSystem.getMainAccount());
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(signUpFrame,
                                    "this user name used before \nuse another user name");
                        }
                    }
                };

                signUpFrame.signupButton.addActionListener(signupAction);
                signUpFrame.showPassword.addActionListener(ae -> {
                    signUpFrame.showPassword = (JCheckBox) ae.getSource();
                    signUpFrame.pWordField.setEchoChar(signUpFrame.showPassword.isSelected() ? '\u0000'
                            : (Character) UIManager.get("PasswordField.echoChar"));
                });
                WindowAdapter wa2 = new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        signUpFrame.dispose();
                    }
                };

                signUpFrame.addWindowListener(wa2);
            }
        };

        ActionListener exitAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        };
        mainFrame.loginButton.addActionListener(loginAction);
        mainFrame.signupButton.addActionListener(signupAction);
        mainFrame.exitButton.addActionListener(exitAction);

        WindowAdapter wa1 = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.dispose();
            }
        };

        mainFrame.addWindowListener(wa1);
    }

    public double moneyExceptions(SignUpFrame frame) {
        double leastMoney = 100;

        if (bankSystem.getMainAccount().getAccountType().equals("VIP")) {
            leastMoney = 50000;
        }
        while (true)
            try {

                double money = Double
                        .parseDouble(JOptionPane.showInputDialog(frame, "entre money at least $" + leastMoney));
                if (money >= leastMoney) {
                    return money;
                } else {
                    JOptionPane.showMessageDialog(frame, "please enter at least $" + leastMoney);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "please enter numbers");
                return 0;
            }
    }

}
