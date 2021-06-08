
import javax.swing.JOptionPane;

public class BankSystem {

    private Account mainAccount;

    public BankSystem() {

    }

    public Account getMainAccount() {
        return mainAccount;
    }

    public boolean addAccount(String cName, String uName, String password, SignUpFrame frame) { // return false if the
                                                                                                // account is added
                                                                                                // successfully

        boolean check = false;
        while (true) {
            if (cName.isEmpty() || uName.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please Enter all the data required ");
                check = true;
                break;
            } else {
                String[] options = { "Personal", "VIP" };
                int i = JOptionPane.showOptionDialog(frame, "choose account type", "account type",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (i == 0) {
                    mainAccount = new Personal();
                    mainAccount.readData(cName, uName, password);
                    break;
                } else if (i == 1) {
                    mainAccount = new VIP();
                    mainAccount.readData(cName, uName, password);
                    break;
                } else {
                    JOptionPane.showMessageDialog(frame, "you must choose account type");
                }
            }
        }
        return check;
    }

    public boolean openAccount(String uName, String password, LoginFrame frame) { // return true if the account has been open successfully

        boolean check = false;

        while (true) {

            AccountData acc = new AccountData();
            Account account = acc.findByUserName(uName);
            try {

                account.setID(account.setID());
                acc.update(account);
                check = true;
                mainAccount = account;

            } catch (Exception e) {
            }

            if (!check) {
                JOptionPane.showMessageDialog(frame, "Wrong user name");
                break;
            } else {
                if (!mainAccount.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(frame, "wrong password");
                    check = false;
                    break;
                } else {
                    if (account.isBlocked()) {
                        JOptionPane.showMessageDialog(frame, "Sorry,you are blocked you have to go to the bank");
                        return false;
                    }
                    break;
                }
            }
        }
        return check;
    }

    public void searchForAccount(selectEventFrame frame) {  // to search for account by ID for transfer process

        String id = JOptionPane.showInputDialog(frame, "Enter ID of the account");
        AccountData acc = new AccountData();
        if (id != null) {
            if (acc.CheckID(id) && !mainAccount.getID().equals(id)) {
                Account account = acc.findByID(id);
                if (account.isBlocked()) {
                    JOptionPane.showMessageDialog(frame, "This account is banned");
                    return;
                }
                double amount = 0;
                try {
                    amount = Double.parseDouble(JOptionPane.showInputDialog(frame, "please put amount of money"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "please Enter numbers!");
                }
                mainAccount.transferAmount(amount, account, frame);
            } else {
                JOptionPane.showMessageDialog(frame, "Wrong ID");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Wrong ID");
        }
    }
}
