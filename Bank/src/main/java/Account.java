
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

public class Account {

    private String clientName;
    private String ID; // unique for every account
    private String userName; // unique for every account
    private String password;
    public static int numOfaccounts = 0;
    protected double balance;
    protected double indebtedness;
    protected boolean status;
    protected double allowableLimit_perDay;
    private LocalDate creatingDate;
    protected LocalDate creditCardDate;
    protected LocalDate debitDate;
    private String accountType = null;

    public Account(String accountType, double allowable) {
        userName = null;
        password = null;
        clientName = null;
        balance = 0;
        indebtedness = 0;
        allowableLimit_perDay = allowable;
        status = false;
        creditCardDate = LocalDate.now();
        creatingDate = LocalDate.now();
        debitDate = LocalDate.now();// (it's just initializing not affect the method if blocked because it's status
                                    // still false
        ID = setID();
        numOfaccounts++;
        this.accountType = accountType;
    }

    public void setCreatingDate(LocalDate date) {
        this.creatingDate = date;
    }

    public LocalDate getCreatingDate() {
        return creatingDate;
    }

    public void setClientName(String cName) {
        clientName = cName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String setID() { // it set the ID by it's creating Date beside it's number at the bank

        long var = (long) creatingDate.getYear() * 10000000 + (long) creatingDate.getMonthValue() * 100000
                + (long) creatingDate.getDayOfMonth() * 1000 + (long) numOfaccounts;
        return new String(var + "");

    }

    public String getID() {
        return ID;
    }

    public void setUserName(String uName) {
        userName = uName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String pWord) {
        password = pWord;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double balance) {
        this.balance = balance > 0 ? balance : 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setIndebtedness(double indebtedness) {
        this.indebtedness = indebtedness > 0 ? indebtedness : 0;
    }

    public double getIndebtedness() {
        return indebtedness;
    }

    public void setStatus(boolean stat) {
        status = stat;
    }

    public boolean getStatus() {
        return status;
    }

    public void setAllowableLimit(double aLimit) {
        allowableLimit_perDay = aLimit > 0 ? aLimit : 0;
    }

    public double getAllowableLimit() {
        return allowableLimit_perDay;
    }

    public void setcCardDate(LocalDate date) {
        creditCardDate = date;
    }

    public LocalDate getcCardDate() {
        return creditCardDate;
    }

    public void setdebitDate(LocalDate date) {
        debitDate = date;
    }

    public LocalDate getdebitDate() {
        return debitDate;
    }

    public void setAccountType(String vip) {
        accountType = vip;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setNumOfAcc(int num) {
        numOfaccounts = num;
    }

    public int getNumOfAcc() {
        return numOfaccounts;
    }

    public void readData(String cName, String uName, String pWord) {
        clientName = cName;
        userName = uName;
        password = pWord;

    }

    public void withDraw(selectEventFrame frame) {
        long d1 = (long) creditCardDate.getYear() * 10000 + (long) creditCardDate.getMonthValue() * 100
                + (long) creditCardDate.getDayOfMonth();
        long d2 = (long) LocalDate.now().getYear() * 10000 + (long) LocalDate.now().getMonthValue() * 100
                + (long) LocalDate.now().getDayOfMonth();
        if (d2 - d1 != 0) { // to update the max allowable limit if the last withdraw process wasn't today
            allowableLimit_perDay = 8000;
        }

        while (true) {
            String str = JOptionPane.showInputDialog(frame, "please entre amount of money");
            if (str == null) {
                break;
            } else {
                try {
                    double money = Double.parseDouble(str);
                    if (money >= 1) {
                        if (balance >= money) { // check if he has enough Money

                            if (allowableLimit_perDay >= money) { // check if he didn't take it's allowable limit per
                                                                  // day
                                balance -= money;
                                allowableLimit_perDay -= money;
                                creditCardDate = LocalDate.now();
                                JOptionPane.showMessageDialog(frame, "Successful operation");
                                break;
                            } else if (allowableLimit_perDay < money && allowableLimit_perDay != 0) {
                                double aLimitForPrinting = 0;
                                balance -= allowableLimit_perDay;
                                aLimitForPrinting = allowableLimit_perDay;
                                allowableLimit_perDay = 0;
                                creditCardDate = LocalDate.now();
                                JOptionPane.showMessageDialog(frame, "Successful operation but with just $"
                                        + aLimitForPrinting + " (this is the maximum allowable amount per day)");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(frame,
                                        "you reached the maximum allowable limit per day)");
                                break;
                            }
                        } else if (balance < money && balance != 0) { // if he hasn't enough money i will give him it's
                                                                      // balance
                            if (balance >= allowableLimit_perDay && allowableLimit_perDay != 0) {// check allowable
                                                                                                 // limit
                                JOptionPane.showMessageDialog(frame,
                                        "You can't take more than" + allowableLimit_perDay + " today");
                                money = allowableLimit_perDay;
                                balance -= allowableLimit_perDay;
                                allowableLimit_perDay = 0;
                                break;
                            } else if (balance < allowableLimit_perDay) {
                                JOptionPane.showMessageDialog(frame, "you can not take more than " + balance);
                                money = balance;
                                allowableLimit_perDay -= balance;
                                balance = 0;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(frame,
                                        "you reached the maximum allowable limit per day)");
                                break;
                            }
                        } else if (balance == 0) { // if he hasn't money

                            if (indebtedness != 5000) { // check if it's loans doesn't exceed the max limit for loans

                                String[] options = { "yes", "No" };

                                int i = JOptionPane.showOptionDialog(frame,
                                        "You haven't enough money , Do you accept to borrow with 10% Bank interest",
                                        "loan", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                        options, options[0]);

                                if (i == 0) {
                                    money = borrow(money);
                                    break;
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(frame, "you have reached the max loan");
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid amount,please enter at least 1$ : ");
                    }
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(frame, "Error , Enter numbers");
                    return;
                }
            }
        }
    }

    public double borrow(double money) {

        if (money < (5000 - indebtedness)) { // check if he want's money more than it's alloawable limit for loans
            status = true;
            indebtedness += money;
            debitDate = LocalDate.now();
            return money;
        } else {
            debitDate = LocalDate.now();
            double restOfmoney = 5000 - indebtedness;
            indebtedness = 5000;
            status = true;
            return restOfmoney;
        }
    }

    public boolean isBlocked() { // it will be used to close accounts

        if (status) {
            Period period = Period.between(debitDate, LocalDate.now());
            if (period.getYears() >= 1 || period.getMonths() >= 2) {
                return true;
            }
        }
        return false;
    }

    public void deposit(selectEventFrame frame) {

        if (status) { // check if he owe the bank

            String[] options = { "yes", "no" };

            JOptionPane.showMessageDialog(frame, "you must first pay your loans");

            int i = JOptionPane.showOptionDialog(frame, "Do you wnat to pay now", "Paying Loans",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (i == 0) {
                pay(frame);// method for debt payment
            }
        } else {
            String str = JOptionPane.showInputDialog(frame, "please put the money");
            if (str == null) {
                // Do nothing
            } else {
                try {
                    double money = Double.parseDouble(str);
                    balance += money;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "please put numbers only");
                }
            }
        }
    }

    public void pay(selectEventFrame frame) { // to pay it's loans
        double money = 0;

        if (status) {
            JOptionPane.showMessageDialog(frame, "You owe the bank " + (indebtedness + 0.1 * indebtedness));
            try {
                money = Double.parseDouble(JOptionPane.showInputDialog(frame, "please put the money"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "please enter numbers");
                return;
            }
            if (money == (indebtedness + 0.1 * indebtedness)) { // to calculate the interest
                indebtedness = 0;
                status = false;
            } else if (money > (indebtedness + 0.1 * indebtedness)) {
                JOptionPane.showMessageDialog(frame,
                        "successful operation .the rest is $" + (money - (indebtedness + 0.1 * indebtedness)));
                balance = money - (indebtedness + 0.1 * indebtedness);
                indebtedness = 0;
                status = false;
            } else {
                JOptionPane.showMessageDialog(frame, "you must pay all your loans at once");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "You don't owe the bank any money");
        }
    }

    public void transferAmount(double amount, Account account, selectEventFrame frame) // transfer amount of money to
                                                                                       // another account
    {
        if (this.getBalance() >= amount) {
            account.setBalance(account.getBalance() + amount);
            this.setBalance(this.getBalance() - amount);

            AccountData acc = new AccountData();
            acc.update(account);

        } else {
            JOptionPane.showMessageDialog(frame, "You haven't enough money");
        }
    }

    public String showInfo() {
        return "name : " + clientName + "\nID : " + ID + "\nbalance : $" + balance + "\nindebtedness : $"
                + (indebtedness + 0.1 * indebtedness) + "\nAccount type: " + accountType;

    }
}
