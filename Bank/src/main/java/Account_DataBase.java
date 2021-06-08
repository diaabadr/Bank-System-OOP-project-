import java.util.List;
public interface Account_DataBase {

	public List<Account> findAll();
        
	Boolean CheckuserName(String userName);
        
	Account findByUserName(String userName);

	void create(Account account);
	
	void update(Account account);
	
	public Account findByID(String ID);

	Boolean CheckID(String ID);
}
