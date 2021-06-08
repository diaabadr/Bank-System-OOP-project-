
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class SelectEvent {

    Color buttonsColor = new Color(158, 196, 216);

    public SelectEvent(final BankSystem bankSystem) {

        final selectEventFrame sEventFrame = new selectEventFrame("Select Event");

        ActionListener withdrawAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankSystem.getMainAccount().withDraw(sEventFrame);
            }
        };

        ActionListener deposiAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankSystem.getMainAccount().deposit(sEventFrame);
            }
        };

        ActionListener transferAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankSystem.searchForAccount(sEventFrame);
            }
        };

        ActionListener changePWordAction = new ActionListener() {// for changing the password
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = JOptionPane.showInputDialog(sEventFrame, "please enter the new password");
                if (newPassword == null||newPassword.equals(null)||newPassword.isEmpty()) {
                    // Do nothing
                } else {
                    bankSystem.getMainAccount().setPassword(newPassword);
                    AccountData acc = new AccountData();
                    acc.update(bankSystem.getMainAccount());
                }
            }
        };

        ActionListener showInfoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				
                JOptionPane.showMessageDialog(sEventFrame, bankSystem.getMainAccount().showInfo());
            }
        };

        ActionListener debtPaymentAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bankSystem.getMainAccount().pay(sEventFrame);
            }
        };

        ActionListener logoutAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AccountData acc = new AccountData();
                acc.update(bankSystem.getMainAccount());
                sEventFrame.dispose();
            }
        };

        sEventFrame.withdrawButton.addActionListener(withdrawAction);
        sEventFrame.depositButton.addActionListener(deposiAction);
        sEventFrame.transferButton.addActionListener(transferAction);
        sEventFrame.changePWordButton.addActionListener(changePWordAction);
        sEventFrame.showInfoButton.addActionListener(showInfoAction);
        sEventFrame.debtPaymentButton.addActionListener(debtPaymentAction);
        sEventFrame.logoutButton.addActionListener(logoutAction);

        WindowAdapter wa = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                AccountData acc = new AccountData();
                acc.update(bankSystem.getMainAccount());
                sEventFrame.dispose();
            }
        };

        sEventFrame.addWindowListener(wa);
    }

}
