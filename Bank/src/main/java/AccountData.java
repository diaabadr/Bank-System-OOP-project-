
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

public class AccountData implements Account_DataBase {

    @Override
    public List<Account> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Account findByID(String ID) {
        Connection con = DataBase_connection.getConnection();
        if (con == null) {
            return null;
        }
        String query = "SELECT * FROM accounts WHERE ID =?;";

        try ( PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, ID);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                Account account = new Account(result.getString("accountType"), result.getDouble("allowableLimit_perDay"));

                account.setUserName(result.getString("userName"));
                account.setID(result.getString("ID"));
                account.setPassword(result.getString("password"));
                account.setAccountType(result.getString("accountType"));
                account.setClientName(result.getString("clientName"));
                account.setBalance(result.getDouble("balance"));
                account.setIndebtedness(result.getDouble("indebtedness"));
                account.setStatus(result.getBoolean("status"));
                account.setAllowableLimit(result.getDouble("allowableLimit_perDay"));
                account.setcCardDate(result.getDate("creditCardDate").toLocalDate());
                account.setCreatingDate(result.getDate("creatingDate").toLocalDate());
                account.setdebitDate(result.getDate("debitDate").toLocalDate());
                account.setNumOfAcc(result.getInt("numOfaccounts"));

                return account;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Boolean CheckuserName(String userName) { // if the userName is exist it returns true if it doens't exist it returns false
        Connection con = DataBase_connection.getConnection();
        if (con == null) {
            return false;
        }

        String query = "SELECT * FROM accounts WHERE userName =?;";
        try ( PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, userName);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (SQLException se) {
            se.printStackTrace();

        }
        return false;
    }

    @Override
    public Account findByUserName(String userName) {
        Connection con = DataBase_connection.getConnection();
        if (con == null) {
            return null;
        }
        String query = "SELECT * FROM accounts WHERE userName =?;";

        try ( PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, userName);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                Account account = new Account(result.getString("accountType"), result.getDouble("allowableLimit_perDay"));

                account.setUserName(result.getString("userName"));
                account.setID(result.getString("ID"));
                account.setPassword(result.getString("password"));
                account.setAccountType(result.getString("accountType"));
                account.setClientName(result.getString("clientName"));
                account.setBalance(result.getDouble("balance"));
                account.setIndebtedness(result.getDouble("indebtedness"));
                account.setStatus(result.getBoolean("status"));
                account.setAllowableLimit(result.getDouble("allowableLimit_perDay"));
                account.setcCardDate(result.getDate("creditCardDate").toLocalDate());
                account.setCreatingDate(result.getDate("creatingDate").toLocalDate());
                account.setdebitDate(result.getDate("debitDate").toLocalDate());
                account.setNumOfAcc(result.getInt("numOfaccounts"));

                return account;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void create(Account acc) {
        // TODO Auto-generated method stub

        Connection con = DataBase_connection.getConnection();
        if (con == null) {
            return;
        }

        { // create
            String query = "INSERT INTO accounts (userName,ID,password,clientName,accountType,balance"
                    + ",indebtedness,status,allowableLimit_perDay,creatingDate,creditCardDate,debitDate) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

            try ( PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, acc.getUserName());
                preparedStatement.setString(2, acc.getID());
                preparedStatement.setString(3, acc.getPassword());
                preparedStatement.setString(4, acc.getClientName());
                preparedStatement.setString(5, acc.getAccountType());
                preparedStatement.setDouble(6, acc.getBalance());
                preparedStatement.setDouble(7, acc.getIndebtedness());
                preparedStatement.setBoolean(8, acc.getStatus());
                preparedStatement.setDouble(9, acc.getAllowableLimit());
                preparedStatement.setDate(10, Date.valueOf(acc.getCreatingDate()));
                preparedStatement.setDate(11, Date.valueOf(acc.getcCardDate()));
                preparedStatement.setDate(12, Date.valueOf(acc.getdebitDate()));

                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public void update(Account account) {
        // TODO Auto-generated method stub

        Connection con = DataBase_connection.getConnection();
        if (con == null) {
            return;
        }

        String query = "UPDATE accounts SET balance=? , indebtedness=? ,status=?,allowableLimit_perDay=? , creditCardDate=?"
                + " ,debitDate =?,password=?,ID=? WHERE userName=?;";

        try ( PreparedStatement preparedStatment = con.prepareStatement(query)) {

            preparedStatment.setDouble(1, account.getBalance());
            preparedStatment.setDouble(2, account.getIndebtedness());
            preparedStatment.setBoolean(3, account.getStatus());
            preparedStatment.setDouble(4, account.getAllowableLimit());
            preparedStatment.setDate(5, Date.valueOf(account.getcCardDate()));
            preparedStatment.setDate(6, Date.valueOf(account.getdebitDate()));
            preparedStatment.setString(7, account.getPassword());
            preparedStatment.setString(8, account.getID());
            preparedStatment.setString(9, account.getUserName());
            preparedStatment.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public Boolean CheckID(String ID) {
        // TODO Auto-generated method stub
        Connection con = DataBase_connection.getConnection();
        if (con == null) {
            return false;
        }

        String query = "SELECT * FROM accounts WHERE ID =?;";
        try ( PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, ID);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (SQLException se) {
            se.printStackTrace();

        }
        return false;
    }

}
